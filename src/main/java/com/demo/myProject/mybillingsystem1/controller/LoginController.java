package com.demo.myProject.mybillingsystem1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.myProject.mybillingsystem1.bean.Login;


@Controller
public class LoginController 
{
	@GetMapping("/")
	public String getLogin(Model model)
	{
		Login login=new Login();
		model.addAttribute("login", login);
		return "main-page";
	}
	
	@PostMapping("/login")
	public String getHome(Model model,@ModelAttribute Login login)
	{
		if(login.getUsername().equalsIgnoreCase("Prasanth.Rachamalla@gmail.com") && login.getPassword().equalsIgnoreCase("root123"))
		{
			String username=login.getUsername();
			System.out.println("into my home page");
			model.addAttribute("username", username);
			return "home";
		}
		else
		{
			return "error";
		}
	}
}
