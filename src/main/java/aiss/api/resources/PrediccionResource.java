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

	// Obtiene un Collection de predicciones del dia pasado como
	// parámetro
	@GET
	@Path("/{date}")
	@Produces("application/json")
	public Collection<Prediccion> getByDate(@PathParam("date") String date) {
		Collection<Prediccion> list = repository.getAllPredictionsByDay(date);
		if (list == null) {
			throw new NotFoundException("There are not predictions for day=" + date);
		}
		return list;
	}

	// Obtiene un Collection de predicciones del dia y hora pasado como
	// parámetro
	@GET
	@Path("/{dateTime}")
	@Produces("application/json")
	public Prediccion getByDateTime(@PathParam("dateTime") String dateTime) {
		Prediccion p = repository.getPredictionByDateTime(dateTime);
		if (p == null) {
			throw new NotFoundException("There are not predictions for dayTime=" + dateTime);
		}
		return p;
	}

	// Obtiene un Collection de predicciones del lugar con latitud y longitud pasados como
	// parámetros
	@GET
	@Path("/lat={lat}&lon={lon}")
	@Produces("application/json")
	public Collection<Prediccion> getByPlace(@PathParam("lat") Double lat, @PathParam("lon") Double lon) {
		Collection<Prediccion> list = repository.getPredictionsByPlace(lat, lon);
		if (list == null) {
			throw new NotFoundException("There are not predictions for place whit lat=" + lat + "and long=" + lon);
		}
		return list;
	}
}
