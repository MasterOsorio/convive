package com.bit.management.catalogs.phonetype;

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
@RequestMapping(value = "catalogs/catalog-phone-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoTelefonoController {
	
	@Autowired
	private CatalogoTipoTelefonoService catalogoTipoTelefonoService;
	
	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoTelefono(Model model) {
		
		CatalogoTipoTelefonoView item = new CatalogoTipoTelefonoView();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-phone-type";
	}
	
	@PostMapping(value = "agregar")
	public String guardarCatalogTipoTelefono(Model model, @ModelAttribute CatalogoTipoTelefonoView item, BindingResult errors) {
		
		catalogoTipoTelefonoService.guardar(item);
		
		return "redirect:/catalogs/catalog-phone-type/agregar";
	}
}
