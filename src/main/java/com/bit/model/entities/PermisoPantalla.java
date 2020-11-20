package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permiso_pantalla")
public class PermisoPantalla {

	public PermisoPantalla() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pantalla", referencedColumnName = "id")
	private CatalogoPantalla catalogoPantalla;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol", referencedColumnName = "id")
	private Rol rol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CatalogoPantalla getCatalogoPantalla() {
		return catalogoPantalla;
	}

	public void setCatalogoPantalla(CatalogoPantalla catalogoPantalla) {
		this.catalogoPantalla = catalogoPantalla;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
