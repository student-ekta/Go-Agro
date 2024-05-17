package com.sggsiet.farmerportal.service;

import java.util.List;

import com.sggsiet.farmerportal.entity.Admin;
import com.sggsiet.farmerportal.entity.AskQuestions;
import com.sggsiet.farmerportal.entity.Customer;
import com.sggsiet.farmerportal.entity.Experts;
import com.sggsiet.farmerportal.entity.Farmer;
import com.sggsiet.farmerportal.entity.Product;


public interface MainService {

	void saveFarmer(Farmer farmer);

	void saveProduct(Product product);

	Admin getAdminData();

	void saveCustomer(Customer customer);

	void saveExpert(Experts expert);

	List<Farmer> getAllFarmers();

	List<Customer> getCustomer();

	void saveQuestion(AskQuestions askQuestions);

	List<AskQuestions> getAllQuestions();

	List<Experts> getAllExpert();

	List<Farmer> getAllFarmer();

	List<Customer> getAllCustomers();

	AskQuestions getQuestion(String farmerName);

	List<AskQuestions> getMyQuestions(String farmername);

	

	
	

}
