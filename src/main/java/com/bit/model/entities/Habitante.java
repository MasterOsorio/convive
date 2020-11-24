package com.bit.model.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "habitante")
public class Habitante {

	public Habitante() {

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

	@Column(name = "numero_mascotas")
	private int numeroMascotas;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_tipo_habitante", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_tipo_habitante", foreignKey = @ForeignKey(name = "fk_id_tipo_habitante"))
	private CatalogoTipoHabitante catalogoTipoHabitante;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "habitante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonoHabitante> telefonos = new ArrayList<>() ;

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

	public int getNumeroMascotas() {
		return numeroMascotas;
	}

	public void setNumeroMascotas(int numeroMascotas) {
		this.numeroMascotas = numeroMascotas;
	}

	public CatalogoTipoHabitante getCatalogoTipoHabitante() {
		return catalogoTipoHabitante;
	}

	public void setCatalogoTipoHabitante(CatalogoTipoHabitante catalogoTipoHabitante) {
		this.catalogoTipoHabitante = catalogoTipoHabitante;
	}

	public List<TelefonoHabitante> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoHabitante> telefonos) {
		this.telefonos = telefonos;
	}
	
	/*
	 * Helper methods
	 */
	public void addTelefono(TelefonoHabitante telefono) {
		telefonos.add( telefono );
		telefono.setHabitante( this );
	}

	public void removePhone(TelefonoHabitante telefono) {
		telefonos.remove( telefono );
		telefono.setHabitante( null );
	}
}
