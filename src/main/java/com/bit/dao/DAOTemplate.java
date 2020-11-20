package com.bit.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * En esta clase se definen las operaciones CRUD genericas para las clases DAO
 * 
 * @author Adrian
 *
 * @param <T>  Clase anotada como @Entity (es el tipo de dato)
 * @param <PK> Tipo de dato de PK de la clase @Entity (tipo de dato de la llave primaria de cada entity, debe ser objeto)
 */

//La intrface serializable se utiliza para la escritura/transmision de objetos
public abstract class DAOTemplate<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = -2012581771931044088L;

	/**
	 * SessionFactory lo toma de la clase DBConfig y es la conexion a la base de
	 * datos
	 * 
	 * Autowired realiza la inyeccion de dependencias
	 */

	@Autowired
	private SessionFactory sessionFactory;
	private final Class<T> persistenClass;
	
	//constructor
	@SuppressWarnings("unchecked")
	public DAOTemplate() {

		// Obtiene el tipo de la clase
		// Como es una clase parametrizada <T, PK extends Serializable>
		// devuelve el tipo completo: paquete, clase, parametros
		Type t = getClass().getGenericSuperclass();

		ParameterizedType p = (ParameterizedType) t;

		// Obtiene el tipo de la clase parametrizada
		// En estos casos son las clases DAO que extienden de esta clase abstracta
		this.persistenClass = (Class<T>) p.getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void flush() {
		getSessionFactory().getCurrentSession().flush();
	}

	public void clear() {
		getSessionFactory().getCurrentSession().clear();
	}

	/*
	 * CRUD Methods
	 */
	public T save(T entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public T update(T entity) {
		sessionFactory.getCurrentSession().merge(entity);
		return entity;
	}

	public T saveOrUpdate(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public T finfByPK(PK pk) {
		return (T) sessionFactory.getCurrentSession().get(persistenClass, pk);
	}
}
