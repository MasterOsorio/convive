package com.bit.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private boolean tieneCosto;

	@Column(name = "costo_hora")
	private float costoHora;

	@Column(name = "costo_evento")
	private float costoEvento;

	@Column
	private String horario;

	@Column(name = "esta_habilitada")
	private boolean estaHabilitada;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "torre", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_torre", foreignKey = @ForeignKey(name = "fk_id_torre"))
	private Torre torre;

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

	public boolean isTieneCosto() {
		return tieneCosto;
	}

	public void setTieneCosto(boolean tieneCosto) {
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

	public boolean isEstaHabilitada() {
		return estaHabilitada;
	}

	public void setEstaHabilitada(boolean estaHabilitada) {
		this.estaHabilitada = estaHabilitada;
	}

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}
}
