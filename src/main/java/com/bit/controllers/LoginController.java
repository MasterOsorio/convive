package com.bit.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.model.AnotherDummy;
import com.bit.model.Dummy;

//Indica que la clase LoginController es un controlador
//Permite que las clases de implementación se detecten automáticamente a través del escaneo de classpath
@Controller
//Mapea solicitudes web en clases de manejador específicas y/o métodos de manejador
//Classpath ("")
@RequestMapping("/")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		return "login";
	}

	/*
	 * GET REQUEST START TEMPLATE SAVE FROM
	 */
	// Mapea solicitudes HTTP GET en métodos de controlador específicos
	@GetMapping("/template-catalogo")
	public String getTemplateCatalogo(Model model) {

		log.info("Entrando en...");

		List<AnotherDummy> opts = new ArrayList<>(
				Arrays.asList(new AnotherDummy(1, "Opt1"), new AnotherDummy(2, "Opt2"), new AnotherDummy(3, "Opt3"),
						new AnotherDummy(4, "Opt4"), new AnotherDummy(5, "Opt5")));

		Dummy item = new Dummy();

		model.addAttribute("item", item);
		model.addAttribute("opts", opts);

		return "admin/template-catalogo";
	}

	/*
	 * EDIT FROM
	 */
	@GetMapping("/edt-template-catalogo")
	// @RequestParam indica que un parámetro de método debe estar vinculado a un
	// parámetro de solicitud web
	public String getTemplateCatalogo(Model model, @RequestParam(name = "id", required = false) String id) {

		List<AnotherDummy> opts = new ArrayList<>(
				Arrays.asList(new AnotherDummy(1, "Opt1"), new AnotherDummy(2, "Opt2"), new AnotherDummy(3, "Opt3"),
						new AnotherDummy(4, "Opt4"), new AnotherDummy(5, "Opt5")));

		AnotherDummy another = new AnotherDummy(1, "Opt1");
		Dummy item = new Dummy(1, "Field 1", "Field 2", "Field 3", 5, another);

		model.addAttribute("item", item);
		model.addAttribute("opts", opts);

		return "admin/template-catalogo";
	}

	/*
	 * POST REQUEST SAVE FROM
	 */
	// Mapea solicitudes HTTP POST en métodos de controlador específicos
	@PostMapping("template-catalogo")
	// @ModelAttribute vincula un parámetro de método o un valor de retorno de
	// método a un atributo de modelo
	public String postTemplateCatalogo(@ModelAttribute Dummy item, BindingResult errors, Model model) {

		log.info("Guardando: {}", item.getField1());

		return "admin/template-catalogo";
	}

	/*
	 * END TEMPLATE
	 */
	@GetMapping("/general")
	public String getHome() {

		return "general";
	}
}
