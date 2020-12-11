package com.bit.management.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bit.management.catalogs.CatalogoArea;

@Entity
@Table(name = "usuario")
public class Usuario {

	public Usuario() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column(name = "apellido_paterno")
	private String apellidoPaterno;

	@Column(name = "apellido_materno")
	private String apellidoMaterno;

	@Column(name = "correo_electronico")
	private String correoElectronico;

	@Column(name = "telefono_movil")
	private String telefonoMovil;

	@Column
	private String password;

	@Column(name = "path_fotografia")
	private String pathFotografia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area", foreignKey = @ForeignKey(name = "fk_id_area"))
	private CatalogoArea catalogoArea;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RolUsuario> rolesUsuario = new ArrayList<>();

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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPathFotografia() {
		return pathFotografia;
	}

	public void setPathFotografia(String pathFotografia) {
		this.pathFotografia = pathFotografia;
	}

	public CatalogoArea getCatalogoArea() {
		return catalogoArea;
	}

	public void setCatalogoArea(CatalogoArea catalogoArea) {
		this.catalogoArea = catalogoArea;
	}

	public List<RolUsuario> getRolesUsuario() {
		return rolesUsuario;
	}

	public void setRolesUsuario(List<RolUsuario> rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

	/*
	 * Helper Methods
	 */

	public void addRolUsuario(RolUsuario rolUsuario) {
		rolesUsuario.add(rolUsuario);
		rolUsuario.setUsuario(this);
	}

	public void removeRolUsuario(RolUsuario rolUsuario) {
		rolesUsuario.remove(rolUsuario);
		rolUsuario.setUsuario(null);
	}
}
