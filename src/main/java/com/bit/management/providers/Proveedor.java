package com.bit.management.providers;

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
@Table(name = "proveedor")
public class Proveedor {

	public Proveedor() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String servicio;

	@Column
	private String rfc;

	@Column
	private String giro;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DireccionProveedor> direccionProveedores = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonoProveedor> telefonoProveedores = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Movimiento> movimientos = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContactoProveedor> contactos = new ArrayList<>();

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

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public List<DireccionProveedor> getDireccionProveedores() {
		return direccionProveedores;
	}

	public void setDireccionProveedores(List<DireccionProveedor> direccionProveedores) {
		this.direccionProveedores = direccionProveedores;
	}

	public List<TelefonoProveedor> getTelefonoProveedores() {
		return telefonoProveedores;
	}

	public void setTelefonoProveedores(List<TelefonoProveedor> telefonoProveedores) {
		this.telefonoProveedores = telefonoProveedores;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public List<ContactoProveedor> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoProveedor> contactos) {
		this.contactos = contactos;
	}

	/*
	 * Helper Methods
	 */

	public void addDireccionProveedor(DireccionProveedor direccionProveedor) {
		direccionProveedores.add(direccionProveedor);
		direccionProveedor.setProveedor(this);
	}

	public void removeDireccionProveedor(DireccionProveedor direccionProveedor) {
		direccionProveedores.remove(direccionProveedor);
		direccionProveedor.setProveedor(null);
	}

	public void addTelefonoProveedor(TelefonoProveedor telefonoProveedor) {
		telefonoProveedores.add(telefonoProveedor);
		telefonoProveedor.setProveedor(this);
	}

	public void removeTelefonoProveedor(TelefonoProveedor telefonoProveedor) {
		telefonoProveedores.remove(telefonoProveedor);
		telefonoProveedor.setProveedor(null);
	}

	public void addMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
		movimiento.setProveedor(this);
	}

	public void removeMovimiento(Movimiento movimiento) {
		movimientos.remove(movimiento);
		movimiento.setProveedor(null);
	}

	public void addContactoProveedor(ContactoProveedor contactoProveedor) {
		contactos.add(contactoProveedor);
		contactoProveedor.setProveedor(this);
	}

	public void removeContactoProveedor(ContactoProveedor contactoProveedor) {
		contactos.remove(contactoProveedor);
		contactoProveedor.setProveedor(null);
	}
}
