package com.bit.management.catalogs.eventtype;

import java.util.List;

public interface CatalogoTipoEventoService {
	
	public CatalogoTipoEventoView guardar(CatalogoTipoEventoView item);
	public List<CatalogoTipoEventoView> list(CatalogoTipoEventoView item);
}
