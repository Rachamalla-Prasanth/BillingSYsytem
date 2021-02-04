package com.demo.myProject.mybillingsystem1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myProject.mybillingsystem1.bean.Product;
import com.demo.myProject.mybillingsystem1.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao dao;
	
	public ProductServiceImpl(ProductDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Product> getProducts() 
	{	
		List<Product> list=dao.findAll();
		System.out.println(list.get(0).getProductName());
		return list;
	}

	@Override
	public Product getProduct(int id) 
	{
		Product product=null;
		Optional<Product> result=dao.findById(id);
		if(result.isPresent())
		{
			product=result.get();
		}
		else
		{
			throw new RuntimeException("Product doesnt found for Id - "+id);
		}
		return product;
	}
	
	public Product getProduct(String productName) 
	{
		Product product=dao.findByName(productName);		
		return product;
	}

	@Override
	public Product saveProduct(Product theProduct) 
	{
		dao.save(theProduct);
		return theProduct;
	}

	@Override
	public void deleteProduct(int id) 
	{
		dao.deleteById(id);
	}
}
