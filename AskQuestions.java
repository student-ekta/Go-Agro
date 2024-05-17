package com.sggsiet.farmerportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AskQuestions {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String farmerName;
 private String question;
 private String answer;
 private String expert;
 
public String getExpert() {
	return expert;
}
public void setExpert(String expert) {
	this.expert = expert;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFarmerName() {
	return farmerName;
}
public void setFarmerName(String farmerName) {
	this.farmerName = farmerName;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}

 
 
}
