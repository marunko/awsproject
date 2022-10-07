package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="nation")
@Setter
@Getter
@AllArgsConstructor
public class Nation {

	Nation(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="nation", fetch=FetchType.LAZY)
	private List<Person> persons;
	
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o instanceof Nation) {
			Nation o1 = (Nation)o;
			if( o1.getName().equals(this.getName()) && o1.getId() == o1.id) {
				return true;
			}
		}
		
		return false;
	}
	@Override
	public int hashCode() {
		return super.hashCode() + this.name.hashCode();
	}
	
}
