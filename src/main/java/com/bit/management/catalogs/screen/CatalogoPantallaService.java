package com.bit.management.catalogs.screen;

import java.util.List;

public interface CatalogoPantallaService {
	
	public CatalogoPantallaView guardar(CatalogoPantallaView item);
	
	public List<CatalogoPantallaView> list(CatalogoPantallaView item);
	
	public List<MenuWrapperView> listMenusWithSubmenus();
}
