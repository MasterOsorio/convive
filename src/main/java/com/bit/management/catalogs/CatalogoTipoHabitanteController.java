package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(name = "catalogs/catalog-habitant-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoHabitanteController {
	
	@GetMapping(name = "")
	public String getCatalogoTipoHabitanteController() {
		
		return "catalogs/template-catalog-habitant-type";
	}
}
