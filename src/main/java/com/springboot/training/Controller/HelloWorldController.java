package com.springboot.training.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.training.domain.UserDetails;

@RestController
public class HelloWorldController {
	
//	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	@GetMapping("helloWorld")
	public String printHelloWorld(){
		return "HelloWorld";
	}
	
	@GetMapping("helloBean")
	public UserDetails helloworld() {
		return new UserDetails("Anjana", "Francis", "Kochi");
	}

}
