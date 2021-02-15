package com.bit.management.catalogs.screen;

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

import com.bit.management.users.PermisoPantalla;

@Entity
@Table(name = "catalogo_pantalla")
public class CatalogoPantalla {

	public CatalogoPantalla() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String pantalla;

	@Column
	private String descripcion;

	@Column
	private String categoria;

	@Column
	private Integer perteneceA;

	@Column
	private String link;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoPantalla", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PermisoPantalla> pantallas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getPerteneceA() {
		return perteneceA;
	}

	public void setPerteneceA(Integer perteneceA) {
		this.perteneceA = perteneceA;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<PermisoPantalla> getPantallas() {
		return pantallas;
	}

	public void setPantallas(List<PermisoPantalla> pantallas) {
		this.pantallas = pantallas;
	}

	/*
	 * Helper Methods
	 */

	public void addPermisoPantalla(PermisoPantalla permisoPantalla) {
		pantallas.add(permisoPantalla);
		permisoPantalla.setCatalogoPantalla(this);
	}

	public void removePermisoPantalla(PermisoPantalla permisoPantalla) {
		pantallas.remove(permisoPantalla);
		permisoPantalla.setCatalogoPantalla(null);
	}
}
