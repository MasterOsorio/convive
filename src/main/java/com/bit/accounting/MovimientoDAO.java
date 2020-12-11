package com.bit.accounting;

import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class MovimientoDAO extends DAOTemplate<Movimiento, Integer> {

	private static final long serialVersionUID = 3229940125562066527L;

}
