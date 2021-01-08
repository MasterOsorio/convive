package com.bit.management.catalogs.responsetype;

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

import com.bit.management.eventnotification.Encuesta;

@Entity
@Table(name = "catalogo_tipo_respuesta")
public class CatalogoTipoRespuesta {

	public CatalogoTipoRespuesta() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoRespuesta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Encuesta> encuestas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Encuesta> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	/*
	 * Helper Methods
	 */

	public void addEncuesta(Encuesta encuesta) {
		encuestas.add(encuesta);
		encuesta.setCatalogoTipoRespuesta(this);
	}

	public void removeEncuesta(Encuesta encuesta) {
		encuestas.remove(encuesta);
		encuesta.setCatalogoTipoRespuesta(null);
	}
}
