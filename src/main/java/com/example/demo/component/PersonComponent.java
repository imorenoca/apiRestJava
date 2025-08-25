package com.example.demo.component;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.pojo.Person;
// lógica de la creación de persona según parámetros obtenidos
@Component
public class PersonComponent {
	public Person getPerson (String fName, String lName,
			Optional<String> age) {
		
		Integer personAge = 0;
		if (age.isPresent()) {
			try {
				personAge = Integer.parseInt(age.get());
			} catch (Exception e) {
				return null;
			}
			Person person=new Person(fName, lName, personAge);
			return person;
		}
		Person person=new Person(fName, lName);
		return person;
	}
	

}
