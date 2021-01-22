package com.bit.management.catalogs.responsetype;

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
	public CatalogoTipoRespuestaVew guardar(CatalogoTipoRespuestaVew item) {
		
		log.info("Guardando en base de datos");
		
		CatalogoTipoRespuesta entity = new CatalogoTipoRespuesta();
		entity.setTipo(item.getTipo());
		entity = catalogoTipoRespuestaDAO.save(entity);
		
		item.setId(entity.getId());
		
		return item;
	}
}
