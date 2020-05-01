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
import aiss.model.api.Prediccion;

public class MapWITMRepository {
	Map<String, Evento> eventosMap;
	Map<String, Lugar> lugaresMap;
	Map<String, Artista> artistasMap;
	Map<String, Cancion> cancionesMap;
	Map<String, Prediccion> prediccionesMap;

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
		cancionesMap = new HashMap<String, Cancion>();
		prediccionesMap = new HashMap<String, Prediccion>();

		// CREO LAS PREDICCIONES

		Prediccion p1 = new Prediccion();
		p1.setId("pr1");
		p1.setLugar("Sevilla");
		p1.setLat(7.7);
		p1.setLon(50.2);
		p1.setTempMax(289.5);
		p1.setTempMin(289.);
		p1.setHumedad(71);
		p1.setPresionAt(1017);
		p1.setVelocidadViento(6.33);
		p1.setDescripcion("Cielos despejados");
		p1.setFechayhora("2020-04-15 12:00:00");
		p1.setImage("assets/sunshine.jpg");
		addPrediccion(p1);

		Prediccion p2 = new Prediccion();
		p2.setId("pr2");
		p2.setLugar("Sevilla");
		p2.setLat(7.7);
		p2.setLon(50.2);
		p2.setTempMax(289.5);
		p2.setTempMin(289.);
		p2.setHumedad(71);
		p2.setPresionAt(1017);
		p2.setVelocidadViento(6.33);
		p2.setDescripcion("Cielos despejados");
		p2.setFechayhora("2020-04-15 18:00:00");
		p2.setImage("assets/sunshine.jpg");
		addPrediccion(p2);

		Prediccion p3 = new Prediccion();
		p3.setId("pr3");
		p3.setLugar("Sevilla");
		p3.setLat(7.7);
		p3.setLon(50.2);
		p3.setTempMax(289.5);
		p3.setTempMin(289.);
		p3.setHumedad(71);
		p3.setPresionAt(1017);
		p3.setVelocidadViento(6.33);
		p3.setDescripcion("Cielos despejados");
		p3.setFechayhora("2020-04-15 21:00:00");
		p3.setImage("assets/sunshine.jpg");
		addPrediccion(p3);

		List<Prediccion> prediccionesSevilla = new ArrayList<Prediccion>();
		prediccionesSevilla.add(p1);
		prediccionesSevilla.add(p2);
		prediccionesSevilla.add(p3);

		Prediccion p4 = new Prediccion();
		p4.setId("pr4");
		p4.setLugar("Madrid");
		p4.setLat(79.0);
		p4.setLon(36.9);
		p4.setTempMax(288.65);
		p4.setTempMin(286.4);
		p4.setHumedad(83);
		p4.setPresionAt(1017);
		p4.setVelocidadViento(6.33);
		p4.setDescripcion("Lluvia abundante");
		p4.setFechayhora("2020-04-16 12:00:00");
		p4.setImage("assets/rain.jpg");
		addPrediccion(p4);

		Prediccion p5 = new Prediccion();
		p5.setId("pr5");
		p5.setLugar("Madrid");
		p5.setLat(79.0);
		p5.setLon(36.9);
		p5.setTempMax(288.65);
		p5.setTempMin(275.);
		p5.setHumedad(83);
		p5.setPresionAt(1017);
		p5.setVelocidadViento(6.33);
		p5.setDescripcion("Lluvia abundante");
		p5.setFechayhora("2020-04-16 18:00:00");
		p5.setImage("assets/rain.jpg");
		addPrediccion(p5);

		Prediccion p6 = new Prediccion();
		p6.setId("pr6");
		p6.setLugar("Madrid");
		p6.setLat(79.0);
		p6.setLon(36.9);
		p6.setTempMax(276.65);
		p6.setTempMin(275.5);
		p6.setHumedad(85);
		p6.setPresionAt(1017);
		p6.setVelocidadViento(6.33);
		p6.setDescripcion("Lluvia abundante");
		p6.setFechayhora("2020-04-16 21:00:00");
		p6.setImage("assets/rain.jpg");
		addPrediccion(p6);

		List<Prediccion> prediccionesMadrid = new ArrayList<Prediccion>();
		prediccionesMadrid.add(p4);
		prediccionesMadrid.add(p5);
		prediccionesMadrid.add(p6);

		Prediccion p7 = new Prediccion();
		p7.setId("pr7");
		p7.setLugar("Barcelona");
		p7.setLat(41.3887901);
		p7.setLon(2.1589899);
		p7.setTempMax(289.5);
		p7.setTempMin(287.);
		p7.setHumedad(70);
		p7.setPresionAt(1017);
		p7.setVelocidadViento(6.33);
		p7.setDescripcion("Cielo nublado");
		p7.setFechayhora("2020-04-17 12:00:00");
		p7.setImage("assets/weather.jpg");
		addPrediccion(p7);

		Prediccion p8 = new Prediccion();
		p8.setId("pr8");
		p8.setLugar("Barcelona");
		p8.setLat(41.3887901);
		p8.setLon(2.1589899);
		p8.setTempMax(289.5);
		p8.setTempMin(280.);
		p8.setHumedad(71);
		p8.setPresionAt(1017);
		p8.setVelocidadViento(6.33);
		p8.setDescripcion("Cielo nublado");
		p8.setFechayhora("2020-04-17 18:00:00");
		p8.setImage("assets/weather.jpg");
		addPrediccion(p8);

		Prediccion p9 = new Prediccion();
		p9.setId("pr9");
		p9.setLugar("Barcelona");
		p9.setLat(41.3887901);
		p9.setLon(2.1589899);
		p9.setTempMax(289.5);
		p9.setTempMin(286.);
		p9.setHumedad(71);
		p9.setPresionAt(1017);
		p9.setVelocidadViento(6.33);
		p9.setDescripcion("Cielo nublado");
		p9.setFechayhora("2020-04-17 21:00:00");
		p9.setImage("assets/weather.jpg");
		addPrediccion(p9);

		List<Prediccion> prediccionesBarcelona = new ArrayList<Prediccion>();
		prediccionesBarcelona.add(p7);
		prediccionesBarcelona.add(p8);
		prediccionesBarcelona.add(p9);

		// CREO UN LUGAR
		Lugar l = new Lugar();
		l.setId("1");
		l.setNombre("San Pablo");
		l.setCodigoPostal(41015);
		l.setDireccion("San Pablo-Santa Justa -  Sevilla");
		l.setLat(15.8);
		l.setLon(47.0);
		l.setPredicciones(prediccionesSevilla);
		addLugar(l);

		Lugar l1 = new Lugar();
		l1.setId("2");
		l1.setNombre("Sala Even");
		l1.setCodigoPostal(41040);
		l1.setDireccion("Camino de los descubrimientos - Sevilla");
		l1.setLat(5.0);
		l1.setLon(40.3);
		l1.setPredicciones(prediccionesSevilla);
		addLugar(l1);

		Lugar l2 = new Lugar();
		l2.setId("3");
		l2.setNombre("Sala CUSTOM");
		l2.setCodigoPostal(41006);
		l2.setDireccion("Avenida de Jerez");
		l2.setLat(7.7);
		l2.setLon(50.2);
		l2.setPredicciones(prediccionesSevilla);
		addLugar(l2);

		Lugar l3 = new Lugar();
		l3.setId("4");
		l3.setNombre("Teatro Tour");
		l3.setCodigoPostal(43210);
		l3.setDireccion("Calle del Monasterio de El Paular - Madrid");
		l3.setLat(83.2);
		l3.setLon(31.5);
		l3.setPredicciones(prediccionesMadrid);
		addLugar(l3);

		Lugar l4 = new Lugar();
		l4.setId("5");
		l4.setNombre("Estadio Metropolitano");
		l4.setCodigoPostal(43250);
		l4.setDireccion("Avenida de Luis Aragonés - Madrid");
		l4.setLat(79.0);
		l4.setLon(36.9);
		l4.setPredicciones(prediccionesMadrid);
		addLugar(l4);

		Lugar l5 = new Lugar();
		l5.setId("6");
		l5.setNombre("Estadio Barcelona");
		l5.setCodigoPostal(52489);
		l5.setDireccion("Calle de Alcalá de Guadaíra - Barcelona");
		l5.setLat(41.3887901);
		l5.setLon(2.1589899);
		l5.setPredicciones(prediccionesBarcelona);
		addLugar(l4);

		// CREAMOS LAS CANCIONES;
		Cancion c1 = new Cancion();
		c1.setId("cancion1");
		c1.setName("Locos de atar");
		addCancion(c1);

		Cancion c2 = new Cancion();
		c2.setId("cancion2");
		c2.setName("Amasijo de huesos");
		addCancion(c2);

		Cancion c3 = new Cancion();
		c3.setId("cancion3");
		c3.setName("Tu mejor pesadilla");
		addCancion(c3);

		Cancion c4 = new Cancion();
		c4.setId("cancion4");
		c4.setName("Cicatrices");
		addCancion(c4);

		Cancion c5 = new Cancion();
		c5.setId("cancion5");
		c5.setName("Piratas");
		addCancion(c5);

		Cancion c6 = new Cancion();
		c6.setId("cancion6");
		c6.setName("Un violinista en tu tejado");
		addCancion(c6);

		Cancion c7 = new Cancion();
		c7.setId("cancion7");
		c7.setName("Tu jardín con enanitos");
		addCancion(c7);

		Cancion c8 = new Cancion();
		c8.setId("cancion8");
		c8.setName("Shape of you");
		addCancion(c8);

		Cancion c9 = new Cancion();
		c9.setId("cancion9");
		c9.setName("Happier");
		addCancion(c9);

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

		// CREAMOS LOS ARTISTAS
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
		if (e.getArtistas() == null) {
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

	public void removePrediccion(String placeId, String predId) {
		Lugar l = lugaresMap.get(placeId);
		Lugar newPlace = new Lugar();
		List<Prediccion> preds = l.getPredicciones();
		preds.remove(getPrediccion(predId));
		newPlace.setId(l.getId());
		newPlace.setCodigoPostal(l.getCodigoPostal());
		newPlace.setDireccion(l.getDireccion());
		newPlace.setLat(l.getLat());
		newPlace.setLon(l.getLon());
		newPlace.setNombre(l.getNombre());
		newPlace.setPredicciones(preds);
		lugaresMap.remove(placeId);
		addLugar(newPlace);
	}

	public void addLugarPrediccion(String placeId, String predId) {
		Lugar l = getLugar(placeId);
		Lugar newPlace = new Lugar();
		List<Prediccion> preds = l.getPredicciones();
		Prediccion p = getPrediccion(predId);
		preds.add(p);
		newPlace.setCodigoPostal(l.getCodigoPostal());
		newPlace.setDireccion(l.getDireccion());
		newPlace.setId(l.getId());
		newPlace.setLat(l.getLat());
		newPlace.setLon(l.getLon());
		newPlace.setNombre(l.getNombre());
		newPlace.setPredicciones(preds);
		lugaresMap.remove(placeId);
		addLugar(newPlace);
	}

	// MÉTODOS DE LOS ARTISTAS

	public Artista getArtista(String id) {
		return this.artistasMap.get(id);
	}

	public Collection<Artista> getArtistas() {
		return artistasMap.values();
	}

	public void addArtista(Artista a) {
		artistasMap.put(a.getId(), a);
	}

	public void addArtistaCancion(String idArtista, String idCancion) {
		Artista art = getArtista(idArtista);
		Artista newArtist = new Artista();
		List<Cancion> songs = art.getCanciones();
		Cancion c = getCancion(idCancion);
		songs.add(c);
		newArtist.setGeneros(art.getGeneros());
		newArtist.setId(art.getId());
		newArtist.setNombre(art.getNombre());
		newArtist.setPopularidad(art.getPopularidad());
		newArtist.setCanciones(songs);
		artistasMap.remove(idArtista);
		addArtista(newArtist); 
	}

	public void removeArtistaCancion(String idArtista, String idCancion) {
		Artista art = getArtista(idArtista);
		Artista newArtist = new Artista();
		Cancion c = getCancion(idCancion);
		List<Cancion> songs = art.getCanciones();
		songs.remove(c);
		newArtist.setGeneros(art.getGeneros());
		newArtist.setId(art.getId());
		newArtist.setNombre(art.getNombre());
		newArtist.setPopularidad(art.getPopularidad());
		newArtist.setCanciones(songs);
		artistasMap.remove(idArtista);
		addArtista(newArtist); 
	}

	public void eliminaArtista(String id) {
		artistasMap.remove(id);
	}

	// MÉTODOS DE LAS CANCIONES

	private void addCancion(Cancion c) {
		cancionesMap.put(c.getId(), c);
	}

	public Cancion getCancion(String idCancion) {
		return cancionesMap.get(idCancion);
	}

	public Collection<Cancion> getAllCanciones() {
		return cancionesMap.values();
	}

	public Collection<Cancion> getCancionesByArtista(String idArtista) {
		Artista artista = getArtista(idArtista);
		return artista.getCanciones();
	}

	// MÉTODOS DE LAS PREDICCIONES

	private void addPrediccion(Prediccion p) {
		prediccionesMap.put(p.getId(), p);
	}

	public Collection<Prediccion> getAllPredictions() {
		return prediccionesMap.values();
	}

	public Collection<Prediccion> getPredictionsByPlace(String placeId) {
		Lugar lugar = getLugar(placeId);
		return lugar.getPredicciones();
	}

	public Prediccion getPrediccion(String predId) {
		return prediccionesMap.get(predId);
	}

}
