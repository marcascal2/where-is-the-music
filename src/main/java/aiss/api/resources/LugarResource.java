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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.api.Lugar;
import aiss.model.api.Prediccion;
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

	// Obtiene un lugar - FUNCIONA
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

	// Obtiene los lugares - FUNCIONA
	@GET
	@Produces("application/json")
	public Collection<Lugar> getAll() {
		return repository.getLugares();
	}

	// Añade un lugar - FUNCIONA
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

	// Elimina un lugar - FUNCIONA
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

	// Elimina una prediccion de un lugar - FUNCIONA
	@DELETE
	@Path("/{placeId}/predictions/{predId}")
	public Response removePredictionOfPlace(@PathParam("placeId") String placeId, @PathParam("predId") String predId) {
		Collection<Prediccion> list = repository.getPredictionsByPlace(placeId);
		if (list == null) {
			throw new NotFoundException("There are not predictions for place whit id=" + placeId);
		}
		if (predId == null) {
			throw new BadRequestException("You have to introduce an predId");
		} else if (placeId == null) {
			throw new BadRequestException("You have to introduce a placeId");
		} else if (repository.getLugar(placeId).getPredicciones().contains(repository.getPrediccion(predId))) {
			repository.removePrediccion(placeId, predId);
			return Response.noContent().build();
		} else {
			throw new NotFoundException(
					"The prediction with id=" + predId + " is not located at the place with id=" + placeId);
		}
	}

	// Añade una prediccion a un lugar - FUNCIONA
	@POST
	@Path("/{placeId}/predictions/{predId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaceToEvent(@Context UriInfo uriInfo, @PathParam("placeId") String placeId,
			@PathParam("predId") String predId) {
		Lugar l = repository.getLugar(placeId);
		Prediccion p = repository.getPrediccion(predId);
		if (placeId == null || "".equals(placeId)) {
			throw new BadRequestException("The id of the place must not be null");
		} else if (predId==null || "".equals(predId)) {
			throw new BadRequestException("The id of the prediction must not be null");
		} else if (!l.getPredicciones().contains(p)) {
			repository.addLugarPrediccion(placeId, predId);
		} else {
			throw new BadRequestException(
					"Prediction with id =" + predId + " is already contained in place with id =" + placeId);
		}
		// Builds the response. Returns the event the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(placeId, predId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(l);
		return resp.build();
	}

}