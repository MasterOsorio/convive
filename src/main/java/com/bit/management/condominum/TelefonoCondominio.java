package com.bit.management.condominum;

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

import com.bit.management.catalogs.CatalogoTipoTelefono;

@Entity
@Table(name = "telefono_condominio")
public class TelefonoCondominio {

	public TelefonoCondominio() {

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
	@JoinColumn(name = "id_tipo_telefono", foreignKey = @ForeignKey(name = "fk_id_telefono_tipo"))
	private CatalogoTipoTelefono catalogoTipoTelefono;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_condominio", foreignKey = @ForeignKey(name = "fk_telefono_condominio_id"))
	private Condominio condominio;

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

	public Boolean getPreferente() {
		return preferente;
	}

	public void setPreferente(Boolean preferente) {
		this.preferente = preferente;
	}

	public CatalogoTipoTelefono getCatalogoTipoTelefono() {
		return catalogoTipoTelefono;
	}

	public void setCatalogoTipoTelefono(CatalogoTipoTelefono catalogoTipoTelefono) {
		this.catalogoTipoTelefono = catalogoTipoTelefono;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
}
