package com.abc.ihis.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * DAO基础类
 * 
 * @author chenkaihao
 * 
 * @param <T>
 */

public abstract class BaseDao<T> implements IBaseDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<?> persistentClass;

	public BaseDao() {

	}

	private Class<?> getPersistentClass() {
		if (this.persistentClass == null) {
			this.persistentClass = (Class<?>) ((ParameterizedType) this
					.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];

		}
		return this.persistentClass;
	}

	public T findById(Object id) {
		T entity = null;
		if (id == null) {
			entity = (T) this.entityManager.find(this.persistentClass, id);
		}
		return entity;
	}

	public List<T> findAll() {
		Query q = entityManager.createQuery("select a from "
				+ this.getPersistentClass().getName() + " a");
		return q.getResultList();
	}

	public long queryCount(String query) {
		Query q = entityManager.createNamedQuery(query);
		List list = q.getResultList();
		if (list.size() == 1 && list.get(0) instanceof Long) {
			Long size = (Long) list.get(0);
			return size.longValue();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public List<T> query(String query) {
		Query q = entityManager.createNamedQuery(query);
		return q.getResultList();
	}

	public List<T> query(String query, int start, int maxResult) {
		Query q = entityManager.createNamedQuery(query);
		q.setFirstResult(start);
		q.setMaxResults(maxResult);
		return q.getResultList();
	}

	public List<T> query(String query, String[] params, Object[] values) {
		Query q = entityManager.createNamedQuery(query);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(params[i], params[i]);
		}
		return q.getResultList();
	}

	public List<T> query(String query, String[] params, Object[] values,
			int start, int maxResult) {
		Query q = entityManager.createNamedQuery(query);
		q.setFirstResult(start);
		q.setMaxResults(maxResult);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(params[i], params[i]);
		}
		return q.getResultList();
	}

	public void save(T t) {
		this.entityManager.persist(t);
	}

	public void remove(T t) {
		this.entityManager.remove(t);
	}

	public void update(T t) {
		this.entityManager.merge(t);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
