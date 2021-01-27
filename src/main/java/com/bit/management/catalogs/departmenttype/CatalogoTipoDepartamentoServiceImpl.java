package com.bit.management.catalogs.departmenttype;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	@Transactional
	public List<CatalogoTipoDepartamentoView> list(CatalogoTipoDepartamentoView item) {
		List<CatalogoTipoDepartamento> list = catalogoTipoDepartamentoDAO.list();
		List<CatalogoTipoDepartamentoView> listViews = new ArrayList<>();
		
		for(CatalogoTipoDepartamento e : list) {
			CatalogoTipoDepartamentoView v = new CatalogoTipoDepartamentoView();
			v.setId(e.getId());
			v.setNombre(e.getNombre());
			v.setDescripcion(e.getDescripcion());
			listViews.add(v);
		}
		
		return listViews;
	}
}
