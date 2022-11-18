package com.yamani.WelcomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamani.WelcomeService.WelcomeService;

/*
//step1
public class WelcomeController{
	
	public String welcome() {
		return "welcome";
	}
}
*/

/*
 //step2
@RestController
public class WelcomeController{
	
	@GetMapping("/welcome")
	public String welcome(String name) {
		return "welcome "+name;
	}
}
*/

//step3
@RestController
public class WelcomeController{
	private WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "oussama") String name) {
    	return welcomeService.getWelcomeMessage(name);
    }
}
