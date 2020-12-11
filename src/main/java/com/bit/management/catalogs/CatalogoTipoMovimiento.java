package com.bit.management.catalogs;

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

import com.bit.accounting.Movimiento;

@Entity
@Table(name = "catalogo_tipo_movimiento")
public class CatalogoTipoMovimiento {

	public CatalogoTipoMovimiento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoMovimiento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Movimiento> movimientos = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	/*
	 * Helper Methods
	 */

	public void addMovimineto(Movimiento movimiento) {
		movimientos.add(movimiento);
		movimiento.setCatalogoTipoMovimiento(this);
	}

	public void removeMovimiento(Movimiento movimiento) {
		movimientos.remove(movimiento);
		movimiento.setCatalogoTipoMovimiento(null);
	}
}
