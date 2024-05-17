package com.sggsiet.farmerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sggsiet.farmerportal.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
