package com.abc.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.sample.dao.PersonDao;
import com.abc.sample.domain.Person;
import com.abc.sample.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public void save(Person person) {
		this.personDao.save(person);
	}

	public Person findById(long id) {
		return this.personDao.findById(id);
	}

	public List<Person> findAll() {
		return this.personDao.findAll();
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}	

}
