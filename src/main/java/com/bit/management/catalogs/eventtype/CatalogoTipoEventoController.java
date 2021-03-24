package com.bit.management.catalogs.eventtype;

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

import com.bit.controllers.BaseController;

@Controller
@RequestMapping(value = "catalogs/catalog-event-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoEventoController extends BaseController {

	@Autowired
	private CatalogoTipoEventoService catalogoTipoEventoService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoEvento(Model model) {

		CatalogoTipoEventoView item = new CatalogoTipoEventoView();
		model.addAttribute("item", item);

		putHierarchyOnModel(model, 14);
		
		return "catalogs/template-catalog-event-type";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoEvento(Model model, @ModelAttribute CatalogoTipoEventoView item,
			BindingResult errors, RedirectAttributes redirectAttributes) {

		catalogoTipoEventoService.guardar(item);

		redirectAttributes.addFlashAttribute("action", "success");
		redirectAttributes.addFlashAttribute("message", "El registro ha sido guardado correctamente");

		putHierarchyOnModel(model, 14);
		
		return "redirect:list";
	}

	@GetMapping(value = "list")
	public String getCatalogoTipoEventoList(Model model, HttpServletRequest request) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String) inputFlashMap.get("action");
			String message = (String) inputFlashMap.get("message");

			model.addAttribute("action", action);
			model.addAttribute("message", message);
		}

		List<CatalogoTipoEventoView> list = catalogoTipoEventoService.list(null);
		model.addAttribute("list", list);

		putHierarchyOnModel(model, 14);

		return "catalogs/catalog-event-type-list";
	}
}
