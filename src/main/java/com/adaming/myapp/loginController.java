package com.adaming.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
	
	@RequestMapping("/login")
	public String getLogin() {
		
		return "login";
	}
	@RequestMapping("/erreur")
    public String getErreur() {
    	
    	return "erreur";
    }
}
