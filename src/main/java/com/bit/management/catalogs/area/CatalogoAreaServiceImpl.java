package com.bit.management.catalogs.area;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoAreaServiceImpl implements CatalogoAreaService {

	private static Logger log = LoggerFactory.getLogger(CatalogoAreaServiceImpl.class);

	@Autowired
	private CatalogoAreaDAO catalogAreaDAO;

	@Override
	@Transactional
	public CatalogoAreaView guardar(CatalogoAreaView item) {

		log.info("Guardando en base de datos");

		CatalogoArea entity = new CatalogoArea();
		entity.setArea(item.getArea());
		entity = catalogAreaDAO.save(entity);

		item.setId(entity.getId());

		return item;
	}
}
