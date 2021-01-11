package com.bit.management.condominum;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bit.comments.Comentario;
import com.bit.management.catalogs.departmenttype.CatalogoTipoDepartamento;
import com.bit.management.eventnotification.NotificacionEvento;
import com.bit.management.eventnotification.RespuestaDepartamento;
import com.bit.management.habitants.Habitante;
import com.bit.management.visitors.Visita;
import com.bit.reservation.amenities.Reservacion;

@Entity
@Table
public class Departamento {

	public Departamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "num_departamento")
	private String numDepartamento;

	@Column
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_departamento", foreignKey = @ForeignKey(name = "fk_id_tipo_departamento"))
	private CatalogoTipoDepartamento catalogoTipoDepartamento;

	@Column(name = "referencia_bancaria")
	private String referenciaBancaria;

	@Column(name = "cuenta_contable")
	private String cuentaContable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_torre", foreignKey = @ForeignKey(name = "fk_id_torre_departamento"))
	private Torre torre;

	@Column(name = "num_recamaras")
	private String numRecamaras;

	@Column(name = "perite_mascotas")
	private boolean permiteMascotas;

	@Column
	private String ubicacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_habitante", foreignKey = @ForeignKey(name = "fk_id_habitante_departamento"))
	private Habitante habitante;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RespuestaDepartamento> respuestas = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estacionamiento> estacionamientos = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservacion> reservaciones = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Visita> visitas = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NotificacionEvento> notificacionesDepartamento = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumDepartamento() {
		return numDepartamento;
	}

	public void setNumDepartamento(String numDepartamento) {
		this.numDepartamento = numDepartamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CatalogoTipoDepartamento getCatalogoTipoDepartamento() {
		return catalogoTipoDepartamento;
	}

	public void setCatalogoTipoDepartamento(CatalogoTipoDepartamento catalogoTipoDepartamento) {
		this.catalogoTipoDepartamento = catalogoTipoDepartamento;
	}

	public String getReferenciaBancaria() {
		return referenciaBancaria;
	}

	public void setReferenciaBancaria(String referenciaBancaria) {
		this.referenciaBancaria = referenciaBancaria;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}

	public String getNumRecamaras() {
		return numRecamaras;
	}

	public void setNumRecamaras(String numRecamaras) {
		this.numRecamaras = numRecamaras;
	}

	public boolean isPermiteMascotas() {
		return permiteMascotas;
	}

	public void setPermiteMascotas(boolean permiteMascotas) {
		this.permiteMascotas = permiteMascotas;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Habitante getHabitante() {
		return habitante;
	}

	public void setHabitante(Habitante habitante) {
		this.habitante = habitante;
	}

	public List<RespuestaDepartamento> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaDepartamento> respuestas) {
		this.respuestas = respuestas;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public void setEstacionamientos(List<Estacionamiento> estacionamientos) {
		this.estacionamientos = estacionamientos;
	}

	public List<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	public List<NotificacionEvento> getNotificacionesDepartamento() {
		return notificacionesDepartamento;
	}

	public void setNotificacionesDepartamento(List<NotificacionEvento> notificacionesDepartamento) {
		this.notificacionesDepartamento = notificacionesDepartamento;
	}

	/*
	 * Helper Methods
	 */

	public void addRespuestaDepartamento(RespuestaDepartamento respuestaDepartamento) {
		respuestas.add(respuestaDepartamento);
		respuestaDepartamento.setDepartamento(this);
	}

	public void removeRespuestaDepartamento(RespuestaDepartamento respuestaDepartamento) {
		respuestas.remove(respuestaDepartamento);
		respuestaDepartamento.setDepartamento(null);
	}

	public void addEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.add(estacionamiento);
		estacionamiento.setDepartamento(this);
	}

	public void removeEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.remove(estacionamiento);
		estacionamiento.setDepartamento(null);
	}

	public void addReservacion(Reservacion reservacion) {
		reservaciones.add(reservacion);
		reservacion.setDepartamento(this);
	}

	public void removeReservacion(Reservacion reservacion) {
		reservaciones.remove(reservacion);
		reservacion.setDepartamento(null);
	}

	public void addComentario(Comentario comentario) {
		comentarios.add(comentario);
		comentario.setDepartamento(this);
	}

	public void removeComentario(Comentario comentario) {
		comentarios.remove(comentario);
		comentario.setDepartamento(null);
	}

	public void addVisita(Visita visita) {
		visitas.add(visita);
		visita.setDepartamento(this);
	}

	public void removeVisita(Visita visita) {
		visitas.remove(visita);
		visita.setDepartamento(null);
	}

	public void addNotificacionEvento(NotificacionEvento notificacionEvento) {
		notificacionesDepartamento.add(notificacionEvento);
		notificacionEvento.setDepartamento(this);
	}

	public void removeNotificacionEvento(NotificacionEvento notificacionEvento) {
		notificacionesDepartamento.add(notificacionEvento);
		notificacionEvento.setDepartamento(null);
	}
}
