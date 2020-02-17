package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock; 
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Controller.PersonController;
import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;

@SpringBootTest
public class PersonTest {

	@Mock
	private PersonRepository pr;
	@InjectMocks
	private PersonController pc;
	
	private Person person = new Person();
	@BeforeEach
	void setMockOutput() {
		 when(pr.findAll()).thenReturn(Stream.of(new Person("amen allah", "mansouri", 4832787l,25487333l),
					new Person("sofien", "trablesi", 11652767l,50320320l) ).collect(Collectors.toList()));
		 when(pr.findById(1l)).thenReturn(  Optional.of(new Person("amen allah", "mansouri", 4832787l,25487333l)));
		 when(pr.findById(2l)).thenReturn(  Optional.ofNullable(null));
		 when(pr.save(person)).thenReturn( person);
		    }
	 @DisplayName("Unit Test For get All Persons")
	    @Test
	    void getAll() {
	        assertEquals(2, pc.getAll().size());
	    }

	 @DisplayName("Unit Test For get One Person")
	    @Test
	    void getOne() {
		    assertTrue(pc.getOne(1l).isPresent());
		    assertTrue(!pc.getOne(2l).isPresent());
	    }

	 @DisplayName("Unit Test For save  Person")
	    @Test
	    void postOne() {  
		 assertTrue(pc.postOne(person) instanceof Person);
		 assertEquals(person,pc.postOne(person));
	    }

	 @DisplayName("Unit Test For put  Person")
	    @Test
	    void putOne() {  
		 assertTrue(pc.putOne(1l, person) instanceof Person); 
		 assertEquals(null,pc.putOne(2l, person));    
	    }
	 @DisplayName("Unit Test For put  Person")
	    @Test
	    void deleteOne() {  
		 pc.deleteOne(1l);
		 verify(pr, times(1)).deleteById(1l);
	    }
}

