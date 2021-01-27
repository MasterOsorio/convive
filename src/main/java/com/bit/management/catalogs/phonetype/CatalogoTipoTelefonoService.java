package com.bit.management.catalogs.phonetype;

import java.util.List;

public interface CatalogoTipoTelefonoService {

	public CatalogoTipoTelefonoView guardar(CatalogoTipoTelefonoView item);
	
	public List<CatalogoTipoTelefonoView> list(CatalogoTipoTelefonoView item);
}
