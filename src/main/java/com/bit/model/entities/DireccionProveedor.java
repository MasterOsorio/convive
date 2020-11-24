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
@Table(name = "direccion_proveedor")
public class DireccionProveedor {

	public DireccionProveedor() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String calle;

	@Column(name = "num_int")
	private String numInt;

	@Column(name = "num_ext")
	private String numExt;

	@Column(name = "codigo_postal")
	private String codigoPostal;

	@Column
	private String colonia;

	@Column
	private String estado;

	@Column(name = "ciudad_poblacion")
	private String ciudadPoblacion;

	@Column
	private String pais;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_proveedor", foreignKey = @ForeignKey(name = "fk_direccion_proveedor"))
	private Proveedor proveedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumInt() {
		return numInt;
	}

	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}

	public String getNumExt() {
		return numExt;
	}

	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudadPoblacion() {
		return ciudadPoblacion;
	}

	public void setCiudadPoblacion(String ciudadPoblacion) {
		this.ciudadPoblacion = ciudadPoblacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
