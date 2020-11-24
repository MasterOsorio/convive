package com.bit.model.entities;

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
@Table(name = "condominio")
public class Condominio {

	public Condominio() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String direccion;

	@Column(name = "imagen_logo")
	private String imagenLogo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reglamento", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_reglamento", foreignKey = @ForeignKey(name = "fk_id_reglamento"))
	private Reglamento reglamento;

	@Column(name = "correo_electronico")
	private String correoElectronico;

	@Column(name = "num_torres")
	private String numTorres;

	@Column(name = "num_deptos")
	private String numDeptos;

	@Column(name = "num_cajones_estacionamiento")
	private String numCajonesEstacionamiento;

	@Column(name = "num_sotanos")
	private String numSotanos;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImagenLogo() {
		return imagenLogo;
	}

	public void setImagenLogo(String imagenLogo) {
		this.imagenLogo = imagenLogo;
	}

	public Reglamento getReglamento() {
		return reglamento;
	}

	public void setReglamento(Reglamento reglamento) {
		this.reglamento = reglamento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNumTorres() {
		return numTorres;
	}

	public void setNumTorres(String numTorres) {
		this.numTorres = numTorres;
	}

	public String getNumDeptos() {
		return numDeptos;
	}

	public void setNumDeptos(String numDeptos) {
		this.numDeptos = numDeptos;
	}

	public String getNumCajonesEstacionamiento() {
		return numCajonesEstacionamiento;
	}

	public void setNumCajonesEstacionamiento(String numCajonesEstacionamiento) {
		this.numCajonesEstacionamiento = numCajonesEstacionamiento;
	}

	public String getNumSotanos() {
		return numSotanos;
	}

	public void setNumSotanos(String numSotanos) {
		this.numSotanos = numSotanos;
	}
}
