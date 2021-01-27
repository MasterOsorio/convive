package com.bit.management.catalogs.screen;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	@Transactional
	public List<CatalogoPantallaView> list(CatalogoPantallaView item) {
		
		List<CatalogoPantalla> list = catalogoPantallaDAO.list();
		List<CatalogoPantallaView> listViews = new ArrayList<>();
		
		for(CatalogoPantalla e : list) {
			CatalogoPantallaView v = new CatalogoPantallaView();
			v.setId(e.getId());
			v.setPantalla(e.getPantalla());
			v.setDescripcion(e.getDescripcion());
			listViews.add(v);
		}
		
		return listViews;
	}
}
