package com.bit.management.catalogs.screen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.management.catalogs.area.CatalogoAreaServiceImpl;

@Service
public class CatalogoPantallaServiceImpl implements CatalogoPantallaService {
	
	private static Logger log = LoggerFactory.getLogger(CatalogoAreaServiceImpl.class);
	
	@Autowired
	private CatalogoPantallaDAO catalogoPantallaDAO;
	
	@Override
	@Transactional
	public CatalogoPantallaView guardar(CatalogoPantallaView item) {
		
		log.info("Guardando en base de datos");
		
		CatalogoPantalla entity = new CatalogoPantalla();
		entity.setPantalla(item.getPantalla());
		entity.setDescripcion(item.getDescripcion());
		entity = catalogoPantallaDAO.save(entity);
		
		item.setId(entity.getId());
		
		return item;
	}
}
