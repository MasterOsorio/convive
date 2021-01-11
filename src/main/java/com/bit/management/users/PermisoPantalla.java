package com.bit.management.users;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bit.management.catalogs.screen.CatalogoPantalla;

@Entity
@Table(name = "permiso_pantalla")
public class PermisoPantalla {

	public PermisoPantalla() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pantalla", foreignKey = @ForeignKey(name = "fk_id_pantalla"))
	private CatalogoPantalla catalogoPantalla;

	@ManyToOne(fetch = FetchType.LAZY)
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
