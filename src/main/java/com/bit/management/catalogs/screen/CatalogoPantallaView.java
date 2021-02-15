package com.bit.management.catalogs.screen;

public class CatalogoPantallaView {

	public CatalogoPantallaView() {

	}

	private Integer id;
	private String pantalla;
	private String descripcion;
	private String categoria;
	private Integer perteneceA;
	private String link;

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
}
