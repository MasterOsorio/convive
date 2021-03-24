package com.bit.management.catalogs.area;

import java.util.List;

import com.bit.management.catalogs.screen.MenuWrapperView;

public interface CatalogoAreaService {

	public CatalogoAreaView guardar(CatalogoAreaView item);

	public List<CatalogoAreaView> list(CatalogoAreaView item);
}
