package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-event-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoEventoController {
	
	@GetMapping(value = "agregar")
	public String getCatalogoTipoEventoController(Model model) {
		
		CatalogoTipoEvento item = new CatalogoTipoEvento();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-event-type";
	}
}

