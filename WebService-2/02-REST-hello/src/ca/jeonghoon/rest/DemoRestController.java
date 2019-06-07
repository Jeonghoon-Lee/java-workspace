package ca.jeonghoon.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myrest")
public class DemoRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
//