package com.bit.management.catalogs.movementtype;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoTipoMovimientoServiceImpl implements CatalogoTipoMovimientoService {

	private static Logger log = LoggerFactory.getLogger(CatalogoTipoMovimientoServiceImpl.class);

	@Autowired
	private CatalogoTipoMovimientoDAO catalogoTipoMovimientoDAO;

	@Override
	@Transactional
	public CatalogoTipoMovimientoView guardar(CatalogoTipoMovimientoView item) {

		log.info("Guardando en base de datos");

		CatalogoTipoMovimiento entity = new CatalogoTipoMovimiento();
		entity.setTipo(item.getTipo());
		entity = catalogoTipoMovimientoDAO.save(entity);

		item.setId(entity.getId());

		return item;
	}

	@Override
	@Transactional
	public List<CatalogoTipoMovimientoView> list(CatalogoTipoMovimientoView item) {
		
		List<CatalogoTipoMovimiento> list = catalogoTipoMovimientoDAO.list();
		List<CatalogoTipoMovimientoView> listViews = new ArrayList<>();
		
		for(CatalogoTipoMovimiento e : list) {
			CatalogoTipoMovimientoView v = new CatalogoTipoMovimientoView();
			v.setId(e.getId());
			v.setTipo(e.getTipo());
			listViews.add(v);
		}
		
		return listViews;
	}
}
