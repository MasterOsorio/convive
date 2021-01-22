package com.bit.management.catalogs.departmenttype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoTipoDepartamentoServiceImpl implements CatalogoTipoDepartamentoService {

	private static Logger log = LoggerFactory.getLogger(CatalogoTipoDepartamentoServiceImpl.class);

	@Autowired
	private CatalogoTipoDepartamentoDAO catalogoTipoDepartamentoDAO;

	@Override
	@Transactional
	public CatalogoTipoDepartamentoView guardar(CatalogoTipoDepartamentoView item) {

		log.info("Guardando en base de datos");

		CatalogoTipoDepartamento entity = new CatalogoTipoDepartamento();
		entity.setNombre(item.getNombre());
		entity.setDescripcion(item.getDescripcion());
		entity = catalogoTipoDepartamentoDAO.save(entity);
		
		item.setId(entity.getId());

		return item;
	}
}
