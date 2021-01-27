package com.bit.management.catalogs.area;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoAreaServiceImpl implements CatalogoAreaService {

	private static Logger log = LoggerFactory.getLogger(CatalogoAreaServiceImpl.class);
	
	@Autowired
	private CatalogoAreaDAO catalogoAreaDAO; 
	
	@Override
	@Transactional
	public CatalogoAreaView guardar(CatalogoAreaView item) {

		log.info("Guardando en base de datos");
		
		//1. Convertir de CatalogoAreaView a CatalogoArea
		CatalogoArea entity = new CatalogoArea();
		entity.setArea( item.getArea() );
		entity = catalogoAreaDAO.save(entity);
		
		item.setId( entity.getId() );
		
		return item;
	}

	@Override
	@Transactional
	public List<CatalogoAreaView> list(CatalogoAreaView item) {
		
		List<CatalogoArea> list = catalogoAreaDAO.list();
		List<CatalogoAreaView> listViews = new ArrayList<>();
		
		for( CatalogoArea e : list ) {
			CatalogoAreaView v = new CatalogoAreaView();
			v.setId( e.getId() );
			v.setArea( e.getArea() );
			listViews.add(v);
		}
		
		return listViews;
	}
}
