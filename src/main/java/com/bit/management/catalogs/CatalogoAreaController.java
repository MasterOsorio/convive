package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-area")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoAreaController {

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoArea( Model model ) {
		
		CatalogoArea item = new CatalogoArea();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-area";
	}
}
