package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservacion")
public class Reservacion {

	public Reservacion() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private java.time.LocalDate fecha;

	@Column(name = "hora_inicio")
	private java.time.LocalTime horaInicio;

	@Column(name = "hora_fin")
	private java.time.LocalTime horaFin;

	@Column(name = "horas_reservadas")
	private double horasReservadas;

	@Column(name = "total_pagar")
	private float totalPagar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento", foreignKey = @ForeignKey(name = "fk_id_departamento_reservacion"))
	private Departamento departamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_amenidad", foreignKey = @ForeignKey(name = "fk_id_amenidad_reservacion"))
	private Amenidad amenidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.time.LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}

	public java.time.LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(java.time.LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public java.time.LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(java.time.LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public double getHorasReservadas() {
		return horasReservadas;
	}

	public void setHorasReservadas(double horasReservadas) {
		this.horasReservadas = horasReservadas;
	}

	public float getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(float totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Amenidad getAmenidad() {
		return amenidad;
	}

	public void setAmenidad(Amenidad amenidad) {
		this.amenidad = amenidad;
	}
}
