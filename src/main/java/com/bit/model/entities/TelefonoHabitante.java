package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefono_habitante")
public class TelefonoHabitante {
	
	public TelefonoHabitante() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String lada;
	
	@Column
	private String numero;
	
	@Column
	private String extension;
	
	@Column
	private boolean preferente;
	
	private CatalogoTipoTelefono catalogoTipoTelefono;
	
	private Habitante habitante;
	
	private Familiar familiar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLada() {
		return lada;
	}

	public void setLada(String lada) {
		this.lada = lada;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public boolean isPreferente() {
		return preferente;
	}

	public void setPreferente(boolean preferente) {
		this.preferente = preferente;
	}

	public CatalogoTipoTelefono getCatalogoTipoTelefono() {
		return catalogoTipoTelefono;
	}

	public void setCatalogoTipoTelefono(CatalogoTipoTelefono catalogoTipoTelefono) {
		this.catalogoTipoTelefono = catalogoTipoTelefono;
	}

	public Habitante getHabitante() {
		return habitante;
	}

	public void setHabitante(Habitante habitante) {
		this.habitante = habitante;
	}

	public Familiar getFamiliar() {
		return familiar;
	}

	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}
}
