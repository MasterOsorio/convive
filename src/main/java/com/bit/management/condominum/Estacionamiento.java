package com.bit.management.condominum;

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
@Table(name = "estacionamiento")
public class Estacionamiento {

	public Estacionamiento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_cajon")
	private String idCajon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento", foreignKey = @ForeignKey(name = "fk_id_departamento_estacionamiento"))
	private Departamento departamento;

	@Column(name = "num_sotano")
	private int numSotano;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdCajon() {
		return idCajon;
	}

	public void setIdCajon(String idCajon) {
		this.idCajon = idCajon;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public int getNumSotano() {
		return numSotano;
	}

	public void setNumSotano(int numSotano) {
		this.numSotano = numSotano;
	}
}
