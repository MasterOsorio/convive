package com.bit.management.catalogs.departmenttype;

import java.util.List;

public interface CatalogoTipoDepartamentoService {
	
	public CatalogoTipoDepartamentoView guardar(CatalogoTipoDepartamentoView item);
	public List<CatalogoTipoDepartamentoView> list(CatalogoTipoDepartamentoView item);
}
