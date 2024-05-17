package com.sggsiet.farmerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sggsiet.farmerportal.entity.AskQuestions;

@Repository
public interface AskQuestionRepository extends JpaRepository<AskQuestions, Integer> {

	AskQuestions findByFarmerName(String farmerName);

	List<AskQuestions> findAllByfarmerName(String farmername);

}
