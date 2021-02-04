package com.demo.myProject.mybillingsystem1.service;

import java.util.List;

import com.demo.myProject.mybillingsystem1.bean.Product;

public interface ProductService
{
	public List<Product> getProducts();
	public Product getProduct(int id);
	public Product saveProduct(Product theProduct);
	public void deleteProduct(int id);
	public Product getProduct(String productName);
}
