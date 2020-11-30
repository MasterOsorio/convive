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
@Table(name = "imagenes")
public class Imagenes {

	public Imagenes() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "path_imagen")
	private String pathImagen;

	@Column
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_condominio", foreignKey = @ForeignKey(name = "fk_imagen_id_condominio"))
	private Condominio condominio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_amenidad", foreignKey = @ForeignKey(name = "fk_imagen_id_amenidad"))
	private Amenidad amenidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_torre", foreignKey = @ForeignKey(name = "fk_imagen_id_torre"))
	private Torre torre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public Amenidad getAmenidad() {
		return amenidad;
	}

	public void setAmenidad(Amenidad amenidad) {
		this.amenidad = amenidad;
	}

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}
}
