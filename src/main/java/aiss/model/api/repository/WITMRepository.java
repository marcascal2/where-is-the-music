package aiss.model.api.repository;

import java.util.Collection;

import aiss.model.api.Artista;
import aiss.model.api.Cancion;
import aiss.model.api.Evento;
import aiss.model.api.Lugar;

public interface WITMRepository {
	// Métodos de eventos
	public Evento getEvento(String id);

	public Collection<Evento> getEventos();

	public void addEvento(Evento e);

	public void addEventoArtista(String idEvento, Artista rtista);

	public void removeEventoArtista(String idEvento, Artista artista);

	public void updateEventoArtista(String idEvento, Artista artista);

	public void addEventoLugar(String idEvento, Lugar s);

	public void removeEventoLugar(String idEvento, String idLugar);

	public void updateEventoLugar(String idEvento, Lugar Lugar);

	public void updateEvento(Evento e);

	public void removeEvento(String id);

	public Lugar getLugarByEvento(String idEvento);

	// Métodos de lugar
	public Lugar getLugar(String id);

	public Collection<Lugar> getLugares();

	public Collection<Lugar> getLugaresByName(String name);

	public void addLugar(Lugar s);

	public void removeLugar(String id);

	public void addComment(String id_Lugar, String c);

	// Métodos de artistas
	public Artista getArtista(String id);

	public Collection<Artista> getArtistas();

	public void addArtista(Artista a);

	public void addArtistaCancion(String idArtista, Cancion c);

	public void removeArtistaCancion(String idArtista, Cancion c);

	public void removeArtista(String id);

	public void updateArtista(Artista a);

	// Métodos de canciones
	public Collection<Cancion> getAllCanciones();

	public Collection<Cancion> getCancionesByArtista(String idArtista);

	public Collection<Cancion> getCancionesByName(String name);
}