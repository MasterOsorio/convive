package com.bit.management.catalogs.movementtype;

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
@RequestMapping(value = "catalogs/catalog-movement-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoMovimientoController {

	@Autowired
	private CatalogoTipoMovimientoService catalogoTipoMovimientoService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoMovimiento(Model model) {

		CatalogoTipoMovimientoView item = new CatalogoTipoMovimientoView();
		model.addAttribute("item", item);

		return "catalogs/template-catalog-movement-type";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoMovimiento(Model model,
			@ModelAttribute CatalogoTipoMovimientoView item, BindingResult errors,
			RedirectAttributes redirectAttributes) {
		
		catalogoTipoMovimientoService.guardar(item);
		
		redirectAttributes.addFlashAttribute("action", "success");
		redirectAttributes.addFlashAttribute("message", "El registro ha sido guardado correctamente");
		
		return "redirect:list";
	}
	
	@GetMapping(value = "list")
	public String getCatalogoTipoMovimientoList(Model model, HttpServletRequest request) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String)inputFlashMap.get("action");
			String message = (String)inputFlashMap.get("message");
			
			model.addAttribute("action", action);
			model.addAttribute("message", message);
		}
		
		List<CatalogoTipoMovimientoView> list = catalogoTipoMovimientoService.list(null);
		model.addAttribute("list", list);
		
		return "catalogs/catalog-movement-type-list";
	}
}
