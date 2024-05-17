package com.sggsiet.farmerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sggsiet.farmerportal.entity.Experts;

@Repository
public interface ExpertRepository extends JpaRepository<Experts, Integer>  {

}
