package com.bit.management.catalogs.responsetype;

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
@RequestMapping(value = "catalogs/catalog-response-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoRespuestaController {
	
	@Autowired
	private CatalogoTipoRespuestaService catalogoTipoRespuestaService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoRespuesta(Model model) {
		
		CatalogoTipoRespuesta item = new CatalogoTipoRespuesta();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-response-type";
	}
	
	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoRespuesta(Model model, @ModelAttribute CatalogoTipoRespuestaVew item, BindingResult errors) {
		
		catalogoTipoRespuestaService.guardar(item);
		
		return "redirect:/catalogs/catalog-response-type/agregar";
	}
}
