package com.bit.management.catalogs.area;

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
@RequestMapping(value = "catalogs/catalog-area")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoAreaController {
	
	@Autowired
	private CatalogoAreaService catalogoAreaService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoArea(Model model) {

		CatalogoAreaView item = new CatalogoAreaView();
		model.addAttribute("viewdataform", item);

		return "catalogs/template-catalog-area";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoArea(Model model, 
			@ModelAttribute CatalogoAreaView item, BindingResult errors,
			RedirectAttributes redirectAttributes) {

		catalogoAreaService.guardar(item);
		boolean showErrores = false;
		
		if( showErrores ) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Servicio no disponible, intentar en un momento");
			model.addAttribute("viewdataform", item);
			return "catalogs/template-catalog-area";
		}
		else {
			redirectAttributes.addFlashAttribute("action", "success");
			redirectAttributes.addFlashAttribute("message", "El registro ha sido guardado correctamente");
			
			return "redirect:list" ;
		}
	}
	
	@GetMapping(value = "list")
	public String getCatalogoAreaList(Model model, HttpServletRequest request) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String)inputFlashMap.get("action");
			String message = (String)inputFlashMap.get("message");
			
			model.addAttribute("action", action);
			model.addAttribute("message", message);
		}

		List<CatalogoAreaView> list = catalogoAreaService.list( null );
		model.addAttribute("list", list);
		
		
		return "catalogs/catalog-area-list";
	}
}
