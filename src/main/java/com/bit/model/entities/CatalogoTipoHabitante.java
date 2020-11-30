package com.bit.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo_tipo_habitante")
public class CatalogoTipoHabitante {

	public CatalogoTipoHabitante() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_tipo_habitante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Habitante> habitantes = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Habitante> getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(List<Habitante> habitantes) {
		this.habitantes = habitantes;
	}

	/*
	 * Helper Methods
	 */

	public void addHabitante(Habitante habitante) {
		habitantes.add(habitante);
		habitante.setCatalogoTipoHabitante(this);
	}

	public void removeHabitante(Habitante habitante) {
		habitantes.remove(habitante);
		habitante.setCatalogoTipoHabitante(null);
	}
}
