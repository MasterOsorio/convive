package com.bit.management.catalogs.movementtype;

import java.util.List;

public interface CatalogoTipoMovimientoService {
	
	public CatalogoTipoMovimientoView guardar(CatalogoTipoMovimientoView item);
	
	public List<CatalogoTipoMovimientoView> list(CatalogoTipoMovimientoView item);
}
