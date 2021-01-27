package com.bit.management.catalogs.screen;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoPantallaDAO extends DAOTemplate<CatalogoPantalla, Integer> {

	private static final long serialVersionUID = -5701059766927975004L;
	
	public List<CatalogoPantalla> list() {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoPantalla.class);
		
		return (List<CatalogoPantalla>) c.list();
	}
}
