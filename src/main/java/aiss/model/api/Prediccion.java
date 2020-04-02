package aiss.model.api;

import java.time.LocalDateTime;

public class Prediccion {
	private String id;
	private String lugar;
	private Double tempMax;
	private Double tempMin;
	private Integer humedad;
	private Integer presionAt;
	private Double velocidadViento;
	private String descripcion;
	private LocalDateTime fechayhora;

	public Prediccion() {

	}

	public Prediccion(String id, String lugar, Double tempMax, Double tempMin, Integer humedad, Integer presionAt,
			Double velocidadViento, String descripcion, LocalDateTime fechayhora) {
		this.id = id;
		this.lugar = lugar;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
		this.humedad = humedad;
		this.presionAt = presionAt;
		this.velocidadViento = velocidadViento;
		this.descripcion = descripcion;
		this.fechayhora = fechayhora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Double getTempMax() {
		return tempMax;
	}

	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	public Double getTempMin() {
		return tempMin;
	}

	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	public Integer getHumedad() {
		return humedad;
	}

	public void setHumedad(Integer humedad) {
		this.humedad = humedad;
	}

	public Integer getPresionAt() {
		return presionAt;
	}

	public void setPresionAt(Integer presionAt) {
		this.presionAt = presionAt;
	}

	public Double getVelocidadViento() {
		return velocidadViento;
	}

	public void setVelocidadViento(Double velocidadViento) {
		this.velocidadViento = velocidadViento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(LocalDateTime fechayhora) {
		this.fechayhora = fechayhora;
	}

	@Override
	public String toString() {
		return "Prediccion [lugar=" + lugar + ", tempMax=" + tempMax + ", tempMin=" + tempMin
				+ ", fechayhora=" + fechayhora + "]";
	}

}
