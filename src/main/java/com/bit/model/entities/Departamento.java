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
@Table
public class Departamento {

	public Departamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "num_departamento")
	private String numDepartamento;

	@Column
	private String descripcion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo_tipo_departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_tipo_departamento", foreignKey = @ForeignKey(name = "fk_id_tipo_departamento"))
	private CatalogoTipoDepartamento catalogoTipoDepartamento;

	@Column(name = "referencia_bancaria")
	private String referenciaBancaria;

	@Column(name = "cuenta_contable")
	private String cuentaContable;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "torre", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_torre", foreignKey = @ForeignKey(name = "fk_id_torre_departamento"))
	private Torre torre;

	@Column(name = "num_recamaras")
	private String numRecamaras;

	@Column(name = "perite_mascotas")
	private boolean permiteMascotas;

	@Column
	private String ubicacion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "habitante", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_habitante", foreignKey = @ForeignKey(name = "fk_id_habitante_departamento"))
	private Habitante habitante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumDepartamento() {
		return numDepartamento;
	}

	public void setNumDepartamento(String numDepartamento) {
		this.numDepartamento = numDepartamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CatalogoTipoDepartamento getCatalogoTipoDepartamento() {
		return catalogoTipoDepartamento;
	}

	public void setCatalogoTipoDepartamento(CatalogoTipoDepartamento catalogoTipoDepartamento) {
		this.catalogoTipoDepartamento = catalogoTipoDepartamento;
	}

	public String getReferenciaBancaria() {
		return referenciaBancaria;
	}

	public void setReferenciaBancaria(String referenciaBancaria) {
		this.referenciaBancaria = referenciaBancaria;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}

	public String getNumRecamaras() {
		return numRecamaras;
	}

	public void setNumRecamaras(String numRecamaras) {
		this.numRecamaras = numRecamaras;
	}

	public boolean isPermiteMascotas() {
		return permiteMascotas;
	}

	public void setPermiteMascotas(boolean permiteMascotas) {
		this.permiteMascotas = permiteMascotas;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Habitante getHabitante() {
		return habitante;
	}

	public void setHabitante(Habitante habitante) {
		this.habitante = habitante;
	}
}
