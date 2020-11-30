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
@Table(name = "rol")
public class Rol {

	public Rol() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String rol;

	@Column
	private String descripcion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PermisoPantalla> pantallasRol = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RolUsuario> rolUsuarios = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PermisoPantalla> getPantallasRol() {
		return pantallasRol;
	}

	public void setPantallasRol(List<PermisoPantalla> pantallasRol) {
		this.pantallasRol = pantallasRol;
	}

	public List<RolUsuario> getRolUsuarios() {
		return rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	/*
	 * Helper Methods
	 */

	public void addPermisoPantalla(PermisoPantalla permisoPantalla) {
		pantallasRol.add(permisoPantalla);
		permisoPantalla.setRol(this);
	}

	public void removePermisoPantalla(PermisoPantalla permisoPantalla) {
		pantallasRol.remove(permisoPantalla);
		permisoPantalla.setRol(null);
	}

	public void addRolUsuario(RolUsuario rolUsuario) {
		rolUsuarios.add(rolUsuario);
		rolUsuario.setRol(this);
	}

	public void removeRolUsuario(RolUsuario rolUsuario) {
		rolUsuarios.remove(rolUsuario);
		rolUsuario.setRol(null);
	}
}
