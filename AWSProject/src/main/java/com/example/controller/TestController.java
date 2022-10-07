package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;

import lombok.Data;

@RestController
public class TestController {

	@PostMapping("/test")
	public ResponseEntity< A > getPersonsByNation(@RequestBody A a) {
		System.out.println(a);
		return a != null ? new ResponseEntity<A>(a, HttpStatus.OK) 
				: new ResponseEntity<A>(HttpStatus.NO_CONTENT);
	}
	
	
}
@Data
class A{
	B b;
	String name;
}
class B{
	int id;
	String name;
}