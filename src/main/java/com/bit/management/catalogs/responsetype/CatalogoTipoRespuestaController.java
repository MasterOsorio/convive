package com.bit.management.catalogs.responsetype;

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
	public String guardarCatalogoTipoRespuesta(Model model,
			@ModelAttribute CatalogoTipoRespuestaView item, BindingResult errors,
			RedirectAttributes redirectAttributes) {
		
		catalogoTipoRespuestaService.guardar(item);
		
		redirectAttributes.addFlashAttribute("action", "action");
		redirectAttributes.addFlashAttribute("message", "El registro se ha guardado correctamente");
		
		return "redirect:list";
	}
	
	@GetMapping(value = "list")
	public String getCatalogoTipoRespuestaList(Model model, HttpServletRequest request) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String)inputFlashMap.get("action");
			String message = (String)inputFlashMap.get("message");
			
			model.addAttribute("action", action);
			model.addAttribute("message", message);
		}
		
		List<CatalogoTipoRespuestaView> list = catalogoTipoRespuestaService.list(null);
		model.addAttribute("list", list);
		
		return "catalogs/catalog-phone-type-list";
	}
}
