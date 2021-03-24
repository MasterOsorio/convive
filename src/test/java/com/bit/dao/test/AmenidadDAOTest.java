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
import com.bit.management.amenities.Amenidad;
import com.bit.management.amenities.AmenidadDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class AmenidadDAOTest {
	
	@Autowired
	private AmenidadDAO amenidadDAO;
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void saveAmenidad() {
		Amenidad a = new Amenidad();
		a.setId(1);
		a.setNombre("Gimnasio");
		
		amenidadDAO.save(a);
	}
}
