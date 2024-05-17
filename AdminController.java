package com.sggsiet.farmerportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sggsiet.farmerportal.entity.Admin;
import com.sggsiet.farmerportal.entity.Farmer;
import com.sggsiet.farmerportal.entity.PasswordChange;
import com.sggsiet.farmerportal.service.MainService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MainService adminService;
	
	@GetMapping("/main_dashboard")
	public String mainDashboard()
	{
		return "dashboard";
	}
	
	@GetMapping("/reports")
	public String reports()
	{
		return "FrontEnd/Admin/html/reports";
	}
	
	@GetMapping("/change_password_admin")
	public String changePasswordAdmin()
	{
		return "FrontEnd/Admin/html/change_password";
	}
	
	@GetMapping("/change_password_farmer")
	public String changePasswordFarmer()
	{
		
		return "FrontEnd/Farmer/html/change_password";
	}
	@PostMapping("/change_password_farmer")
	public String changePasswordFarmer(@ModelAttribute PasswordChange passwordChange,Model model)
	{
		System.out.println("old password"+passwordChange.getOld_password());
		System.out.println("new password"+passwordChange.getNew_password());

		model.addAttribute("success_message", "password changed successfully");
		return "FrontEnd/Farmer/html/change_password";
	}
	@GetMapping("/change_password_expert")
	public String changePasswordExpert()
	{
		return "FrontEnd/Admin/html/change_password2";
	}
	@GetMapping("/change_password_customer")
	public String changePasswordCustomer()
	{
		
		return "FrontEnd/Customer/html/change_password";
	}
	
	
	
	@GetMapping("/admin_dashboard")
	public String AdminDashboard()
	{
		return "FrontEnd/Admin/html/admin_dashboard";
	}
	
	  
	 //............................Admin Login...................
	 @GetMapping("/admin_login") 
	  public String adminLogin() 
	  { 
		  return "FrontEnd/admin_login"; 
	  }
	 @PostMapping("/admin_login")
	  public String AdminLogin(@RequestParam String username,@RequestParam String password,Model model)
	  {
		 
		 Admin admin=adminService.getAdminData();
		  System.out.println("username :"+admin.getUsername());
		  System.out.println("password :"+admin.getPassword());
		  if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
			  
			  model.addAttribute("success_message", "Successfully logged in");
			  return "FrontEnd/Admin/html/admin_dashboard";
			
		  }else {
		  model.addAttribute("error_message", " log in failed");
		  
		  return "FrontEnd/admin_login";
		  } 
	  }
	 
	 
	//..........................Customer Login...................................
		 @GetMapping("/customer_login") 
		  public String customerLogin() 
		  { 
			  return "FrontEnd/customer_login"; 
		  }
		 
		 @PostMapping("/customer_login")
		  public String customerLoginC(@RequestParam String username,@RequestParam String password,Model model)
		  {
			 System.out.println("username :"+username);
			  System.out.println("password :"+password);
			  
			// List<Farmer> fList= adminService.getAllFarmers();
			
				  if(username.equals("customer") && password.equals("pass"))
					  
			  {
				  
				  model.addAttribute("success_message", "Successfully logged in");
				  return "FrontEnd/Customer/html/customer_dashboard";
				
			  }else {
			  model.addAttribute("error_message", "log in failed");
			  
			  return "FrontEnd/customer_login";
			  }
		  }
	 
	 
	//.....................Farmer Login..........................
	
	 @GetMapping("/farmer_login") 
	  public String farmerLogin() 
	  { 
		  return "FrontEnd/Farmer/html/farmer_login"; 
	  }
	 @PostMapping("/farmer_login")
	  public String farmerLogin(@RequestParam String username,@RequestParam String password,Model model)
	  {
		 System.out.println("username :"+username);
		  System.out.println("password :"+password);
		  
		 List<Farmer> fList= adminService.getAllFarmers();
		 
		
			  if(username.equals("farmer") && password.equals("pass"))
				  
		  {
			  
			  model.addAttribute("success_message", "Successfully logged in");
			  return "FrontEnd/Farmer/html/farmer_dashboard";
			
		  }else {
		  model.addAttribute("error_message", "log in failed");
		  
		  return "FrontEnd/Farmer/html/farmer_login";
		  }
	  } 

	//......................Expert Login.....................................
	 @GetMapping("/expert_login") 
	  public String expertLogin() 
	  { 
		  return "FrontEnd/expert_login"; 
	  }
	 @PostMapping("/expert_login")
	  public String ExpertLogin(@RequestParam String username,@RequestParam String password,Model model)
	  {
		  System.out.println("username :"+username);
		  System.out.println("password :"+password);
		  
		  if(username.equals("expert") && password.equals("pass")) {
			  
			  model.addAttribute("success_message", "Successfully logged in");
			  return "FrontEnd/Admin/html/expert_dashboard";
			
		  }else {
		  model.addAttribute("error_message", " log in failed");
		  
		  return "FrontEnd/Admin/html/expert_login";
		  }
		 
	  }
	 
	 
	 
	  
	 
	  
	 
}
