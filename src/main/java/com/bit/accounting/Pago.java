package com.bit.accounting;

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
@Table(name = "pago")
public class Pago {

	public Pago() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "informe_pago")
	private String informePago;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_informe", foreignKey = @ForeignKey(name = "fk_id_tipo_informe"))
	private TipoInforme tipoInforme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInformePago() {
		return informePago;
	}

	public void setInformePago(String informePago) {
		this.informePago = informePago;
	}

	public TipoInforme getTipoInforme() {
		return tipoInforme;
	}

	public void setTipoInforme(TipoInforme tipoInforme) {
		this.tipoInforme = tipoInforme;
	}
}
