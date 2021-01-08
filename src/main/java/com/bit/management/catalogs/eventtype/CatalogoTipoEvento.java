package com.bit.management.catalogs.eventtype;

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

import com.bit.management.eventnotification.Evento;

@Entity
@Table(name = "catalogo_tipo_evento")
public class CatalogoTipoEvento {

	public CatalogoTipoEvento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoEvento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Evento> eventos = new ArrayList<>();

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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	/*
	 * Helper Methods
	 */

	public void addEvento(Evento evento) {
		eventos.add(evento);
		evento.setCatalogoTipoEvento(this);
	}

	public void removeEvento(Evento evento) {
		eventos.remove(evento);
		evento.setCatalogoTipoEvento(null);
	}
}
