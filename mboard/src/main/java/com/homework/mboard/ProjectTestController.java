package com.homework.mboard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectTestController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllPosts() {
		return "Hello World! Application is up and running.";
	}

}
