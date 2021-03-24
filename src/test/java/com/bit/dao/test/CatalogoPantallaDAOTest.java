package com.bit.dao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bit.config.WebConfig;
import com.bit.management.catalogs.screen.CatalogoPantalla;
import com.bit.management.catalogs.screen.CatalogoPantallaDAO;
import com.bit.management.catalogs.screen.MenuItemView;
import com.bit.management.catalogs.screen.MenuWrapperView;
import com.bit.utils.ConviveUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class CatalogoPantallaDAOTest {

	@Autowired
	private CatalogoPantallaDAO catalogoPantallaDAO;

	@Test
	@Transactional
	@Rollback(value = false)
	public void listPantalla() {

		List<CatalogoPantalla> list = catalogoPantallaDAO.onlyParents();

		for (CatalogoPantalla listParent : list) {
			System.out.println(listParent.getPantalla() + " " + listParent.getCategoria());
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void listChildrenByParentId() {

		List<CatalogoPantalla> list = catalogoPantallaDAO.findChildrendByParentId(1);

		for (CatalogoPantalla listChildren : list) {
			System.out.println(listChildren.getPantalla() + " " + listChildren.getCategoria() + " "
					+ listChildren.getPerteneceA());
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void listParentsWithChildrens() {

		List<CatalogoPantalla> listParents = catalogoPantallaDAO.onlyParents();

		for (CatalogoPantalla lp : listParents) {

			List<CatalogoPantalla> listChildren = catalogoPantallaDAO.findChildrendByParentId(lp.getId());

			System.out
					.println("Padre: " + lp.getPantalla() + " Categoria: " + lp.getCategoria() + " Id: " + lp.getId());

			for (CatalogoPantalla lc : listChildren) {

				System.out.println("Padre: " + lp.getPantalla() + " Categoria: " + lp.getCategoria() + " Id: "
						+ lp.getId() + " Hijo: " + lc.getPantalla() + " Categoria: " + lc.getCategoria() + " Id: "
						+ lc.getId() + " Pertenece a: " + lc.getPerteneceA());
			}
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void listMenuSubMenu() {

		List<MenuWrapperView> menus = new ArrayList<>();

		List<CatalogoPantalla> listParents = catalogoPantallaDAO.onlyParents();

		for (CatalogoPantalla currentParent : listParents) {

			MenuWrapperView w = new MenuWrapperView();

			MenuItemView p = new MenuItemView();
			p.setId(currentParent.getId());
			p.setPantalla(currentParent.getPantalla());
			p.setCategoria(currentParent.getCategoria());

			w.setParent(p);

			List<MenuItemView> listChild = new ArrayList<>();

			List<CatalogoPantalla> listChildren = catalogoPantallaDAO.findChildrendByParentId(currentParent.getId());

			for (CatalogoPantalla currentChild : listChildren) {

				MenuItemView child = new MenuItemView();
				child.setId(currentChild.getId());
				child.setPantalla(currentChild.getPantalla());
				child.setCategoria(currentChild.getCategoria());

				listChild.add(child);

				w.setChildren(listChild);
			}

			menus.add(w);
		}

//		printMenus(menus);
//		printMenuForEach(menus);
		printMenuForNormal(menus);
	}

//	@transactional sirve para acceder a base de datos
//	metodo void para imprimir menus
	public void printMenus(List<MenuWrapperView> menus) {

		for (MenuWrapperView m : menus) {

			if (m != null) {

				System.out.println("Menu: " + m.getParent().getPantalla());

				for (int i = 0; i < m.getChildren().size(); i++) {

					System.out.println("\t Submenu: " + m.getChildren().get(i).getPantalla());
				}

			} else {
				System.out.println("No hay menus");
			}
		}
	}

	public void printMenuForEach(List<MenuWrapperView> menus) {

		for (MenuWrapperView menu : menus) {

			if (menu != null) {

				System.out.println("Menu: " + menu.getParent().getPantalla());

				for (MenuItemView submenu : menu.getChildren()) {

					System.out.println("\t Submenu: " + submenu.getPantalla());
				}

			} else {

				System.out.println("No hay menus");
			}
		}
	}

	public void printMenuForNormal(List<MenuWrapperView> menus) {

		for (int i = 0; i < menus.size(); i++) {

			if (menus.get(i) != null) {

				System.out.println("Menu: " + menus.get(i).getParent().getPantalla());

				for (int j = 0; j < menus.get(i).getChildren().size(); j++) {

					System.out.println("\t Submenu: " + menus.get(i).getChildren().get(j).getPantalla());
				}
				
			} else {

				System.out.println("No hay menus");
			}
		}
	}
	
	@Test
	public void findHierarchy() {
//		para llamar un metodo estatico se escribe el nombre la clase y el nombre del metodo
		Map<String, Integer> h = ConviveUtils.findHierarchy(1);
		Integer valorParent = h.get("ID_PARENT");
		Integer valorChild = h.get("ID_CHILD");
		
		System.out.println(valorParent + ", " + valorChild);
	}
}
