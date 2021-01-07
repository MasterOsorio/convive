package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-phone-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoTelefonoController {

	@GetMapping(value = "agregar")
	public String getCatalogoTipoTelefonoController(Model model) {
		
		CatalogoTipoTelefono item = new CatalogoTipoTelefono();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-phone-type";
	}
}
