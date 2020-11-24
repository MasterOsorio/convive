package com.bit.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private boolean preferente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "")
	private CatalogoTipoTelefono catalogoTipoTelefono;
}
