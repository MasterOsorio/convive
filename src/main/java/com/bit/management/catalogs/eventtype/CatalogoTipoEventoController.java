package com.bit.management.catalogs.eventtype;

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
@RequestMapping(value = "catalogs/catalog-event-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoEventoController {
	
	@Autowired
	private CatalogoTipoEventoService catalogoTipoEventoService;
	
	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoEvento(Model model) {
		
		CatalogoTipoEventoView item = new CatalogoTipoEventoView();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-event-type";
	}
	
	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoEvento(Model model, @ModelAttribute CatalogoTipoEventoView item, BindingResult errors) {
		
		catalogoTipoEventoService.guardar(item);
		
		return "redirect:/catalogs/catalog-event-type/agregar";
	}
}

