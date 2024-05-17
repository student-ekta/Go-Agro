package com.sggsiet.farmerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sggsiet.farmerportal.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

}
