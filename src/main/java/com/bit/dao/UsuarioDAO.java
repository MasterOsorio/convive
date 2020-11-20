package com.bit.dao;

import org.springframework.stereotype.Repository;

import com.bit.model.entities.Usuario;

@Repository
public class UsuarioDAO extends DAOTemplate<Usuario, Integer>{

	private static final long serialVersionUID = -7468641436290162866L;

}
