package com.bit.management.catalogs.area;

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
@RequestMapping(value = "catalogs/catalog-area")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoAreaController {
	
	@Autowired
	private CatalogoAreaService catalogoAreaService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoArea(Model model) {

		CatalogoAreaView item = new CatalogoAreaView();
		model.addAttribute("viewdataform", item);

		return "catalogs/template-catalog-area";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoArea(Model model, @ModelAttribute CatalogoAreaView item, BindingResult errors) {

		catalogoAreaService.guardar(item);
		
		return "redirect:/catalogs/catalog-area/agregar";
	}
}
