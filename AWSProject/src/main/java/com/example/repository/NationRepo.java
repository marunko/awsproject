package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Nation;
import com.example.entity.Person;

@Repository
public interface NationRepo extends JpaRepository<Nation, Long>{
	
	@Query("Select n from Nation n where n.name = :name")
	Nation getNationByName(@Param("name") String name);
}
