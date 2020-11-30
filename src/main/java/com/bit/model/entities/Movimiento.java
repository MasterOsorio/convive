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
@Table(name = "movimiento")
public class Movimiento {

	public Movimiento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String folio;

	@Column
	private String concepto;

	@Column
	private double monto;

	@Column
	private String iva;

	@Column(name = "fecha_captura")
	private java.time.LocalDate fechaCaptura;

	@Column(name = "fecha_movimiento")
	private String fechaMovimiento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo", foreignKey = @ForeignKey(name = "fk_id_tipo_movimiento"))
	private CatalogoTipoMovimiento catalogoTipoMovimiento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor", foreignKey = @ForeignKey(name = "fk_id_proveedor_movimiento"))
	private Proveedor proveedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public java.time.LocalDate getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaCaptura(java.time.LocalDate fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public CatalogoTipoMovimiento getCatalogoTipoMovimiento() {
		return catalogoTipoMovimiento;
	}

	public void setCatalogoTipoMovimiento(CatalogoTipoMovimiento catalogoTipoMovimiento) {
		this.catalogoTipoMovimiento = catalogoTipoMovimiento;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
