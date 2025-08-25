package com.example.demo.component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.Person;
// lógica de la creación de persona según parámetros obtenidos
@Component
public class PersonComponent {
	@Autowired
	PersonSvc persvc;
	
	public Person getPerson (String fName, String lName,
			Optional<String> age) {
		Integer personAge = persvc.getAge(age);
		return persvc.getSvc(fName, lName, personAge);
	}
	

}
