package com.bit.dao;

import org.springframework.stereotype.Repository;

import com.bit.model.entities.Movimiento;

@Repository
public class MovimientoDAO extends DAOTemplate<Movimiento, Integer> {

	private static final long serialVersionUID = 3229940125562066527L;

}
