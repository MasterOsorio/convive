package com.bit.management.catalogs.departmenttype;

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
@RequestMapping(value = "catalogs/catalog-department-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoDepartamentoController {
	
	@Autowired
	private CatalogoTipoDepartamentoService catalogoTipoDepartamentoService;
	
	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoDepartamento(Model model) {

		CatalogoTipoDepartamentoView item = new CatalogoTipoDepartamentoView();
		model.addAttribute("item", item);

		return "catalogs/template-catalog-department-type";
	}
	
	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoDepartamento(Model model, @ModelAttribute CatalogoTipoDepartamentoView item, BindingResult errors) {
		
		catalogoTipoDepartamentoService.guardar(item);
		
		return "redirect:/catalogs/catalog-department-type/agregar";
	}
}
