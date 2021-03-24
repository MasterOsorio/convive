package com.bit.management.catalogs.phonetype;

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
@RequestMapping(value = "catalogs/catalog-phone-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoTelefonoController extends BaseController {

	@Autowired
	private CatalogoTipoTelefonoService catalogoTipoTelefonoService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoTelefono(Model model) {

		CatalogoTipoTelefonoView item = new CatalogoTipoTelefonoView();
		model.addAttribute("item", item);
		
		putHierarchyOnModel(model, 9);

		return "catalogs/template-catalog-phone-type";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogTipoTelefono(Model model, @ModelAttribute CatalogoTipoTelefonoView item,
			BindingResult errors, RedirectAttributes redirectAttibutes) {

		catalogoTipoTelefonoService.guardar(item);

		redirectAttibutes.addFlashAttribute("action", "success");
		redirectAttibutes.addFlashAttribute("message", "El registro ha sido guardado correctamente");

		putHierarchyOnModel(model, 9);
		
		return "redirect:list";
	}

	@GetMapping(value = "list")
	public String getCatalogoTipoTelefonoList(Model model, HttpServletRequest request) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String) inputFlashMap.get("action");
			String message = (String) inputFlashMap.get("message");

			model.addAttribute("action", action);
			model.addAttribute("message", message);

		}

		List<CatalogoTipoTelefonoView> list = catalogoTipoTelefonoService.list(null);
		model.addAttribute("list", list);

		putHierarchyOnModel(model, 9);

		return "catalogs/catalog-phone-type-list";
	}
}
