package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.api.Lugar;
import aiss.model.api.repository.MapWITMRepository;

@Path("/places")
public class LugarResource {
	private static LugarResource _instance = null;
	MapWITMRepository repository;

	private LugarResource() {
		repository = MapWITMRepository.getInstance();
	}

	public static LugarResource getInstance() {
		if (_instance == null) {
			_instance = new LugarResource();
		}
		return _instance;
	}

	// Obtiene un lugar
	@GET
	@Path("/{placeId}")
	@Produces("application/json")
	public Lugar get(@PathParam("placeId") String placeId) {
		Lugar place = repository.getLugar(placeId);
		if (place == null) {
			throw new NotFoundException("The place with id=" + placeId + "doesn't exist");
		}
		return place;
	}

	// Obtiene los lugares
	@GET
	@Produces("application/json")
	public Collection<Lugar> getAll() {
		return repository.getLugares();
	}

	// Obtiene los lugares con un nombre
	@GET
	@Path("/search")
	@Produces("application/json")
	public Collection<Lugar> getPlacesByName(@QueryParam("name") String name) {
		Collection<Lugar> places = repository.getLugaresByName(name);
		if (places == null) {
			throw new NotFoundException("The place with name=" + name + "doesn't exist");
		}
		return places;
	}

	// Añade un lugar
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlace(@Context UriInfo uriInfo, Lugar place) {
		if (place.getId() == null || "".equals(place.getId())) {
			throw new BadRequestException("The name of the place must not be null");
		}
		repository.addLugar(place);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(place.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(place);
		return resp.build();
	}

	// Elimina un lugar
	@DELETE
	@Path("/{placeId}")
	public Response removePlace(@PathParam("placeId") String placeId) {
		Lugar place = repository.getLugar(placeId);
		if (place == null) {
			throw new NotFoundException("The place with id=" + placeId + " was not found");
		}
		repository.removeLugar(placeId);
		return Response.noContent().build();
	}

}