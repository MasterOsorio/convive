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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_tipo_telefono", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_tipo_telefono", foreignKey = @ForeignKey(name = "fk_telefono_hab_id_tipo_telefono"))
	private CatalogoTipoTelefono catalogoTipoTelefono;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "habitante", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_habitante", foreignKey = @ForeignKey(name = "fk_telefono_id_habitante"))
	private Habitante habitante;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familiar", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_familiar", foreignKey = @ForeignKey(name = "id"))
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
