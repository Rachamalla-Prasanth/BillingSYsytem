package com.demo.myProject.mybillingsystem1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myProject.mybillingsystem1.bean.Transactions;
import com.demo.myProject.mybillingsystem1.dao.TransactionDao;

@Service
public class TransactionServiceImpl 
{
	@Autowired
	private TransactionDao dao;

	public TransactionServiceImpl(TransactionDao dao) {
		super();
		this.dao = dao;
	}
	
	public Transactions saveTransaction(Transactions transactions)
	{
		Transactions tran1=dao.save(transactions);
		return tran1;
	}
	public List<Transactions> getTransactions()
	{
		return dao.findAll();
	}
	public List<Transactions> getDayTransactions(String firstdate)
	{
		return dao.findByDate(firstdate);
	}
	
	public List<Transactions> getBetweenDayTransactions(String firstdate,String lastdate)
	{
		return dao.findBetweenDate(firstdate, lastdate);
	}
}
