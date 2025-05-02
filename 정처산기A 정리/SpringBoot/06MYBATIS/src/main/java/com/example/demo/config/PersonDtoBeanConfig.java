package com.example.demo.config;

import com.example.demo.domain.dto.PersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDtoBeanConfig {
	
	@Bean
	public PersonDto person03() {
		
		return PersonDto.builder()
				.age(55)
				.username("영희")
				.addr("울산")
				.build();
		
//		return new PersonDto("김범수",44,"서울");
	}
	@Bean(name = "personBean")
	public PersonDto person04() {
		return new PersonDto("범수",49,"대전");
	}

}
