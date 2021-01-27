package com.bit.management.catalogs.screen;

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
@RequestMapping(value = "catalogs/catalog-screen")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoPantallaController {
	
	@Autowired
	private CatalogoPantallaService catalogoPantallaService;
	
	@GetMapping(value = "agregar")
	public String getPantallaCatalogoPantalla(Model model) {
		
		CatalogoPantallaView item = new CatalogoPantallaView();
		model.addAttribute("item", item);
		
		return "catalogs/template-catalog-screen";
	}
	
	@PostMapping(value = "agregar")
	public String guardarCatalogoPantalla(Model model,
			@ModelAttribute CatalogoPantallaView item, BindingResult errors,
			RedirectAttributes redirectAttributes) {
		
		catalogoPantallaService.guardar(item);
		
		redirectAttributes.addFlashAttribute("action", "success");
		redirectAttributes.addFlashAttribute("message", "El registro ha sido guardado correctamente");
		
		return "redirect:list";
	}
	
	@GetMapping(value = "list")
	public String getCatalogoPantallaList(Model model, HttpServletRequest request) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String)inputFlashMap.get("action");
			String message = (String)inputFlashMap.get("message");
			
			model.addAttribute("action", action);
			model.addAttribute("message", message);
		}
		
		List<CatalogoPantallaView> list = catalogoPantallaService.list(null);
		model.addAttribute("list", list);
		
		return "catalogs/catalog-screen-list";
	}
}
