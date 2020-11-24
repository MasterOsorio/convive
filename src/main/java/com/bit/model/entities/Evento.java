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
@Table(name = "evento")
public class Evento {

	public Evento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String titulo;

	@Column
	private String descripcion;

	@Column(name = "fecha_creacion")
	private java.time.LocalDate fechaCreacion;

	@Column(name = "fecha_evento")
	private java.time.LocalDate fechaEvento;

	@Column(name = "fecha_expiracion")
	private java.time.LocalDate fechaExpiracion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_tipo_evento", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_tipo_evento", foreignKey = @ForeignKey(name = "fk_id_tipo_evento"))
	private CatalogoTipoEvento catalogoTipoEvento;

	@Column(name = "requiere_confirmacion")
	private boolean requiereConfirmacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public java.time.LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(java.time.LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public java.time.LocalDate getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(java.time.LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public java.time.LocalDate getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(java.time.LocalDate fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public CatalogoTipoEvento getCatalogoTipoEvento() {
		return catalogoTipoEvento;
	}

	public void setCatalogoTipoEvento(CatalogoTipoEvento catalogoTipoEvento) {
		this.catalogoTipoEvento = catalogoTipoEvento;
	}

	public boolean isRequiereConfirmacion() {
		return requiereConfirmacion;
	}

	public void setRequiereConfirmacion(boolean requiereConfirmacion) {
		this.requiereConfirmacion = requiereConfirmacion;
	}
}
