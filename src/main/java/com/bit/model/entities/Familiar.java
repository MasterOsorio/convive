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
@Table(name = "familiar")
public class Familiar {

	public Familiar() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column(name = "apellido_paterno")
	private String apellidoPaterno;

	@Column(name = "apellido_materno")
	private String apellidoMaterno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_habitante", foreignKey = @ForeignKey(name = "fk_id_habitante"))
	private Habitante habitante;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familiar", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonoHabitante> telefonoHabitantes = new ArrayList<>();

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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Habitante getHabitante() {
		return habitante;
	}

	public void setHabitante(Habitante habitante) {
		this.habitante = habitante;
	}

	public List<TelefonoHabitante> getTelefonoHabitantes() {
		return telefonoHabitantes;
	}

	public void setTelefonoHabitantes(List<TelefonoHabitante> telefonoHabitantes) {
		this.telefonoHabitantes = telefonoHabitantes;
	}

	/*
	 * Helper Methods
	 */

	public void addTelefonoHabitante(TelefonoHabitante telefonoHabitante) {
		telefonoHabitantes.add(telefonoHabitante);
		telefonoHabitante.setFamiliar(this);
	}

	public void removeTelefonoHabitante(TelefonoHabitante telefonoHabitante) {
		telefonoHabitantes.remove(telefonoHabitante);
		telefonoHabitante.setFamiliar(null);
	}
}
