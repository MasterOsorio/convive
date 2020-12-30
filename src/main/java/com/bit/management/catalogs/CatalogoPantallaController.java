package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-screen")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoPantallaController {
	
	@GetMapping(value = "agregar")
	public String getPantallaCatalogoPantalla(Model model) {
		
		CatalogoPantalla item = new CatalogoPantalla();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-screen";
	}
}
