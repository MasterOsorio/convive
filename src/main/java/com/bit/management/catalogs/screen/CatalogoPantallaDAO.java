package com.bit.management.catalogs.screen;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class CatalogoPantallaDAO extends DAOTemplate<CatalogoPantalla, Integer> {

	private static final long serialVersionUID = -5701059766927975004L;

	public List<CatalogoPantalla> list() {

		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoPantalla.class);
		
		List<CatalogoPantalla> list = c.list();
		
		return list;
	}

	public List<CatalogoPantalla> onlyParents() {

		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoPantalla.class);
		c.add(Restrictions.like("categoria", "P"));

		List<CatalogoPantalla> list = c.list();

		return list;
	}

	public List<CatalogoPantalla> findChildrendByParentId(Integer id) {

		Criteria c = getSessionFactory().getCurrentSession().createCriteria(CatalogoPantalla.class);
		c.add(Restrictions.like("perteneceA", id));

		List<CatalogoPantalla> list = c.list();

		return list;
	}
	/*
	 * Root<Customer> c = qdef.from(Customer.class); qdef.select(c)
	 * .where(cb.equal(c.get("firstName"), "cat"));
	 * 
	 * List cats = sess.createCriteria(Cat.class) .add( Restrictions.like("name",
	 * "Fritz%") ) .add( Restrictions.between("weight", minWeight, maxWeight) )
	 * .list();
	 */

	// .add( Restrictions.or(
	// Restrictions.eq( "age", new Integer(0) ),
	// Restrictions.isNull("age")) ).list();

	// findChildrendByParentId
	// va recibir un parametro de tipo Integer que va a ser el ID del Padre en
	// cuestion
}
