package com.bit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//Indica que la clase LoginController es un controlador
//Permite que las clases de implementaci�n se detecten autom�ticamente a trav�s del escaneo de classpath
@Controller
//Mapea solicitudes web en clases de manejador espec�ficas y/o m�todos de manejador
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
	// Mapea solicitudes HTTP GET en m�todos de controlador espec�ficos
	@GetMapping("/template-catalogo")
	public String getTemplateCatalogo(Model model) {
		return "admin/template-catalogo";
	}

	/*
	 * EDIT FROM
	 */
	@GetMapping("/edt-template-catalogo")
	// @RequestParam indica que un par�metro de m�todo debe estar vinculado a un
	// par�metro de solicitud web
	public String getTemplateCatalogo(Model model, @RequestParam(name = "id", required = false) String id) {


		return "admin/template-catalogo";
	}

	/*
	 * POST REQUEST SAVE FROM
	 */
	// Mapea solicitudes HTTP POST en m�todos de controlador espec�ficos
	@PostMapping("template-catalogo")
	// @ModelAttribute vincula un par�metro de m�todo o un valor de retorno de
	// m�todo a un atributo de modelo
	public String postTemplateCatalogo(BindingResult errors, Model model) {


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
