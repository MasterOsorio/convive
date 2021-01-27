package com.bit.management.catalogs.area;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoAreaDAO extends DAOTemplate<CatalogoArea, Integer> {

	private static final long serialVersionUID = -7399700491976653329L;
	
	public List<CatalogoArea> list() {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoArea.class);
		
		return (List<CatalogoArea>) c.list();
	}
}
