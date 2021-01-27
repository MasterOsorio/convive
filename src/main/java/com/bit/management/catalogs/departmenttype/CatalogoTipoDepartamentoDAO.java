package com.bit.management.catalogs.departmenttype;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoTipoDepartamentoDAO extends DAOTemplate<CatalogoTipoDepartamento, Integer> {

	private static final long serialVersionUID = 8740129230672011769L;

	public List<CatalogoTipoDepartamento> list() {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoTipoDepartamento.class);
		return (List<CatalogoTipoDepartamento>) c.list();
	}
}
