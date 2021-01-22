package com.bit.management.catalogs.movementtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-movement-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoMovimientoController {

	@Autowired
	private CatalogoTipoMovimientoService catalogoTipoMovimientoService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoMovimiento(Model model) {

		CatalogoTipoMovimientoView item = new CatalogoTipoMovimientoView();
		model.addAttribute("item", item);

		return "catalogs/template-catalog-movement-type";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoMovimiento(Model model, @ModelAttribute CatalogoTipoMovimientoView item, BindingResult errors) {
		
		catalogoTipoMovimientoService.guardar(item);
		
		return "redirect:/catalogs/catalog-movement-type/agregar";
	}
}
