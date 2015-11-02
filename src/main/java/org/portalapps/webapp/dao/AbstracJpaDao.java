package org.portalapps.webapp.dao;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstracJpaDao<E>  implements IDao<E>{


	@PersistenceContext(unitName = "hrPU")
	protected EntityManager em ;
	

	
	protected Class<E> clazz;
	public enum ACTION {
		SELECT, INSERT, UPDATE,  DELETE
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	private void setClass() throws Exception{
		try {
			ParameterizedType p= (ParameterizedType) getClass().getGenericSuperclass();
			Class<E> clazz = (Class<E>) p.getActualTypeArguments()[0];
			this.clazz = clazz;

		} catch (Exception e) {
			throw e;
		}
	}


	public void insert(E e) {
//		em.getTransaction().begin();
//		String s = hrEntityManagerFactory.getPersistenceUnitName();
//		System.out.println(s);
		String t = em.toString();
		System.out.println(t);
		em.merge(e);		
//		em.getTransaction().commit();
//		em.close();				
	}

	public boolean exist(E e){
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<E> executetQuery(String queryString) {
		Query query = em.createQuery(queryString);
		List<E> resultList = (List<E>) query.getResultList();
		return resultList;
	}

	public int executeUpdate(String updateString) {
		return em.createQuery(updateString).executeUpdate();
	}

	public void update(E e) {
		//		printHello();

	}

	public void delete(E e) {
		//		printHello();

	}

	public E findBy(E e) {
		//		printHello();
		return em.find(clazz,e);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		//		printHello();
		String q = "from " + clazz.getName();
		List<E> resultList = em
				.createQuery(q)
				.getResultList();
		return resultList;	

	}



	@SuppressWarnings("unchecked")
	public static <T> T initializeAndUnproxy(T entity) {
		Hibernate.initialize(entity);
		if (entity instanceof HibernateProxy) 
			entity = (T) ((HibernateProxy) entity)
			.getHibernateLazyInitializer()
			.getImplementation();
		return entity;
	}

}
