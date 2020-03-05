package aiss.model.api.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.api.Artista;
import aiss.model.api.Cancion;
import aiss.model.api.Evento;
import aiss.model.api.Lugar;

public class MapWITMRepository {
	Map<String, Evento> eventosMap;
	Map<String, Lugar> lugaresMap;
	Map<String, Artista> artistasMap;
	private static MapWITMRepository instance;

	public static MapWITMRepository getInstance() {

		if (instance == null) {
			instance = new MapWITMRepository();
			instance.inicializar();
		}

		return instance;
	}

	public void inicializar() {
		eventosMap = new HashMap<String, Evento>();
		lugaresMap = new HashMap<String, Lugar>();
		artistasMap = new HashMap<String, Artista>();

		   //CREO UN LUGAR
			Lugar l = new Lugar();
			l.setId("1");
			l.setNombre("San Pablo");
			l.setCodigoPostal(41015);
			l.setDireccion("San Pablo-Santa Justa -  Sevilla");
			l.setLat(15.8);
			l.setLon(47.0);
			addLugar(l);
			
			Lugar l1 = new Lugar();
			l1.setId("2");
			l1.setNombre("Sala Even");
			l1.setCodigoPostal(41040);
			l1.setDireccion("Camino de los descubrimientos - Sevilla");
			l1.setLat(5.0);
			l1.setLon(40.3);
			addLugar(l1);
			
			Lugar l2 = new Lugar();
			l2.setId("3");
			l2.setNombre("Sala CUSTOM");
			l2.setCodigoPostal(41006);
			l2.setDireccion("Avenida de Jerez");
			l2.setLat(7.7);
			l2.setLon(50.2);
			addLugar(l2);
			
			Lugar l3 = new Lugar();
			l3.setId("4");
			l3.setNombre("Teatro Tour");
			l3.setCodigoPostal(43210);
			l3.setDireccion("Calle del Monasterio de El Paular - Madrid");
			l3.setLat(83.2);
			l3.setLon(31.5);
			addLugar(l3);
			
			Lugar l4 = new Lugar();
			l4.setId("5");
			l4.setNombre("Estadio Metropolitano");
			l4.setCodigoPostal(43250);
			l4.setDireccion("Avenida de Luis Aragonés - Madrid");
			l4.setLat(79.0);
			l4.setLon(36.9);
			addLugar(l4);
			
			//CREAMOS LAS CANCIONES;
			Cancion c1 = new Cancion();
			c1.setId("cancion1-asdfasd");
			c1.setName("Locos de atar");
			
			Cancion c2 = new Cancion();
			c2.setId("cancion2-gsfgsdfgd");
			c2.setName("Amasijo de huesos");
			
			Cancion c3 = new Cancion();
			c3.setId("cancion3-pesaddilla");
			c3.setName("Tu mejor pesadilla");
			
			Cancion c4 = new Cancion();
			c4.setId("cancion4-cicatrices");
			c4.setName("Cicatrices");
			
			Cancion c5 = new Cancion();
			c5.setId("cancion5-piarsdfa");
			c5.setName("Piratas");
			
			Cancion c6 = new Cancion();
			c6.setId("cancion6-melendasdfa");
			c6.setName("Un violinista en tu tejado");
			
			Cancion c7 = new Cancion();
			c7.setId("cancion7-eeewwfssd");
			c7.setName("Tu jardín con enanitos");
			
			Cancion c8 = new Cancion();
			c8.setId("cancion8-xcvbasd");
			c8.setName("Shape of you");
			
			Cancion c9 = new Cancion();
			c9.setId("cancion9-xvbxcvbxvbxcv");
			c9.setName("Happier");
			
			List<Cancion> cancionesMelendi = new ArrayList<Cancion>();
			cancionesMelendi.add(c6);
			cancionesMelendi.add(c7);
			List<Cancion> cancionesSidecars = new ArrayList<Cancion>();
			cancionesSidecars.add(c1);
			cancionesSidecars.add(c2);
			cancionesSidecars.add(c3);
			List<Cancion> cancionesEdSheeran = new ArrayList<Cancion>();
			cancionesEdSheeran.add(c8);
			cancionesEdSheeran.add(c9);
			List<Cancion> cancionesNatosYWaor = new ArrayList<Cancion>();
			cancionesNatosYWaor.add(c4);
			cancionesNatosYWaor.add(c5);
			
			//CREAMOS LOS ARTISTAS
			Artista a1 = new Artista();
			a1.setNombre("Melendi");
			a1.setId("art1");
			a1.setGeneros(new ArrayList<String>());
			a1.setPopularidad(10);
			a1.setCanciones(cancionesMelendi);
			addArtista(a1);
					
			Artista a2 = new Artista();
			a2.setNombre("Malu");
			a2.setId("art2");
			a2.setGeneros(new ArrayList<String>());
			a2.setPopularidad(10);
			a2.setCanciones(new ArrayList<Cancion>());
			addArtista(a2);
			
			Artista a3 = new Artista();
			a3.setNombre("Ed Sheeran");
			a3.setId("art3");
			a3.setGeneros(new ArrayList<String>());
			a3.setPopularidad(10);
			a3.setCanciones(cancionesEdSheeran);
			addArtista(a3);
			
			Artista a4 = new Artista();
			a4.setNombre("Sidecars");
			a4.setId("art4");
			a4.setGeneros(new ArrayList<String>());
			a4.setPopularidad(10);
			a4.setCanciones(cancionesSidecars);
			addArtista(a4);
			
			Artista a5 = new Artista();
			a5.setNombre("Natos y Waor");
			a5.setId("art5");
			a5.setGeneros(null);
			a5.setPopularidad(10);
			a5.setCanciones(cancionesNatosYWaor);
			addArtista(a5);

			// CREAMOS LOS EVENTOS
			Evento v = new Evento();
			v.setId("ev1");
			v.setNombre("Cubo de Rubik");
			v.setDescripcion("Gira de Melendi");
			List<Artista> artistas = new ArrayList<Artista>();
			artistas.add(a1);
			v.setArtistas(artistas);
			v.setLugar(null);
			addEvento(v);
			
			Evento v1 = new Evento();
			v1.setId("ev2");
			v1.setNombre("Concierto de Malú");
			v1.setDescripcion("Gira de Malú");
			List<Artista> artistas2 = new ArrayList<Artista>();
			artistas2.add(a2);
			v1.setArtistas(artistas2);
			v1.setLugar(l2);
			addEvento(v1);

			Evento v2 = new Evento();
			v2.setId("ev3");
			v2.setNombre("Concierto de Ed Sheeran");
			v2.setDescripcion("Gira de Ed Sheeran por España");
			List<Artista> artistas3 = new ArrayList<Artista>();
			artistas3.add(a3);
			v2.setArtistas(artistas3);
			v2.setLugar(l3);
			addEvento(v2);
			
			Evento v3 = new Evento();
			v3.setId("ev3");
			v3.setNombre("Concierto de Sidecars");
			v3.setDescripcion("Gira de Sidecars. Esta vez en Madrid");
			List<Artista> artistas4 = new ArrayList<Artista>();
			artistas4.add(a4);
			v3.setArtistas(artistas4);
			v3.setLugar(null);
			addEvento(v3);
			
			Evento v4 = new Evento();
			v4.setId("ev4");
			v4.setNombre("Concierto de Natos y Waor");
			v4.setDescripcion("Gira de Natos y Waor");
			List<Artista> artistas5 = new ArrayList<Artista>();
			artistas5.add(a5);
			v4.setArtistas(artistas5);
			v4.setLugar(l4);
			addEvento(v4);



	}

	// MÉTODOS DE LOS EVENTOS

	public Evento getEvento(String id) {
		return eventosMap.get(id);
	}

	public Collection<Evento> getEventos() {
		return eventosMap.values();
	}

	public void addEvento(Evento e) {
		if(e.getArtistas() == null) {
			List<Artista> lista = new ArrayList<Artista>();
			e.setArtistas(lista);
		}
		eventosMap.put(e.getId(), e);
	}

	public void addEventoArtista(String idEvento, Artista artista) {
		getEvento(idEvento).addArtista(artista);
	}

	public void removeEventoArtista(String idEvento, Artista artista) {
		getEvento(idEvento).removeArtista(artista);
	}

	public void updateEventoArtista(String idEvento, Artista artista) {
		getEvento(idEvento).updateArtista(artista);
	}

	public void addEventoLugar(String idEvento, Lugar s) {
		getEvento(idEvento).setLugar(s);
	}

	public void removeEventoLugar(String idEvento, String idlugar) {
		Evento e = eventosMap.get(idEvento);
		Evento newEvent = new Evento();
		newEvent.setArtistas(e.getArtistas());
		newEvent.setDescripcion(e.getDescripcion());
		newEvent.setNombre(e.getNombre());
		newEvent.setId(e.getId());
		newEvent.setLugar(null);
		eventosMap.remove(idEvento);
		addEvento(newEvent);
	}

	public void updateEventoLugar(String idEvento, Lugar lugar) {
		Evento e = eventosMap.get(idEvento);
		e.setLugar(lugar);
		eventosMap.replace(idEvento, e);
	}

	public void updateEvento(Evento e) {
		eventosMap.replace(e.getId(), e);
	}

	public void removeEvento(String id) {
		eventosMap.remove(id);
	}

	public Lugar getLugarByEvento(String idEvento) {
		Evento v = eventosMap.get(idEvento);
		Lugar res = v.getLugar();
		return res;
	}

	// MÉTODOS DE LOS LUGARES

	public Lugar getLugar(String id) {
		return lugaresMap.get(id);
	}

	public Collection<Lugar> getLugares() {
		for(Lugar l : lugaresMap.values()) {
		System.out.println(l.getNombre());
		}
		return lugaresMap.values();
	}

	public Collection<Lugar> getLugaresByName(String name) {
		Collection<Lugar> res = new ArrayList<Lugar>();
		Collection<Lugar> lugares = getLugares();
		for (Lugar s : lugares) {
			if (s.getNombre().toLowerCase().contains(name)) {
				res.add(s);
			}
		}
		return res;
	}

	public void addLugar(Lugar s) {
		lugaresMap.put(s.getId(), s);
	}

	public void removeLugar(String id) {
		lugaresMap.remove(id);
	}

	// MÉTODOS DE LOS ARTISTAS

	public Artista getArtista(String id) {
		return this.artistasMap.get(id);
	}

	public Collection<Artista> getArtistas() {
		return artistasMap.values();
	}

	public void addArtista(Artista a) {
		this.artistasMap.put(a.getId(), a);
	}

	public void addArtistaCancion(String idArtista, Cancion c) {
		Artista newArtist = this.artistasMap.get(idArtista);
		newArtist.addCancion(c);
		this.artistasMap.replace(idArtista, newArtist);
	}

	public void removeArtistaCancion(String idArtista, String idCancion) {
		Artista newArtist = this.artistasMap.get(idArtista);
		newArtist.removeCancion(idCancion);;
		this.artistasMap.replace(idArtista, newArtist);
	}

	public void eliminiaCancionDeArtista(String idArtista, String idCancion) {
		Artista newArtist = this.artistasMap.get(idArtista);
		newArtist.removeCancion(idCancion);
		this.artistasMap.replace(idArtista, newArtist);
	}

	public void eliminaArtista(String id) {
		this.artistasMap.remove(id);
	}


	// MÉTODOS DE LAS CANCIONES

	public Collection<Cancion> getAllCanciones() {
		Collection<Cancion> res = new ArrayList<Cancion>();
		for (Artista artist : artistasMap.values()) {
			for (Cancion c : artist.getCanciones()) {
				res.add(c);
			}
		}
		return res;
	}

	public Collection<Cancion> getCancionesByArtista(String idArtista) {
		Artista artista = getArtista(idArtista);
		return artista.getCanciones();
	}

}
