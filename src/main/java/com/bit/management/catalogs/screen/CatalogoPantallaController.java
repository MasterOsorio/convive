package com.bit.management.catalogs.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-screen")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoPantallaController {
	
	@Autowired
	private CatalogoPantallaService catalogoPantallaService;
	
	@GetMapping(value = "agregar")
	public String getPantallaCatalogoPantalla(Model model) {
		
		CatalogoPantallaView item = new CatalogoPantallaView();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-screen";
	}
	
	@PostMapping(value = "agregar")
	public String guardarCatalogoPantalla(Model model, @ModelAttribute CatalogoPantallaView item, BindingResult errors) {
		
		catalogoPantallaService.guardar(item);
		
		return "redirect:/catalogs/catalog-screen/agregar";
	}
}
