package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.api.Artista;
import aiss.model.api.Evento;
import aiss.model.api.Lugar;
import aiss.model.api.repository.MapWITMRepository;

@Path("/events")
public class EventoResource {
	private static EventoResource _instance = null;
	MapWITMRepository repository;

	private EventoResource() {
		repository = MapWITMRepository.getInstance();
	}

	public static EventoResource getInstance() {
		if (_instance == null) {
			_instance = new EventoResource();
		}
		return _instance;
	}

	// Obtiene el evento con el id pasado como parámetro - FUNCIONA
	@GET
	@Path("/{eventId}")
	@Produces("application/json")
	public Evento get(@PathParam("eventId") String id) {
		Evento event = repository.getEvento(id);
		if (event == null) {
			throw new NotFoundException("The event with id=" + id + "does not exist");
		}
		return event;
	}

	// Obtiene los eventos - FUNCIONA
	@GET
	@Produces("application/json")
	public Collection<Evento> getAll() {
		return repository.getEventos();
	}

	// Añade un evento - FUNCIONA
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addEvent(@Context UriInfo uriInfo, Evento event) {
		if (event.getNombre() == null || "".equals(event.getNombre())) {
			throw new BadRequestException("The event must not be null");
		}
		repository.addEvento(event);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(event.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(event);
		return resp.build();
	}

	// Añade un artista a un evento - FUNCIONA
	@POST
	@Path("/{eventId}/artists/{artistId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addArtistToEvent(@Context UriInfo uriInfo, @PathParam("eventId") String eventId,@PathParam("artistId") String artist) {
		Evento event = repository.getEvento(eventId);
		Artista artista = repository.getArtista(artist);
		if (event.getNombre() == null || "".equals(event.getNombre())) {
			throw new BadRequestException("The name of the event must not be null");
		} else if (artista.getNombre() == null || "".equals(artista.getNombre())) {
			throw new BadRequestException("The name of the artist must not be null");
		} else if (event.getArtistas().contains(artista)) {
			throw new BadRequestException("The artist with id=" + artist +" is already in this event");
		}
		repository.addEventoArtista(eventId, artista);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(event.getId(), artista.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(event);
		return resp.build();
	}

	// Elimina un artista de un evento - FUNCIONA
	@DELETE
	@Path("/{eventId}/artists/{artistId}")
	public Response removeArtistFromEvent(@PathParam("eventId") String eventId,
			@PathParam("artistId") String artist) {
		Evento event = repository.getEvento(eventId);
		Artista artista = repository.getArtista(artist);
		if (event == null) {
			throw new NotFoundException("The event with id=" + eventId + " was not found");
		} else if (artist == null) {
			throw new NotFoundException("The artist with id=" + artista.getId() + " was not found");
		}
		repository.removeEventoArtista(eventId, artista);
		return Response.noContent().build();
	}

	// Añade un lugar a un evento - FUNCIONA
	@POST
	@Path("/{eventId}/places/{lugarId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaceToEvent(@Context UriInfo uriInfo, @PathParam("eventId") String eventId,@PathParam("lugarId") String lugar) {
		Evento event = repository.getEvento(eventId);
		Lugar place = repository.getLugar(lugar);
		if (event.getNombre() == null || "".equals(event.getNombre())) {
			throw new BadRequestException("The name of the event must not be null");
		} else if (place.getNombre() == null || "".equals(place.getNombre())) {
			throw new BadRequestException("The name of the artist must not be null");
		}
		repository.addEventoLugar(eventId, place);
		// Builds the response. Returns the event the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(event.getId(), place.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(event);
		return resp.build();
	}

	// Obtiene el lugar de un evento - FUNCIONA
	@GET
	@Path("/{eventId}/places")
	@Produces("application/json")
	public Lugar getPlaceByEvent(@PathParam("eventId") String eventId) {
		Lugar place = repository.getLugarByEvento(eventId);
		if (place == null) {
			throw new NotFoundException("The event with id=" + eventId + " does not have a place");
		}
		return place;
	}

	//  Elimina un lugar de un evento - FUNCIONA
	@DELETE
	@Path("/{eventId}/places/{placeId}")
	public Response removePlaceFromEvent(@PathParam("eventId") String eventId, @PathParam("placeId") String placeId) {
		if (eventId == null) {
			throw new BadRequestException("You have to introduce an eventId");
		} else if (placeId == null) {
			throw new  BadRequestException("You have to introduce a placeId");
		} else if(repository.getLugarByEvento(eventId) == repository.getLugar(placeId)) {
			repository.removeEventoLugar(eventId, placeId);
			return Response.noContent().build();
		} else {
			throw new NotFoundException("The event with id="+ eventId +" is not located at the place with id=" + placeId);
		}
	}

	// Actualiza un evento - FUNCIONA 
	@PUT
	@Consumes("application/json")
	public Response updateEvent(Evento event) {
		Evento oldEvent = repository.getEvento(event.getId());
		if (oldEvent == null) {
			throw new NotFoundException("The event with id=" + event.getId() + " was not found");
		}
		// Update name
		if (event.getNombre() != null) {
			oldEvent.setNombre(event.getNombre());
		}
		// Update description
		if (event.getDescripcion() != null) {
			oldEvent.setDescripcion(event.getDescripcion());
		}
		// Update place
		if (event.getLugar() != null) {
			oldEvent.setLugar(event.getLugar());
		}
		// Update artistas
		if (event.getArtistas() != null) {
			oldEvent.setArtistas(event.getArtistas());
		}
		return Response.noContent().build();
	}

	//Elimina un evento - FUNCIONA
	@DELETE
	@Path("/{eventId}")
	public Response removeEvent(@PathParam("eventId") String eventId) {
		Evento event = repository.getEvento(eventId);
		if (event == null)
			throw new NotFoundException("The event with id=" + eventId + " was not found");
		else
			repository.removeEvento(eventId);

		return Response.noContent().build();
	}
}