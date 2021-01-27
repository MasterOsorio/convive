package com.bit.management.catalogs.responsetype;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoTipoRespuestaServiceImpl implements CatalogoTipoRespuestaService {
	
	private static Logger log = LoggerFactory.getLogger(CatalogoTipoRespuestaServiceImpl.class);
	
	@Autowired
	private CatalogoTipoRespuestaDAO catalogoTipoRespuestaDAO;
	
	@Override
	@Transactional
	public CatalogoTipoRespuestaView guardar(CatalogoTipoRespuestaView item) {
		
		log.info("Guardando en base de datos");
		
		CatalogoTipoRespuesta entity = new CatalogoTipoRespuesta();
		entity.setTipo(item.getTipo());
		entity = catalogoTipoRespuestaDAO.save(entity);
		
		item.setId(entity.getId());
		
		return item;
	}

	@Override
	@Transactional
	public List<CatalogoTipoRespuestaView> list(CatalogoTipoRespuestaView item) {
		
		List<CatalogoTipoRespuesta> list = catalogoTipoRespuestaDAO.list();
		List<CatalogoTipoRespuestaView> listViews = new ArrayList<>();
		
		for(CatalogoTipoRespuesta e : list) {
			CatalogoTipoRespuestaView v = new CatalogoTipoRespuestaView();
			v.setId(e.getId());
			v.setTipo(e.getTipo());
			listViews.add(v);
		}
		
		return listViews;
	}
}
