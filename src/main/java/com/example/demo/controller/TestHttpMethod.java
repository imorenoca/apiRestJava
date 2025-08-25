package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.PersonComponent;
import com.example.demo.pojo.Person;

@RestController
public class TestHttpMethod {
	// conectar con person, la cablea
	@Autowired
	PersonComponent personComp;
	@GetMapping("/person/fn/{firstName}/ln/{lastName}")
	public ResponseEntity<Person> getCustomMessage(
			@PathVariable(value = "firstName") String fName,
			@PathVariable(value = "lastName") String lName,
			@RequestParam Optional<String> age
			) {
		
		Person person = personComp.getPerson(fName, lName, age);
		if (person != null) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(person);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(null);
		}

	}
}
