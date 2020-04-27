package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.api.Prediccion;
import aiss.model.api.repository.MapWITMRepository;

@Path("/predictions")
public class PrediccionResource {
	private static PrediccionResource _instance = null;
	MapWITMRepository repository;

	private PrediccionResource() {
		repository = MapWITMRepository.getInstance();
	}

	public static PrediccionResource getInstance() {
		if (_instance == null) {
			_instance = new PrediccionResource();
		}
		return _instance;
	}

	// Obtiene todas las predicciones
	@GET
	@Produces("application/json")
	public Collection<Prediccion> getAll() {
		return repository.getAllPredictions();
	}

	// Obtiene un Collection de predicciones del lugar con latitud y longitud
	// pasados como
	// parámetros
	@GET
	@Path("/lat={lat}&lon={lon}")
	@Produces("application/json")
	public Collection<Prediccion> getByPlace(@PathParam("lat") Double lat, @PathParam("lon") Double lon) {
		Collection<Prediccion> list = repository.getPredictionsByLatAndLon(lat, lon);
		if (list == null) {
			throw new NotFoundException("There are not predictions for place whit lat=" + lat + "and long=" + lon);
		}
		return list;
	}

	// Obtiene un Collection de predicciones del lugar con el id del lugar
	// pasado como
	// parámetro
	@GET
	@Path("/placeId={placeId}")
	@Produces("application/json")
	public Collection<Prediccion> getByPlace(@PathParam("placeId") String placeId) {
		Collection<Prediccion> list = repository.getPredictionsByPlace(placeId);
		if (list == null) {
			throw new NotFoundException("There are not predictions for place whit id=" + placeId);
		}
		return list;
	}
}
