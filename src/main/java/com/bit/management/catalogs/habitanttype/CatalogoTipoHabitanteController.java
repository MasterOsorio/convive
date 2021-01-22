package com.bit.management.catalogs.habitanttype;

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
@RequestMapping(value = "catalogs/catalog-habitant-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoHabitanteController {

	@Autowired
	private CatalogoTipoHabitanteService catalogoTipoHabitanteService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoHabitante(Model model) {

		CatalogoTipoHabitanteView item = new CatalogoTipoHabitanteView();
		model.addAttribute("item", item);

		return "catalogs/template-catalog-habitant-type";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoHabitante(Model model, @ModelAttribute CatalogoTipoHabitanteView item,
			BindingResult errors) {

		catalogoTipoHabitanteService.guardar(item);

		return "redirect:/catalogs/catalog-habitant-type/agregar";
	}
}
