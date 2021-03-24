package com.bit.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bit.config.WebConfig;
import com.bit.management.catalogs.area.CatalogoArea;
import com.bit.management.catalogs.area.CatalogoAreaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class CatalogoAreaDAOTest {

	@Autowired
	private CatalogoAreaDAO catalogoAreaDAO;

	@Test
	@Transactional
	@Rollback(value = false)
	public void saveCatalogoArea() {
		CatalogoArea area = new CatalogoArea();
		area.setId(1);
		area.setArea("Contabilidad");

		catalogoAreaDAO.save(area);
	}
}
