package com.sggsiet.farmerportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@GetMapping("/main_dashboard")
	public String mainDashboard()
	{
		return "FrontEnd/dashboard";
	}
	
	
	@PostMapping("/customer_dashboard")
	public String customerDashboard(@RequestParam String username,@RequestParam String password,Model model)
			  {
		 
		  System.out.println("username :"+username);
		  System.out.println("password :"+password);
		  
		  if(username.equals("customer") && password.equals("pass")) {
			  
			  model.addAttribute("success_message", "Successfully logged in");
			  return "FrontEnd/Customer/html/customer_dashboard";
			
		  }else {
		  model.addAttribute("error_message", " log in failed");
		  
		  return "FrontEnd/Customer_login";
		  }
			  }

}
