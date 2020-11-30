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
@Table(name = "reglamento")
public class Reglamento {

	public Reglamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String reglamento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reglamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Condominio> condominios = new ArrayList<>();

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

	public String getReglamento() {
		return reglamento;
	}

	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

	/*
	 * Helper Methods
	 */

	public void addCondominio(Condominio condominio) {
		condominios.add(condominio);
		condominio.setReglamento(this);
	}

	public void removeCondominio(Condominio condominio) {
		condominios.remove(condominio);
		condominio.setReglamento(null);
	}
}
