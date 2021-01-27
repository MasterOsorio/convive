package com.bit.management.catalogs.habitanttype;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

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
	public String guardarCatalogoTipoHabitante(Model model,
			@ModelAttribute CatalogoTipoHabitanteView item, BindingResult errors,
			RedirectAttributes redirectAttributes) {

		catalogoTipoHabitanteService.guardar(item);
		
		redirectAttributes.addFlashAttribute("action", "success");
		redirectAttributes.addFlashAttribute("message", "El registro ha sido guardado correctamente");

		return "redirect:list";
	}
	
	@GetMapping(value = "list")
	public String getCatalogoTipoHabitanteList(Model model, HttpServletRequest request) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String)inputFlashMap.get("action");
			String message = (String)inputFlashMap.get("message");
		}
		
		List<CatalogoTipoHabitanteView> list = catalogoTipoHabitanteService.list(null);
		model.addAttribute("list", list);
		
		return "catalogs/catalog-habitant-type-list";
	}
}
