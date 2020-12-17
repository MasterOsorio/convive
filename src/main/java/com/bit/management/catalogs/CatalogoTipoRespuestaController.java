package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(name = "catalogs/catalog-response-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoRespuestaController {

	@GetMapping(name = "")
	public String getCatalogoTipoRespuestaController() {

		return "catalogs/template-catalog-response-type";
	}
}
