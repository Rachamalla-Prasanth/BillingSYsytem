package com.demo.myProject.mybillingsystem1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.myProject.mybillingsystem1.bean.Product;
import com.demo.myProject.mybillingsystem1.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
		
	}

	@GetMapping("/list")
	public String getList(Model model)
	{
		List<Product> list=service.getProducts();
		System.out.println(list.toString());
		Product product=new Product();
		product.setId(0);
		product.setPrice(0);
		model.addAttribute("prodlist", list);
		model.addAttribute("searchprod", product);
		return "product-list";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model)
	{
		Product product=new Product();
		model.addAttribute("newproduct", product);
		return "add-product";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product theProduct)
	{
		service.saveProduct(theProduct);
		return "redirect:/product/list";
	}
	
	@GetMapping("/update")
	public String updateProduct(@RequestParam("pid")int id,Model model)
	{
		Product theProduct=service.getProduct(id);
		model.addAttribute("newproduct", theProduct);
		return "add-product";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("pid")int id)
	{
		service.deleteProduct(id);
		return "redirect:/product/list";
	}
	
	@PostMapping("/getProduct")
	public String getProduct(Model model,@ModelAttribute Product product1)
	{
		String name=product1.getProductName();
		Product p1=service.getProduct(name);
		System.out.println(p1.toString());
		System.out.println("in the post mapping loop");
		model.addAttribute("tprod", p1);
		Product product=new Product();
		product.setId(0);
		product.setPrice(0);
		model.addAttribute("searchprod", product);
		return "product";
	}
	
	@GetMapping("/disable")
	public String getDisabled()
	{
		System.out.println("In Disable Controller");
		return "disabled";
	}
}
