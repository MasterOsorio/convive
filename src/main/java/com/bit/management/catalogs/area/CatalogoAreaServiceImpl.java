package com.bit.management.catalogs.area;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CatalogoAreaServiceImpl implements CatalogoAreaService {
	
	private static Logger log = LoggerFactory.getLogger(CatalogoAreaServiceImpl.class);
	
	@Override
	public CatalogoAreaView guardar(CatalogoAreaView item) {
		
		log.info("Guardando en base de datos");
		CatalogoAreaView a = new CatalogoAreaView();
		
		return a;
	}

}
