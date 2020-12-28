package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-response-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoRespuestaController {

	@GetMapping(value = "agregar")
	public String getCatalogoTipoRespuestaController() {

		return "catalogs/template-catalog-response-type";
	}
}
