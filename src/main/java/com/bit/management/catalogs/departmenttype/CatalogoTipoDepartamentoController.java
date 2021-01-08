package com.bit.management.catalogs.departmenttype;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "catalogs/catalog-department-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoDepartamentoController {

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoArea(Model model) {

		CatalogoTipoDepartamento item = new CatalogoTipoDepartamento();
		model.addAttribute("item", item);

		return "catalogs/template-catalog-department-type";
	}
}
