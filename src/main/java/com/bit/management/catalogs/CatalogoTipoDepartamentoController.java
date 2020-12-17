package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(name = "catalogs/catalog-department-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoDepartamentoController {
	
	@GetMapping(name = "")
	public String getPantallaCatalogoArea() {

		return "catalogs/template-catalog-department-type";
	}
}
