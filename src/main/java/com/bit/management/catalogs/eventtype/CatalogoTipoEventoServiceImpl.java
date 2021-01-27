package com.bit.management.catalogs.eventtype;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoTipoEventoServiceImpl implements CatalogoTipoEventoService{

	private static Logger log = LoggerFactory.getLogger(CatalogoTipoEventoServiceImpl.class);

	@Autowired
	private CatalogoTipoEventoDAO catalogoTipoEventoDAO;

	@Override
	@Transactional
	public CatalogoTipoEventoView guardar(CatalogoTipoEventoView item) {

		log.info("Guardando en base de datos");

		CatalogoTipoEvento entity = new CatalogoTipoEvento();
		entity.setTipo(item.getTipo());
		entity = catalogoTipoEventoDAO.save(entity);

		item.setId(entity.getId());

		return item;
	}

	@Override
	@Transactional
	public List<CatalogoTipoEventoView> list(CatalogoTipoEventoView item) {
		
		List<CatalogoTipoEvento> list = catalogoTipoEventoDAO.list();
		List<CatalogoTipoEventoView> listViews = new ArrayList<>();
		
		for(CatalogoTipoEvento e : list) {
			CatalogoTipoEventoView v = new CatalogoTipoEventoView();
			v.setId(e.getId());
			v.setTipo(e.getTipo());
			listViews.add(v);
		}
		
		return listViews;
	}
}
