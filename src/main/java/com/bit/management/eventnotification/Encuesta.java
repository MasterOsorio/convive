package com.bit.management.eventnotification;

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

import com.bit.management.catalogs.responsetype.CatalogoTipoRespuesta;

@Entity
@Table(name = "encuesta")
public class Encuesta {

	public Encuesta() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String pregunta;

	@Column
	private String opciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_respuesta", foreignKey = @ForeignKey(name = "fk_id_tipo_respuesta"))
	private CatalogoTipoRespuesta catalogoTipoRespuesta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evento", foreignKey = @ForeignKey(name = "fk_id_evento_encuesta"))
	private Evento evento;

	@Column(name = "url_encuesta")
	private String urlEncuesta;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "encuesta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RespuestaDepartamento> departamentoRespuestas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getOpciones() {
		return opciones;
	}

	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}

	public CatalogoTipoRespuesta getCatalogoTipoRespuesta() {
		return catalogoTipoRespuesta;
	}

	public void setCatalogoTipoRespuesta(CatalogoTipoRespuesta catalogoTipoRespuesta) {
		this.catalogoTipoRespuesta = catalogoTipoRespuesta;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getUrlEncuesta() {
		return urlEncuesta;
	}

	public void setUrlEncuesta(String urlEncuesta) {
		this.urlEncuesta = urlEncuesta;
	}

	public List<RespuestaDepartamento> getDepartamentoRespuestas() {
		return departamentoRespuestas;
	}

	public void setDepartamentoRespuestas(List<RespuestaDepartamento> departamentoRespuestas) {
		this.departamentoRespuestas = departamentoRespuestas;
	}

	/*
	 * Helper Methods
	 */

	public void addRespuestaDepartamento(RespuestaDepartamento respuestaDepartamento) {
		departamentoRespuestas.add(respuestaDepartamento);
		respuestaDepartamento.setEncuesta(this);
	}

	public void removeRespuestaDepartamento(RespuestaDepartamento respuestaDepartamento) {
		departamentoRespuestas.remove(respuestaDepartamento);
		respuestaDepartamento.setEncuesta(null);
	}
}
