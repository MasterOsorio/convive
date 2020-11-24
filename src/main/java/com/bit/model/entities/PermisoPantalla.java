package com.bit.model.entities;

import javax.persistence.CascadeType;
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
@Table(name = "permiso_pantalla")
public class PermisoPantalla {

	public PermisoPantalla() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_pantalla", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_pantalla", foreignKey = @ForeignKey(name = "fk_id_pantalla"))
	private CatalogoPantalla catalogoPantalla;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_rol", foreignKey = @ForeignKey(name = "fk_id_rol"))
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
