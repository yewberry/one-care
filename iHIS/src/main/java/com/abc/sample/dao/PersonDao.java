package com.abc.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.abc.sample.domain.Person;

@Repository("personDao")
public class PersonDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public List<Person> findAll() {
		Query query = this.getEntityManager().createQuery(
				" select c from Person c");
		List<Person> resultList = query.getResultList();
		return resultList;
	}

	public void save(Person person) {
		this.getEntityManager().persist(person);

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Person findById(long id) {
		return this.getEntityManager().find(Person.class, id);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
