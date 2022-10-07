package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Person;
import com.example.service.PersonService;

@SpringBootTest
class AwsProjectApplicationTests {

	@Autowired
	PersonService s;
	@Test
	void contextLoads() {
		var p = new Person(2, "Tom", 22, null);
		 s.create(p, "Mali");
	}
	@Test
	void getData() {
		//s.getPersons();
	}

}
