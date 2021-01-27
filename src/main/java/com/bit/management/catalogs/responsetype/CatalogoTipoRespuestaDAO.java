package com.bit.management.catalogs.responsetype;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoTipoRespuestaDAO extends DAOTemplate<CatalogoTipoRespuesta, Integer> {

	private static final long serialVersionUID = -7428712844406134723L;
	
	public List<CatalogoTipoRespuesta> list() {
		
		Criteria c =getSessionFactory().getCurrentSession().createCriteria(CatalogoTipoRespuesta.class);
		
		return (List<CatalogoTipoRespuesta>) c.list();
	}
}
