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
	private Database db= new Database();
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> list() {
		return db.list();
	}
	
	 @RequestMapping(value = "/insert",method=RequestMethod.POST)
	  public void insert(@RequestBody Employee employee) {
	    System.out.println("INSERT");
	    db.insert(employee);
	  }
	 
	 
	 @RequestMapping(value = "/delete",method=RequestMethod.POST)
	  public void delete(@RequestBody Employee employee) {
	    System.out.println("DELETE");
	    db.delete(employee);
	  }
	 
	 @RequestMapping(value = "/update",method=RequestMethod.POST)
	  public void update(@RequestBody Employee employee) {
	    System.out.println("UPDATE");
	    db.update(employee);
	  }


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
