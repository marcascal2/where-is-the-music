package aiss.model.api;

import java.util.ArrayList;
import java.util.List;

public class Evento {
	
	private String id;
	private String nombre;
	private List<Artista> artistas;
	private Lugar sala;
	private String descripcion;
	
	public Evento() {
	}

	public Evento(String id, String nombre, List<Artista> artistas, Lugar sala, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.artistas = artistas;
		this.sala = sala;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	
	public void addArtista(Artista a) {
		if (this.artistas == null) {
			this.artistas = new ArrayList<Artista>();
		}
		this.artistas.add(a);
	}
	public void removeArtista(Artista a) {
		this.artistas.remove(a);
	}
	public void updateArtista(Artista newArtist) {
		List<Artista> copiaArtistas = new ArrayList<Artista>(this.artistas);
		for(Artista oldArtist: copiaArtistas) {
			if(oldArtist.getId().equals(newArtist.getId())) {
				copiaArtistas.remove(oldArtist);
				copiaArtistas.add(newArtist);
			}
		}
		this.artistas = copiaArtistas;
	}

	public Lugar getLugar() {
		return sala;
	}

	public void setLugar(Lugar sala) {
		this.sala = sala;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", artistas=" + artistas + ", sala=" + sala
				+ ", descripcion=" + descripcion + "]";
	}
	
}