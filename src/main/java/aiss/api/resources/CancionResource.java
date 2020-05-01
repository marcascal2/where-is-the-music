package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.api.Cancion;
import aiss.model.api.repository.MapWITMRepository;


@Path("/tracks")
public class CancionResource {
	private static CancionResource _instance = null;
	MapWITMRepository repository;

	private CancionResource() {
		repository = MapWITMRepository.getInstance();
	}

	public static CancionResource getInstance() {
		if (_instance == null) {
			_instance = new CancionResource();
		}
		return _instance;
	}

	// Obtiene todas las canciones - FUNCIONA
	@GET
	@Produces("application/json")
	public Collection<Cancion> getAll() {
		return repository.getAllCanciones();
	}

	// Obtiene un Collection de canciones del artista con el id pasado como
	// parámetro - FUNCIONA
	@GET
	@Path("/{artistId}")
	@Produces("application/json")
	public Collection<Cancion> getByArtista(@PathParam("artistId") String artistId) {
		Collection<Cancion> list = repository.getCancionesByArtista(artistId);
		if (list == null) {
			throw new NotFoundException("There are not tracks for the artist with id=" + artistId);
		}
		return list;
	}
}