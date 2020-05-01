package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.api.Artista;
import aiss.model.api.Cancion;
import aiss.model.api.repository.MapWITMRepository;

@Path("/artists")
public class ArtistaResource {
	
	/* Singleton */
	private static ArtistaResource _instance = null;
	MapWITMRepository repository;

	public ArtistaResource() {
		repository = MapWITMRepository.getInstance();
	}

	public static ArtistaResource getInstance() {
		if (_instance == null) {
			_instance = new ArtistaResource();
		}
		return _instance;
	}

	// Obtiene el artista con el id pasado como parámetro - FUNCIONA
	@GET
	@Path("/{artistId}")
	@Produces("application/json")
	public Artista getArtista(@PathParam("artistId") String id) {
		Artista artist = repository.getArtista(id);
		if (artist == null) {
			throw new NotFoundException("The artist with id=" + id + "doesn't exist");
		}
		return artist;
	}

	// Obtiene todos los artistas - FUNCIONA
	@GET
	@Produces("application/json")
	public Collection<Artista> getArtistas() {
		return repository.getArtistas();
	}

	// Añade un artista - FUNCIONA
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response añadeArtista(@Context UriInfo uriInfo, Artista artist) {
		if (artist.getId() == null || "".equals(artist.getId())) {
			throw new BadRequestException("The name of the artist must not be null");
		}
		repository.addArtista(artist);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(artist.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(artist);
		return resp.build();
	}

	// Añade una canción a un artista - FUNCIONA
	@POST
	@Path("/{artistId}/songs/{trackId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response añadeCancionArtista(@Context UriInfo uriInfo, @PathParam("artistId") String idArtista, @PathParam("trackId") String idCancion) {
		Artista art = repository.getArtista(idArtista);
		Cancion c = repository.getCancion(idCancion);
		if (idArtista == null || "".equals(idArtista)) {
			throw new BadRequestException("The id of the artist must not be null");
		} else if (idCancion==null || "".equals(idCancion)) {
			throw new BadRequestException("The id of the song must not be null");
		} else if (!art.getCanciones().contains(c)) {
			repository.addArtistaCancion(idArtista, idCancion);
		} else {
			throw new BadRequestException(
					"Song with id =" + idCancion + " is already contained into songs list of the artist with id =" + idArtista);
		}
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(idArtista, idCancion);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(art);
		return resp.build();
	}

	// Elimina una canción de un artista - FUNCIONA
	@DELETE
	@Path("/{artistId}/songs/{trackId}")
	public Response eliminaCancion(@PathParam("artistId") String idArtista, @PathParam("trackId") String idCancion) {
		if (idArtista == null) {
			throw new BadRequestException("You have to introduce an artistId");
		} else if (idCancion == null) {
			throw new  BadRequestException("You have to introduce an idCancion");
		} else if(repository.getCancionesByArtista(idArtista).contains(repository.getCancion(idCancion))) {
			repository.removeArtistaCancion(idArtista, idCancion);
			return Response.noContent().build();
		} else {
			throw new NotFoundException("The song with id="+ idCancion +" is not contained into songs list of artist with id=" + idArtista);
		}
	}

	// Elimina un artista - FUNCIONA
	@DELETE
	@Path("/{artistId}")
	public Response eliminaArtista(@PathParam("artistId") String artistId) {
		Artista artist = repository.getArtista(artistId);
		if (artist == null) {
			throw new NotFoundException("The artist with id=" + artistId + " was not found");
		}
		repository.eliminaArtista(artistId);;
		return Response.noContent().build();
	}

	// Actualiza un artista - FUNCIONA
	@PUT
	@Consumes("application/json")
	public Response actualizaArtista(Artista artist) {
		Artista oldArtist = repository.getArtista(artist.getId());
		if (oldArtist == null) {
			throw new NotFoundException("The playlist with id=" + artist.getId() + " was not found");
		} 
		// Update name
		if (artist.getNombre() != null) {
			oldArtist.setNombre(artist.getNombre());
		}
		// Update generos
		if (artist.getGeneros() != null) {
			oldArtist.setGeneros(artist.getGeneros());
		}
		// Update popularidad
		if (artist.getPopularidad() != null) {
			oldArtist.setPopularidad(artist.getPopularidad());
		}
		// Update canciones
		if (artist.getCanciones() != null) {
			oldArtist.setCanciones(artist.getCanciones());
		}
		return Response.noContent().build();
	}

}