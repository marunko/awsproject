package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="person")
@Setter
@Getter
@AllArgsConstructor
public class Person {

	Person(){
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name="nation_id", nullable=true)
	private Nation nation;
	
	@Override
	public String toString() {
		return "" + name + " " + age;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o instanceof Person) {
			Person o1 = (Person)o;
			if( o1.getName().equals(this.getName()) && o1.getAge() == this.age && o1.getId() == o1.id) {
				return true;
			}
		}
		
		return false;
	}
	@Override
	public int hashCode() {
		return super.hashCode() + this.name.hashCode() + this.age;
	}

}
