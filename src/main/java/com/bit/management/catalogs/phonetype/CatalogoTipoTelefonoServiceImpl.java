package com.bit.management.catalogs.phonetype;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoTipoTelefonoServiceImpl implements CatalogoTipoTelefonoService {
	
	private static Logger log = LoggerFactory.getLogger(CatalogoTipoTelefonoServiceImpl.class);
	
	@Autowired
	private CatalogoTipoTelefonoDAO catalogoTipoTelefonoDAO;
	
	@Override
	@Transactional
	public CatalogoTipoTelefonoView guardar(CatalogoTipoTelefonoView item) {
		
		log.info("Guardando en base de datos");
		
		CatalogoTipoTelefono entity = new CatalogoTipoTelefono();
		entity.setTipo(item.getTipo());
		entity = catalogoTipoTelefonoDAO.save(entity);
		
		item.setId(entity.getId());
		
		return item;
	}

	@Override
	@Transactional
	public List<CatalogoTipoTelefonoView> list(CatalogoTipoTelefonoView item) {
		
		List<CatalogoTipoTelefono> list = catalogoTipoTelefonoDAO.list();
		List<CatalogoTipoTelefonoView> listViews = new ArrayList<>();
		
		for(CatalogoTipoTelefono e : list) {
			CatalogoTipoTelefonoView v = new CatalogoTipoTelefonoView();
			v.setId(e.getId());
			v.setTipo(e.getTipo());
			listViews.add(v);
		}
		
		return listViews;
	}
}
