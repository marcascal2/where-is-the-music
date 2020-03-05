package aiss.model.api;

import java.util.ArrayList;
import java.util.List;

public class Artista {

	private String id;
	private String nombre;
	private List<String> generos;
	private Integer popularidad;
	private List<Cancion> canciones;

	public Artista() {
	}

	public Artista(String id, String nombre, List<String> generos, Integer popularidad, List<Cancion> canciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.generos = generos;
		this.popularidad = popularidad;
		this.canciones = canciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		if (canciones == null) {
			this.canciones = new ArrayList<Cancion>();
		}

		this.canciones = canciones;
	}

	public void addCancion(Cancion c) {
		if (this.canciones == null) {
			this.canciones = new ArrayList<Cancion>();
		}
		this.canciones.add(c);
	}

	public void removeCancion(String idCancion) {
		List<Cancion> copiaCanciones = new ArrayList<Cancion>(this.canciones);
		for(Cancion c: copiaCanciones) {
			if(c.getId().equals(idCancion)) {
				copiaCanciones.remove(c);
			}
		}

		this.canciones = copiaCanciones;
	}

	public void updateCancion(Cancion newTrack) {
		List<Cancion> copiaCanciones = new ArrayList<Cancion>(this.canciones);
		for (Cancion oldTrack : copiaCanciones) {
			if (oldTrack.getId().equals(newTrack.getId())) {
				copiaCanciones.remove(oldTrack);
				copiaCanciones.add(newTrack);
			}
		}
		this.canciones = copiaCanciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		if(generos != null) {
			generos = new ArrayList<String>();
		}
		this.generos = generos;
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(Integer popularidad) {
		this.popularidad = popularidad;
	}

}