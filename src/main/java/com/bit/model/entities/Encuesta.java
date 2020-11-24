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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_tipo_respuesta", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_tipo_respuesta", foreignKey = @ForeignKey(name = "fk_id_tipo_respuesta"))
	private CatalogoTipoRespuesta catalogoTipoRespuesta;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_evento", foreignKey = @ForeignKey(name = "fk_id_evento_encuesta"))
	private Evento evento;

	@Column(name = "url_encuesta")
	private String urlEncuesta;
}
