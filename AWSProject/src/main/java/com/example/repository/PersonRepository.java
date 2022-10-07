package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query("SELECT p FROM Person p")
	List<Person> getAll();
	
	@Query("SELECT p FROM Person p WHERE p.name=:name")
	Person getByName(@Param(value = "name") String name);
	
	@Query("SELECT p FROM Person p JOIN FETCH Nation n ON n = p.nation WHERE n.name = :name")
	List<Person> getByNation(@Param("name") String name);
	
	
}
