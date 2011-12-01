package com.abc.sample.service;

import java.util.List;

import com.abc.sample.domain.Person;

public interface PersonService {

	void save(Person person);
	Person findById(long id);
	List<Person> findAll();
}
