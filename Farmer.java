package com.sggsiet.farmerportal.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;




@Entity
public class Farmer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="firstname should not be blank")
	private String firstname;
	@NotBlank(message="middlename should not be blank")
	private String middlename;
	@NotBlank(message="lastname should not be blank")
	private String lastname;
	@NotBlank(message="gender should not be blank")
	private String gender;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	//@NotBlank(message="date of birth should not be blank")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date dob;
	@NotBlank(message="nationality should not be blank")
	private String nationality;
	@NotBlank(message="email should not be blank")
	private String email;
	@NotBlank(message="mobile should not be blank")
	private String mobile;
	@NotBlank(message="username should not be blank")
	private String username;
	@NotBlank(message="password should not be blank")
	private String password;
	@NotBlank(message="adddress should not be blank")
	private String address;
	
	
	@Override
	public String toString() {
		return "Farmer [id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", gender=" + gender + ", dob=" + dob + ", nationality=" + nationality + ", email=" + email
				+ ", mobile=" + mobile + ", username=" + username + ", password=" + password + ", address=" + address
				+ "]";
	}
	
	public Farmer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Farmer(@NotBlank(message = "firstname should not be blank") String firstname,
			@NotBlank(message = "middlename should not be blank") String middlename,
			@NotBlank(message = "lastname should not be blank") String lastname,
			@NotBlank(message = "gender should not be blank") String gender,
			/* @NotBlank(message = "date of birth should not be blank") */ Date dob,
			@NotBlank(message = "nationality should not be blank") String nationality,
			@NotBlank(message = "email should not be blank") String email,
			@NotBlank(message = "mobile should not be blank") String mobile,
			@NotBlank(message = "username should not be blank") String username,
			@NotBlank(message = "password should not be blank") String password,
			@NotBlank(message = "adddress should not be blank") String address) {
		super();
		
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
