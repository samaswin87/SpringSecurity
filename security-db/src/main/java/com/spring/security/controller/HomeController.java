package com.spring.security.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.security.model.User;
import com.spring.security.model.UserRole;
import com.spring.security.service.UserServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private UserServiceImpl userService;
	
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
    	session.invalidate();
        return "login";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listEmployees(ModelMap map) {
    	ModelAndView model = new ModelAndView();
    	model.addObject("userList", userService.getAllUsers());
    	model.setViewName("list");
  	  	return model;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("add");
  	  	return model;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("username") String username, @RequestParam("password") String password,
    		@RequestParam(value = "admin", required=false, defaultValue="false") Boolean isAdmin) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String hashedPassword = passwordEncoder.encode(password);
    	User user = new User();
    	List<UserRole> roles = new ArrayList<>();
    	UserRole role = new UserRole();
    	role.setUsername(username);
    	role.setRole("ROLE_USER");
    	roles.add(role);
    	if (isAdmin) {
    		role = new UserRole();
    		role.setUsername(username);
    		role.setRole("ROLE_ADMIN");
	    	roles.add(role);
    	}	
    	user.setUsername(username);
    	user.setEnabled(true);
    	user.setPassword(hashedPassword);
    	user.setRoles(roles);
    	userService.addUser(user);
    	
    	ModelAndView model = new ModelAndView();
    	model.addObject("userList", userService.getAllUsers());
    	model.setViewName("list");
  	  	return model;
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("username") String username) {
    	ModelAndView model = new ModelAndView();
    	User user = userService.getUser(username);
    	model.addObject("user", userService.getUser(username));
    	model.addObject("isAdmin", isAdmin(user));
    	model.setViewName("show");
  	  	return model;
    }
    
    private Boolean isAdmin(User user){
    	long count = user.getRoles().stream().filter(role -> role.getRole().equals("ROLE_ADMIN")).count();
    	return (count > 0);
	}
}
