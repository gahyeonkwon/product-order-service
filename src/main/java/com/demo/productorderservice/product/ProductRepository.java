package com.demo.productorderservice.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


interface ProductRepository extends JpaRepository<Product, Long> {

}
