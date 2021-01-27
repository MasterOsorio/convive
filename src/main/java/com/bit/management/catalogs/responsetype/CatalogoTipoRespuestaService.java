package com.bit.management.catalogs.responsetype;

import java.util.List;

public interface CatalogoTipoRespuestaService {
	
	public CatalogoTipoRespuestaView guardar(CatalogoTipoRespuestaView item);
	
	public List<CatalogoTipoRespuestaView> list(CatalogoTipoRespuestaView item);
}
