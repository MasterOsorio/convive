package com.bit.management.catalogs.habitanttype;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoTipoHabitanteDAO extends DAOTemplate<CatalogoTipoHabitante, Integer> {

	private static final long serialVersionUID = 5173672438652220875L;
	
	public List<CatalogoTipoHabitante> list() {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoTipoHabitante.class);
		
		return (List<CatalogoTipoHabitante>) c.list();
	}
}
