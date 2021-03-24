package com.bit.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bit.management.catalogs.screen.CatalogoPantallaService;
import com.bit.utils.ConviveUtils;

//Forma antes de Spring 4.2
//@Component
//public class ConfigBeanListener implements ApplicationListener<ContextRefreshedEvent> {
//	
//	private static final Logger log = LoggerFactory.getLogger(ApplicationListener.class);
//	
//	@Override
//	@Transactional
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		
//		log.info("Prueba application listener");
//	}
//}

//Spring 4.2 en adelante
//Este metodo se manda a llamar cuando se carga o refresca la aplicacion
@Component
public class ConfigBeanListener {

	private static final Logger log = LoggerFactory.getLogger(ApplicationListener.class);
//inyecta la dependenacia del service catalogo pNT
	@Autowired
	private CatalogoPantallaService catalogoPantallaService;

	@EventListener
	@Transactional
//	se manda llamar el metodo anotado @EventListener cada vez que carga o refresca la aplicacion
//	obtiene un list de tipo MenuWrapperview que se setea en la variable menus de tipo listMenuWrapperView
//	y se puede usar
	public void handleContextStart(ContextRefreshedEvent event) {

		log.info("**Cargando menus**");

		ConviveUtils.menus = catalogoPantallaService.listMenusWithSubmenus();
	}
}
