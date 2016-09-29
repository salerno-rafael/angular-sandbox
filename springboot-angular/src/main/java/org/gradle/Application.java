package org.gradle;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	//https://www.formget.com/angularjs-crud/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> list() {
		return new Database().list();
	}
	
	 @RequestMapping(value = "/insert",method=RequestMethod.POST)
	  public void insert(@RequestBody Employee employee) {
	    System.out.println(employee);
	  }
	 


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
