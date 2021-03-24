package com.bit.management.catalogs.screen;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.management.catalogs.area.CatalogoAreaServiceImpl;

@Service
public class CatalogoPantallaServiceImpl implements CatalogoPantallaService {

	private static Logger log = LoggerFactory.getLogger(CatalogoAreaServiceImpl.class);

	@Autowired
	private CatalogoPantallaDAO catalogoPantallaDAO;

	@Override
	@Transactional
	public CatalogoPantallaView guardar(CatalogoPantallaView item) {

		log.info("Guardando en base de datos");

		CatalogoPantalla entity = new CatalogoPantalla();
		entity.setPantalla(item.getPantalla());
		entity.setDescripcion(item.getDescripcion());
		entity = catalogoPantallaDAO.save(entity);

		item.setId(entity.getId());

		return item;
	}

	@Override
	@Transactional
	public List<CatalogoPantallaView> list(CatalogoPantallaView item) {

		List<CatalogoPantalla> list = catalogoPantallaDAO.list();
		List<CatalogoPantallaView> listViews = new ArrayList<>();

		for (CatalogoPantalla e : list) {
			CatalogoPantallaView v = new CatalogoPantallaView();
			v.setId(e.getId());
			v.setPantalla(e.getPantalla());
			v.setDescripcion(e.getDescripcion());
			listViews.add(v);
		}

		return listViews;
	}

	@Override
	@Transactional
	public List<MenuWrapperView> listMenusWithSubmenus() {

		List<MenuWrapperView> menus = new ArrayList<>();
		List<CatalogoPantalla> listParent = catalogoPantallaDAO.onlyParents();

		for (CatalogoPantalla parent : listParent) {

			MenuWrapperView w = new MenuWrapperView();

			MenuItemView p = new MenuItemView();
			p.setId(parent.getId());
			p.setPantalla(parent.getPantalla());
			p.setDescripcion(parent.getCategoria());
			p.setPerteneceA(parent.getPerteneceA());
			p.setLink(parent.getLink());

			w.setParent(p);

			List<MenuItemView> listChild = new ArrayList<>();
			List<CatalogoPantalla> listChildren = catalogoPantallaDAO.findChildrendByParentId(parent.getId());

			for (CatalogoPantalla child : listChildren) {

				MenuItemView c = new MenuItemView();
				c.setId(child.getId());
				c.setPantalla(child.getPantalla());
				c.setDescripcion(child.getDescripcion());
				c.setCategoria(child.getCategoria());
				c.setPerteneceA(child.getPerteneceA());
				c.setLink(child.getLink());

				listChild.add(c);
			}

			w.setChildren(listChild);

			menus.add(w);
		}

		return menus;
	}
}
