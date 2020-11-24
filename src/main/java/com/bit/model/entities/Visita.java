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
@Table(name = "visita")
public class Visita {

	public Visita() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String apellidos;

	@Column(name = "fecha_entrada")
	private java.time.LocalDate fechaEntrada;

	@Column(name = "fecha_salida")
	private java.time.LocalDate fechaSalida;

	@Column
	private String identificacion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_departaento", foreignKey = @ForeignKey(name = "fk_id_departamento_visita"))
	private Departamento departamento;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public java.time.LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(java.time.LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public java.time.LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(java.time.LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
