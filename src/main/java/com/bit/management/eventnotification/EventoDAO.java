package com.bit.management.eventnotification;

import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class EventoDAO extends DAOTemplate<Evento, Integer> {

	private static final long serialVersionUID = -583926590421741025L;

}
