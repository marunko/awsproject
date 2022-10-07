package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Person;
import com.example.repository.NationRepo;
import com.example.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository repo;
	
	@Autowired
	private NationRepo nepo;
	
	public List<Person> getPersons(){
		return repo.getAll();
	}
	
	public  Person  getPersonByName(String name){
		return repo.getByName(name);
	}
	
	public  List<Person> getPersonByNation(String name){
		return repo.getByNation(name);
	}
	
	public  Person create(Person person, String nationName){
		person.setNation(nepo.getNationByName(nationName));
		repo.save(person);
		return repo.getByName(person.getName());
	}
	
}
