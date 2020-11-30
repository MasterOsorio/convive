package com.bit.model.entities;

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

@Entity
@Table(name = "torre")
public class Torre {

	public Torre() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String ubicacion;

	@Column
	private String nombre;

	@Column(name = "num_deptos")
	private int numDeptos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_condominio", foreignKey = @ForeignKey(name = "fk_id_condominio"))
	private Condominio condominio;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "torre", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Imagenes> imagenTorres = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "torre", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Amenidad> amenidadTorres = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumDeptos() {
		return numDeptos;
	}

	public void setNumDeptos(int numDeptos) {
		this.numDeptos = numDeptos;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public List<Imagenes> getImagenTorres() {
		return imagenTorres;
	}

	public void setImagenTorres(List<Imagenes> imagenTorres) {
		this.imagenTorres = imagenTorres;
	}

	public List<Amenidad> getAmenidadTorres() {
		return amenidadTorres;
	}

	public void setAmenidadTorres(List<Amenidad> amenidadTorres) {
		this.amenidadTorres = amenidadTorres;
	}

	/*
	 * Helper Methods
	 */

	public void addImagenes(Imagenes imagenes) {
		imagenTorres.add(imagenes);
		imagenes.setTorre(this);
	}

	public void removeImagenes(Imagenes imagenes) {
		imagenTorres.remove(imagenes);
		imagenes.setTorre(null);
	}

	public void addAmenidad(Amenidad amenidad) {
		amenidadTorres.add(amenidad);
		amenidad.setTorre(this);
	}

	public void removeAmenidad(Amenidad amenidad) {
		amenidadTorres.remove(amenidad);
		amenidad.setTorre(null);
	}
}
