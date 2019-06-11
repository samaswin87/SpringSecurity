package com.spring.security.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model, HttpSession session) {
        return "login";
    }
      
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "denied";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpSession session) {
    	System.out.println("Called Logout");
    	session.invalidate();
        return "logout";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {
        return "list";
    }
}
