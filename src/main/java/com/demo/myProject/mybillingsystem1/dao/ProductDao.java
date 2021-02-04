package com.demo.myProject.mybillingsystem1.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.myProject.mybillingsystem1.bean.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>
{

	@Query("from Product p where p.productName=?1")
	public  Product findByName(String productName);

}
