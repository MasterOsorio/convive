package com.bit.management.catalogs.departmenttype;

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

import com.bit.management.condominum.Departamento;

@Entity
@Table(name = "catalogo_tipo_departamento")
public class CatalogoTipoDepartamento {

	public CatalogoTipoDepartamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String descripcion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoDepartamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Departamento> departamentosCatalogo = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Departamento> getDepartamentosCatalogo() {
		return departamentosCatalogo;
	}

	public void setDepartamentosCatalogo(List<Departamento> departamentosCatalogo) {
		this.departamentosCatalogo = departamentosCatalogo;
	}

	/*
	 * Helper Methods
	 */

	public void addDepartamento(Departamento departamento) {
		departamentosCatalogo.add(departamento);
		departamento.setCatalogoTipoDepartamento(this);
	}

	public void removeDepartamento(Departamento departamento) {
		departamentosCatalogo.remove(departamento);
		departamento.setCatalogoTipoDepartamento(null);
	}
}
