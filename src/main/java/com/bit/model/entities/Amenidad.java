package com.bit.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "amenidad")
public class Amenidad {

	public Amenidad() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String descripcion;

	@Column(name = "tiene_costo")
	private Boolean tieneCosto;

	@Column(name = "costo_hora")
	private float costoHora;

	@Column(name = "costo_evento")
	private float costoEvento;

	@Column
	private String horario;

	@Column(name = "esta_habilitada")
	private Boolean estaHabilitada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_torre", foreignKey = @ForeignKey(name = "fk_id_torre"))
	private Torre torre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "amenidad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Imagenes> imagenAmenidad = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "amenidad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservacion> reservaciones = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getTieneCosto() {
		return tieneCosto;
	}

	public void setTieneCosto(Boolean tieneCosto) {
		this.tieneCosto = tieneCosto;
	}

	public float getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(float costoHora) {
		this.costoHora = costoHora;
	}

	public float getCostoEvento() {
		return costoEvento;
	}

	public void setCostoEvento(float costoEvento) {
		this.costoEvento = costoEvento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Boolean getEstaHabilitada() {
		return estaHabilitada;
	}

	public void setEstaHabilitada(Boolean estaHabilitada) {
		this.estaHabilitada = estaHabilitada;
	}

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}

	public List<Imagenes> getImagenAmenidad() {
		return imagenAmenidad;
	}

	public void setImagen(List<Imagenes> imagenAmenidad) {
		this.imagenAmenidad = imagenAmenidad;
	}

	public List<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	/*
	 * Helper Methods
	 */

	public void addImagenes(Imagenes imagenes) {
		imagenAmenidad.add(imagenes);
		imagenes.setAmenidad(this);
	}

	public void removeImagenes(Imagenes imagenes) {
		imagenAmenidad.remove(imagenes);
		imagenes.setAmenidad(null);
	}

	public void addReservacion(Reservacion reservacion) {
		reservaciones.add(reservacion);
		reservacion.setAmenidad(this);
	}

	public void removeReservacion(Reservacion reservacion) {
		reservaciones.remove(reservacion);
		reservacion.setAmenidad(null);
	}
}
