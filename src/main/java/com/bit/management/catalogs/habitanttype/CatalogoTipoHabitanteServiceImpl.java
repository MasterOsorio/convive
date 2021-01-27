package com.bit.management.catalogs.habitanttype;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoTipoHabitanteServiceImpl implements CatalogoTipoHabitanteService {

	private static Logger log = LoggerFactory.getLogger(CatalogoTipoHabitanteServiceImpl.class);

	@Autowired
	private CatalogoTipoHabitanteDAO catalogoTipoHabitanteDAO;

	@Override
	@Transactional
	public CatalogoTipoHabitanteView guardar(CatalogoTipoHabitanteView item) {

		log.info("Guardando en base de datos");

		CatalogoTipoHabitante entity = new CatalogoTipoHabitante();
		entity.setTipo(item.getTipo());
		entity = catalogoTipoHabitanteDAO.save(entity);

		item.setId(entity.getId());

		return item;
	}

	@Override
	@Transactional
	public List<CatalogoTipoHabitanteView> list(CatalogoTipoHabitanteView item) {
		
		List<CatalogoTipoHabitante> list = catalogoTipoHabitanteDAO.list();
		List<CatalogoTipoHabitanteView> listViews = new ArrayList<>();
		
		for(CatalogoTipoHabitante e : list) {
			CatalogoTipoHabitanteView v = new CatalogoTipoHabitanteView();
			v.setId(e.getId());
			v.setTipo(e.getTipo());
			listViews.add(v);
		}
		
		return listViews;
	}
}
