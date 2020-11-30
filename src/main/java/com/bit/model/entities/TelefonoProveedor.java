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
	private Boolean preferente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor", foreignKey = @ForeignKey(name = "fk_id_proveedor_telefono"))
	private Proveedor proveedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_telefono", foreignKey = @ForeignKey(name = "fk_telefono_proveedor_id_tipo_telefono"))
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
