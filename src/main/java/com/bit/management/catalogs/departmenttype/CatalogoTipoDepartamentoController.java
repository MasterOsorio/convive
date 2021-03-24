package com.bit.management.catalogs.departmenttype;

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
@RequestMapping(value = "catalogs/catalog-department-type")
//crea objeto de sesion
@SessionAttributes("currentAdmin")
public class CatalogoTipoDepartamentoController extends BaseController {

	@Autowired
	private CatalogoTipoDepartamentoService catalogoTipoDepartamentoService;

	@GetMapping(value = "agregar")
	public String getPantallaCatalogoTipoDepartamento(Model model) {

		CatalogoTipoDepartamentoView item = new CatalogoTipoDepartamentoView();
		model.addAttribute("item", item);

		putHierarchyOnModel(model, 22);
		
		return "catalogs/template-catalog-department-type";
	}

	@PostMapping(value = "agregar")
	public String guardarCatalogoTipoDepartamento(Model model, @ModelAttribute CatalogoTipoDepartamentoView item,
			BindingResult errors, RedirectAttributes redirectAttributes) {

		catalogoTipoDepartamentoService.guardar(item);

		redirectAttributes.addFlashAttribute("action", "success");
		redirectAttributes.addFlashAttribute("message", "El registro ha sido guardado correctamente");

		putHierarchyOnModel(model, 22);
		
		return "redirect:list";
	}

	@GetMapping(value = "list")
	public String getCatalogoTipoDepartamentoList(Model model, HttpServletRequest request) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String action = (String) inputFlashMap.get("action");
			String message = (String) inputFlashMap.get("message");

			model.addAttribute("action", action);
			model.addAttribute("message", message);
		}

		List<CatalogoTipoDepartamentoView> list = catalogoTipoDepartamentoService.list(null);
		model.addAttribute("list", list);

		putHierarchyOnModel(model, 22);

		return "catalogs/catalog-department-type-list";
	}
}
