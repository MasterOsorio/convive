package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-habitant-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoHabitanteController {
	
	@GetMapping(value = "agregar")
	public String getCatalogoTipoHabitanteController(Model model) {
		
		CatalogoTipoHabitante item = new CatalogoTipoHabitante();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-habitant-type";
	}
}
