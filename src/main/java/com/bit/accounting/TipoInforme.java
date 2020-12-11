package com.bit.accounting;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_informe")
public class TipoInforme {

	public TipoInforme() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tipo_informe")
	private String tipoInforme;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoInforme", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pago> pagos = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoInforme() {
		return tipoInforme;
	}

	public void setTipoInforme(String tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	/*
	 * Helper Methods
	 */

	public void addPago(Pago pago) {
		pagos.add(pago);
		pago.setTipoInforme(this);
	}

	public void removePago(Pago pago) {
		pagos.remove(pago);
		pago.setTipoInforme(null);
	}
}
