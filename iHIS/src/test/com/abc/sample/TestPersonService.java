package com.abc.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.abc.sample.domain.Person;
import com.abc.sample.service.PersonService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestPersonService extends AbstractTestNGSpringContextTests {

	@Autowired
	private PersonService personService;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	//@Test
	public void saveUser() {
		Person person = new Person();
		person.setFirstName("开浩");
		person.setLastName("陈");
		person.setAddress("南京");
		personService.save(person);

	}
	@Test	
	public void listAll()
	{
		List<Person> list = personService.findAll();
		Assert.assertEquals(list.size(), 1);
		Assert.assertEquals(list.get(0).getFirstName(), "开浩");
		System.out.println(list.get(0).getFirstName());
	}
}
