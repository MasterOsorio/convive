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
@Table(name = "respuesta_departamento")
public class RespuestaDepartamento {

	public RespuestaDepartamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_encuesta", foreignKey = @ForeignKey(name = "fk_id_encuesta_respuesta_departamento"))
	private Encuesta encuesta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento", foreignKey = @ForeignKey(name = "fk_id_respuesta_departamento"))
	private Departamento departamento;

	@Column
	private String respuesta;

	@Column(name = "opcion_seleccionada")
	private String opcionSeleccionada;

	@Column(name = "fecha_respuesta")
	private java.time.LocalDate fechaRespuesta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}

	public java.time.LocalDate getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(java.time.LocalDate fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
}
