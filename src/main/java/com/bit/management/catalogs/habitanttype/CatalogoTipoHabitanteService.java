package com.bit.management.catalogs.habitanttype;

import java.util.List;

public interface CatalogoTipoHabitanteService {
	
	public CatalogoTipoHabitanteView guardar(CatalogoTipoHabitanteView item);
	
	public List<CatalogoTipoHabitanteView> list(CatalogoTipoHabitanteView item);
}
