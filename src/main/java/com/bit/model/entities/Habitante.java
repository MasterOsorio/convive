package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_habitante", referencedColumnName = "id")
	private CatalogoTipoHabitante catalogoTipoHabitante;

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
}
