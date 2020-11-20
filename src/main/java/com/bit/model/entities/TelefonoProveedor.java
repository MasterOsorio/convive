package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefono_proveedor")
public class TelefonoProveedor {

	public TelefonoProveedor() {

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

	@ManyToOne
	@JoinColumn(name = "id_proveedor", referencedColumnName = "id")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "id_tipo_telefono", referencedColumnName = "id")
	private CatalogoTipoTelefono catalogoTipoTelefono;

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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public CatalogoTipoTelefono getCatalogoTipoTelefono() {
		return catalogoTipoTelefono;
	}

	public void setCatalogoTipoTelefono(CatalogoTipoTelefono catalogoTipoTelefono) {
		this.catalogoTipoTelefono = catalogoTipoTelefono;
	}
}
