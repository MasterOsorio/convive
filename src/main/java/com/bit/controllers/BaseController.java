package com.bit.controllers;

import java.util.Map;

import org.springframework.ui.Model;

import com.bit.utils.ConviveUtils;

public class BaseController {
	
//	variable model es referencia a la variable model de la clase controller
	public void putHierarchyOnModel(Model model, int id) {
		
		model.addAttribute("menus", ConviveUtils.menus);
		Map<String, Integer> hierarchy = ConviveUtils.findHierarchy(id);
		model.addAttribute("idParent", hierarchy.get(ConviveUtils.ID_PARENT));
		model.addAttribute("idChild", hierarchy.get(ConviveUtils.ID_CHILD));
	}
}
