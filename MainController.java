package com.sggsiet.farmerportal.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sggsiet.farmerportal.entity.AskQuestions;
import com.sggsiet.farmerportal.entity.ContactUs;
import com.sggsiet.farmerportal.entity.Customer;
import com.sggsiet.farmerportal.entity.Experts;
import com.sggsiet.farmerportal.entity.Farmer;
import com.sggsiet.farmerportal.entity.Notifications;
import com.sggsiet.farmerportal.entity.Product;
import com.sggsiet.farmerportal.service.MainService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/farmerportal")
public class MainController {
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/main_dashboard")
	public String mainDashboard()
	{
		return "dashboard";
	}
	
	
	//.........................customer registration...................................
	@GetMapping("/customer_registration")
	public String customerRegistration()
	{
		return "FrontEnd/Customer/html/customer_registration";
	}
	@PostMapping("/customer_registration")
	public String customerRegister( @ModelAttribute(value="customer") Customer customer,Model model)
	{
		
		
			mainService.saveCustomer(customer);
			model.addAttribute("success_message", "Form Submitted Succesfully");
			return "FrontEnd/customer_login";
			
	}
	
	
	
	//............................product registration..............................
	
	@GetMapping("/product_registration")
	public String productRegistration()
	{
		//model.addAttribute("product", new Product());
		
		return "FrontEnd/Product/html/addnew_product";
	}
	
	@PostMapping("/product_registration")
	public String register(@ModelAttribute Product  product ,Model model) throws IOException
	{
		
		
		
		//mainService.saveProduct(product);
		
		
		return "FrontEnd/Product/html/addnew_product";
	}
	
	 @GetMapping("/product_type")
		public String productType()
		{
		 
			return "FrontEnd/Admin/html/product_type";
		}
	
	
	
	//.........................farmer registration.............................
	
	
	@GetMapping("/farmer_dashboard")
	public String farmerDashboard(Model model)
	{
		List<Customer> listOfCustomer=mainService.getCustomer();
		
		for(Customer customer:listOfCustomer)
		{
			System.out.println(customer.getName());
		}
		model.addAttribute("listOfCustomer", listOfCustomer);
		
		return "FrontEnd/Farmer/html/farmer_dashboard";
	}
	
	@GetMapping("/farmer_registration")
	public String registration(Model model)
	{
		model.addAttribute("farmer", new Farmer());
		
		return "FrontEnd/Farmer/html/farmer_registration";
	}
	@GetMapping("/Afarmer_registration")
	public String Fregistration(Model model)
	{
		model.addAttribute("farmer", new Farmer());
		
		return "FrontEnd/Admin/html/farmer_registration";
	}
	@PostMapping("/farmer_registration")
	public String register(@Valid @ModelAttribute(value="farmer") Farmer farmer,BindingResult bindingResult ,Model model)
	{
		
		if(bindingResult.hasErrors())
		{	
			model.addAttribute("error_message", "validation error ");	
			return "FrontEnd/Farmer/html/farmer_registration";
		}else {
			mainService.saveFarmer(farmer);
			model.addAttribute("success_message", "User Added Succesfully");
			return "FrontEnd/Farmer/html/farmer_login";
		}		
	}
	
	@GetMapping("/my_questions/{firstname}")
	public String myQuestions(@RequestParam String firstname ,Model model)
	{
		System.out.println(firstname);
		List<AskQuestions> my_questions=mainService.getMyQuestions(firstname);
		model.addAttribute("my_questions",my_questions);
		
		return "FrontEnd/Farmer/html/my_questions";
	}
	
	
	
	//................................Ask Question ...................
	@GetMapping("/ask_question")
	public String askQuestion()
	{
		
		return "FrontEnd/Farmer/html/ask_question";
	}
	@PostMapping("/ask_question")
	public String askQuestion(@ModelAttribute AskQuestions askQuestions ,Model model) throws IOException
	{
	
		model.addAttribute("success_message", "Question Submitted");
		System.out.println(askQuestions.getFarmerName());
		System.out.println(askQuestions.getQuestion());
		
		mainService.saveQuestion(askQuestions);
		return "FrontEnd/Farmer/html/ask_question";
	}
	@GetMapping("/add_answer/{farmerName}")
	public String addAnswer(@PathVariable String farmerName ,Model model)
	{
		System.out.println(farmerName);
		AskQuestions object=mainService.getQuestion(farmerName);
		System.out.println(object.getFarmerName());
		System.out.println(object.getQuestion());
		model.addAttribute("object", object);
		return "FrontEnd/Admin/html/add_answer.html";
	}
	
	

	//................Expert Registration..................
	
	@GetMapping("/expert_dashboard")
	public String expertDashboard(Model model)
	{
		
		
		
		return "FrontEnd/Admin/html/expert_dashboard";
	}
	//............Expert Registration...........................
	@GetMapping("/add_expert")
	public String addExpert()
	{
		return "FrontEnd/Admin/html/add_expert";
	}
	@PostMapping("/add_expert")
	public String expertRegister( @ModelAttribute(value="expert") Experts expert,Model model)
	{
		mainService.saveExpert(expert);
			model.addAttribute("success_message", "User Added Succesfully");
			return "FrontEnd/Admin/html/add_expert";		
	}
	
	
	
	//................................................................
	
	//..........................Publish Notification..................
	 @GetMapping("/publish_notification")
		public String publishNotification()
		{
			return "FrontEnd/Admin/html/publish_notification";
		}
	 @PostMapping("/publish_notification")
		public String saveNotifications(@ModelAttribute Notifications notifications)
		{
		 System.out.println(notifications.getTitle());
			return "FrontEnd/Admin/html/publish_notification";
		}
	
	
	
	
	 @GetMapping("/about_us")
		public String aboutUs()
		{
			return "FrontEnd/about_us";
		}
	 
	 
	 
	 
	 
	 
	 
	 
	@GetMapping("/all_product")
	public String allProduct( Model model)
	{
		model.addAttribute("allproduct", "this is all product");
		
		return "FrontEnd/Home/html/all_product";
	}
	@GetMapping("/all_product_admin")
	public String allProductAdmin( Model model)
	{
		model.addAttribute("allproduct", "this is all product");
		
		return "FrontEnd/AdminReports/html/all_products";
	}
	@GetMapping("/all_product_farmer")
	public String allProductFarmer( Model model)
	{
		model.addAttribute("allproduct", "this is all product");
		
		return "FrontEnd/Farmer/html/all_products";
	}
	@GetMapping("/notifications")
	public String notifications()
	{
		return "FrontEnd/Home/html/notifications";
	}
	@GetMapping("/all_notifications_expert")
	public String allNotificationsExpert()
	{
		return "FrontEnd/Admin/html/all_notifications_expert";
	}
	@GetMapping("/all_notifications")
	public String allNotifications()
	{
		return "FrontEnd/AdminReports/html/all_notifications";
	}
	@GetMapping("/all_notifications_farmer")
	public String allNotificationsFarmer()
	{
		return "FrontEnd/Farmer/html/all_notifications";
	}
	
	
	@GetMapping("/all_experts")
	public String allExperts(Model model)
	{
		List<Experts> listOfExperts=mainService.getAllExpert();
		for(Experts QA:listOfExperts) {
			System.out.println(QA.getName());
		}
		model.addAttribute("listOfExperts", listOfExperts);
		return "FrontEnd/AdminReports/html/all_experts";
	}
	
	
	@GetMapping("/all_farmers")
	public String allFarmers(Model model)
	{
		List<Farmer> listOfFarmers=mainService.getAllFarmer();
		for(Farmer AF:listOfFarmers) {
			System.out.println(AF.getFirstname());
		}
		model.addAttribute("listOfFarmers", listOfFarmers);
		return "FrontEnd/AdminReports/html/all_farmers";
	}
	
	
	
	@GetMapping("/all_customers")
	public String allCustomers(Model model)
	{
		List<Customer> listOfCustomers=mainService.getAllCustomers();
		for(Customer AF:listOfCustomers) {
			System.out.println(AF.getName());
		}
		model.addAttribute("listOfCustomers", listOfCustomers);
		
		return "FrontEnd/AdminReports/html/all_customers";
	}
	@GetMapping("/all_questions")
	public String allQuestions(Model model)
	{
		List<AskQuestions> listOfQuestions =mainService.getAllQuestions();
		for(AskQuestions QA:listOfQuestions) {
			System.out.println(QA.getFarmerName());
		}
		model.addAttribute("listOfQuestions", listOfQuestions);
		return "FrontEnd/Home/html/all_questions";
	}
	@GetMapping("/all_questions_farmer")
	public String allQuestionsFarmer(Model model)
	{
		List<AskQuestions> listOfQuestions =mainService.getAllQuestions();
		for(AskQuestions QA:listOfQuestions) {
			System.out.println(QA.getFarmerName());
		}
		model.addAttribute("listOfQuestions", listOfQuestions);
		return "FrontEnd/Farmer/html/all_questions";
	}
	@GetMapping("/all_questions_expert")
	public String allQuestionsE(Model model)
	{
	  List<AskQuestions> listOfQuestions	=mainService.getAllQuestions();
	  model.addAttribute("listOfQuestions", listOfQuestions);
		return "FrontEnd/Admin/html/all_questions_expert";
	}
	
	
	
	
	//...............Contact US.................................
	@GetMapping("/contact_us")
	public String contactUsForm()
	{
		
		
		return "FrontEnd/Home/html/contact_us";
	}
	@PostMapping("/contact_us")
	public String contactUs(@ModelAttribute ContactUs contactUs,Model model)
	{
		
		System.out.println(contactUs.getMessage());
		model.addAttribute("success_message", "User Added Succesfully");
		
		return "FrontEnd/Home/html/contact_us";
	}
	
	
}
