package com.abc.sample;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.sample.domain.Person;
import com.abc.sample.service.PersonService;

public class PersonServiceTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml"});
		PersonService personService = context.getBean("personService",
				PersonService.class);
		Person person = personService.findById(8);
		System.out.println(person.getFirstName());
		
		List<Person> persons = personService.findAll();
		System.out.println(persons);
		

	}
}
