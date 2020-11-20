package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo_area")
public class CatalogoArea {

	public CatalogoArea() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="id_uno") usarse solo cuando los campos no se llamen igual
	private Integer id;

	@Column
	private String area;

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
