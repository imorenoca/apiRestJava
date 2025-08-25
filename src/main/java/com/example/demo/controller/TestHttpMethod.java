package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Person;

// indica que la clase es un controlador Rest
@RestController
public class TestHttpMethod {

	// el método va a manejar peticios http del tipo get
	/*
	 * @GetMapping("/hello") public String getCustomMessage() { return
	 * "This is my firts GET"; }
	 */
	// http://localhost:8081/person/fn/John/ln/Doe?age=55
	// se incluye una clase ResponseEntity para añadir los mensajes del Servidor
	@GetMapping("/person/fn/{firstName}/ln/{lastName}")
	public ResponseEntity<Person> getCustomMessage(
			@PathVariable(value = "firstName") String fName,
			@PathVariable(value = "lastName") String lName,
			@RequestParam Optional<String> age) {
		Integer personAge = 0;
		if (age.isPresent()) {
			try {
				personAge = Integer.parseInt(age.get());
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(null);
			}
			Person person=new Person(fName, lName, personAge);
			return ResponseEntity.status(HttpStatus.OK)
					.body(person);
		}
		Person person=new Person(fName, lName);

		return ResponseEntity.status(HttpStatus.OK)
				.body(person);

	}
}
