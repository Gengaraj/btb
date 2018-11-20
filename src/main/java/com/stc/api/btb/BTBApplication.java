package com.stc.api.btb;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BTBApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(BTBApplication.class, args);
    }
	
}

@Component
class TestComponent{
	
}

@Configuration
class TestConfiguraion{
	
}


@Entity
class Employee{

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}