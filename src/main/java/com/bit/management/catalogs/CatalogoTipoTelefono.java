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

import com.bit.management.condominum.TelefonoCondominio;
import com.bit.management.habitants.TelefonoHabitante;
import com.bit.management.providers.TelefonoProveedor;

@Entity
@Table(name = "catalogo_tipo_telefono")
public class CatalogoTipoTelefono {

	public CatalogoTipoTelefono() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoTelefono", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonoProveedor> telefonoProveedores = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoTelefono", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonoHabitante> telefonoHabitantes = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogoTipoTelefono", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonoCondominio> telefonoCondominios = new ArrayList<>();

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

	public List<TelefonoProveedor> getTelefonoProveedores() {
		return telefonoProveedores;
	}

	public void setTelefonoProveedores(List<TelefonoProveedor> telefonoProveedores) {
		this.telefonoProveedores = telefonoProveedores;
	}

	public List<TelefonoHabitante> getTelefonoHabitantes() {
		return telefonoHabitantes;
	}

	public void setTelefonoHabitantes(List<TelefonoHabitante> telefonoHabitantes) {
		this.telefonoHabitantes = telefonoHabitantes;
	}

	public List<TelefonoCondominio> getTelefonoCondominios() {
		return telefonoCondominios;
	}

	public void setTelefonoCondominios(List<TelefonoCondominio> telefonoCondominios) {
		this.telefonoCondominios = telefonoCondominios;
	}

	/*
	 * Helper Methods
	 */

	public void addTelefonoProveedor(TelefonoProveedor telefonoProveedor) {
		telefonoProveedores.add(telefonoProveedor);
		telefonoProveedor.setCatalogoTipoTelefono(this);
	}

	public void removeTelefonoProveedor(TelefonoProveedor telefonoProveedor) {
		telefonoProveedores.remove(telefonoProveedor);
		telefonoProveedor.setCatalogoTipoTelefono(null);
	}

	public void addTelefonoHabitante(TelefonoHabitante telefonoHabitante) {
		telefonoHabitantes.add(telefonoHabitante);
		telefonoHabitante.setCatalogoTipoTelefono(this);
	}

	public void removeTelefonoHabitante(TelefonoHabitante telefonoHabitante) {
		telefonoHabitantes.remove(telefonoHabitante);
		telefonoHabitante.setCatalogoTipoTelefono(null);
	}

	public void addTelefonoCondiminio(TelefonoCondominio telefonoCondominio) {
		telefonoCondominios.add(telefonoCondominio);
		telefonoCondominio.setCatalogoTipoTelefono(this);
	}

	public void removeTelefonoCondominio(TelefonoCondominio telefonoCondominio) {
		telefonoCondominios.remove(telefonoCondominio);
		telefonoCondominio.setCatalogoTipoTelefono(null);
	}
}
