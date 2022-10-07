package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Person;
import com.example.service.PersonService;

@Controller
public class MainController {

	@Autowired
	private PersonService pservice;
	
	@GetMapping("/")
	public String index() {
		 
		return "index";
	}
	
	@GetMapping("/persons")
	public String getPersons(Model model) {
		// 
		List<Person> list = pservice.getPersons();
		model.addAttribute("persons", list);
		return "persons";
	}
	
	@ResponseBody
	@PostMapping("/persons/{nation}")
	public ResponseEntity<List<Person>> getPersonsByNation(@PathVariable String nation) {
		List<Person> list = pservice.getPersonByNation(nation);
		
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	
 
	@ResponseBody
	@PostMapping("/persons")
	public ResponseEntity< Person > getPersonsByNation(@RequestBody Person person, @RequestParam("nation") String Nname) {
		Person p = pservice.create(person, Nname);
		return p != null ? new ResponseEntity<Person>(p, HttpStatus.OK) 
				: new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
	}
	
}
