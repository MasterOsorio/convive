package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(name = "catalogs/catalog-screen")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoPantallaController {
	
	@GetMapping(name = "")
	public String getPantallaCatalogoPantalla() {
		
		return "catalogs/template-catalog-screen";
	}
}
