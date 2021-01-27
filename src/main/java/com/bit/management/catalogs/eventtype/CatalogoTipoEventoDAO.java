package com.bit.management.catalogs.eventtype;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoTipoEventoDAO extends DAOTemplate<CatalogoTipoEvento, Integer> {

	private static final long serialVersionUID = 3057836627090499837L;
	
	public List<CatalogoTipoEvento> list() {
	
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoTipoEvento.class);
		return (List<CatalogoTipoEvento>) c.list();
	}
}
