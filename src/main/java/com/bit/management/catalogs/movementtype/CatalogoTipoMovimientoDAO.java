package com.bit.management.catalogs.movementtype;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoTipoMovimientoDAO extends DAOTemplate<CatalogoTipoMovimiento, Integer> {

	private static final long serialVersionUID = 6341864535291583556L;
	
	public List<CatalogoTipoMovimiento> list() {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoTipoMovimiento.class);
		
		return (List<CatalogoTipoMovimiento>) c.list();
	}
}
