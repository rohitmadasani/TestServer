package com.karsun.kic.bootbdd.hw;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping("/hello")
	public String sayHelloWorld() {
		return "Hello World";
	}
}
