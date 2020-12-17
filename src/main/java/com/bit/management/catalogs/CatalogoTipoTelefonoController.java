package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(name = "catalogs/catalog-phone-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoTelefonoController {

	@GetMapping(name = "")
	public String getCatalogoTipoTelefonoController() {

		return "catalogs/template-catalog-phone-type";
	}
}
