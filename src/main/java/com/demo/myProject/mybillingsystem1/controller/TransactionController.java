package com.demo.myProject.mybillingsystem1.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.myProject.mybillingsystem1.bean.Transactions;
import com.demo.myProject.mybillingsystem1.service.TransactionServiceImpl;

@Controller
@RequestMapping("/transactions")
public class TransactionController 
{
	@Autowired
	private TransactionServiceImpl service;

	public TransactionController(TransactionServiceImpl service) {
		super();
		this.service = service;
	}

	@GetMapping("/details")
	public String enterDetails(Model model)
	{
		Transactions tran=new Transactions();
		model.addAttribute("transactions", tran);
		return"transactions";
	}
	
	@PostMapping("/save")
	public String saveDetails(@ModelAttribute Transactions transactions,Model model)
	{
		int fulltotal=0;
		int price=transactions.getPrice();
		int multiplier=transactions.getMultiplier();
		int total=price*multiplier;
		transactions.setTotal(total);
		service.saveTransaction(transactions);
		List<Transactions> presentlist=new ArrayList<Transactions>();
		presentlist.add(transactions);
		model.addAttribute("tlist", presentlist);
		for(int i=0;i<presentlist.size();i++) 
		  {
			  fulltotal=fulltotal+presentlist.get(i).getTotal(); 
		  }
		model.addAttribute("prodtotal", fulltotal);
		return "transactions";
	}
	
	@GetMapping("/dayreport")
	public String getReport(Model model)
	{
		
		  Transactions tran=new Transactions();
		  model.addAttribute("transactions", tran);
		  return"daily-report";
	}
	
	@PostMapping("/dayreport")
	public String getDayReport(Model model,@ModelAttribute Transactions transactions)
	{
		String firstdate=transactions.getDate();
		List<Transactions> list=service.getDayTransactions(firstdate);
		model.addAttribute("daylist", list);
		return"daily-report";
	}
	
	@GetMapping("/datesreport")
	public String getDateReport(Model model)
	{
		Transactions transactions=new Transactions();
		model.addAttribute("transactions", transactions);
		return"date-report";
	}
	
	@PostMapping("/datesreport")
	public String getDateReport(Model model,@ModelAttribute Transactions transactions)
	{
		String firstdate=transactions.getDate().substring(0, 10);
		String lastdate=transactions.getDate().substring(11, 21);
		System.out.println("Firstdate is: "+firstdate);
		System.out.println("Lastdate is: "+lastdate);
		List<Transactions> list=service.getBetweenDayTransactions(firstdate, lastdate);
		System.out.println(list.toString());
		model.addAttribute("daylist", list);
		return"date-report";
	}
	
	@GetMapping("/bargraph")
	public String getBarGraph(Model model)
	{
		Map<String, Integer> data=new LinkedHashMap<String, Integer>();
		List<Transactions> list=service.getTransactions();
		for(Transactions i:list)
		{
			String name=i.getDate();
			int total=data.containsKey(name)?data.get(name):0;
			total=total+i.getTotal();
			data.put(name, total);
			System.out.println(data);
		}
		System.out.println("outside:"+data);
		model.addAttribute("mydata", data);
		return "bar-graph";
	}
	
	@GetMapping("/piechart")
	public String getPieChart(Model model)
	{
		Map<String, Integer> data=new LinkedHashMap<String, Integer>();
		List<Transactions> list=service.getTransactions();
		for(Transactions i:list)
		{
			String name=i.getDate();
			int total=data.containsKey(name)?data.get(name):0;
			total=total+i.getTotal();
			data.put(name, total);
			System.out.println(data);
		}
		model.addAttribute("data", data);
		System.out.println(data.keySet());
		System.out.println(data.values());
		return "pie-chart";
	}
}
