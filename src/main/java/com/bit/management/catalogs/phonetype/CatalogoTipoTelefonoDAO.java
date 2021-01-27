package com.bit.management.catalogs.phonetype;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoTipoTelefonoDAO extends DAOTemplate<CatalogoTipoTelefono, Integer> {

	private static final long serialVersionUID = 592900102641976313L;
	
	public List<CatalogoTipoTelefono> list() {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoTipoTelefono.class);
		
		return (List<CatalogoTipoTelefono>) c.list();
	}
}
