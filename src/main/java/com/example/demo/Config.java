package com.example.demo;
 
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;
@Component
public class Config implements ApplicationRunner {
	@Autowired
	private PersonRepository pr;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	List<Person> persons=	Stream.of(new Person("amen allah", "mansouri", 4832787l,25487333l),
				new Person("sofien", "trablesi", 11652767l,50320320l) ).collect(Collectors.toList());
		pr.saveAll(persons);
	}

}
