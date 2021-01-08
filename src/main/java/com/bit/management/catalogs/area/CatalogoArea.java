package com.bit.management.catalogs.area;

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

import com.bit.management.users.Usuario;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoArea", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuarios = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/*
	 * Helper methods
	 */

	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
		usuario.setCatalogoArea(this);
	}

	public void removeUsuario(Usuario usuario) {
		usuarios.remove(usuario);
		usuario.setCatalogoArea(null);
	}
}
