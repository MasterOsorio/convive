package com.bit.management.catalogs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-movement-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoMovimientoController {

	@GetMapping(value = "agregar")
	public String getCatalogoTipoMovimientoController(Model model) {
		
		CatalogoTipoMovimiento item = new CatalogoTipoMovimiento();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-movement-type";
	}
}
