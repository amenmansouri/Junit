package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	private long cin;
	private long num;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	 
	public Person(String firstname, String lastname, long cin, long num) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.cin = cin;
		this.num = num;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", cin=" + cin + ", num="
				+ num + "]";
	}

	
}
