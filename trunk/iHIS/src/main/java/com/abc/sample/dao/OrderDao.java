package com.abc.sample.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abc.sample.domain.Order;

@Repository("orderDao")
public class OrderDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void saveOrder(Order order)
	{
		this.entityManager.persist(order);		
	}

}
