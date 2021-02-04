package com.demo.myProject.mybillingsystem1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.myProject.mybillingsystem1.bean.Transactions;

@Repository
public interface TransactionDao extends JpaRepository<Transactions, Integer>
{

	@Query("from Transactions t where t.date=?1")
	public  List<Transactions> findByDate(String firstDate);
	@Query("from Transactions t where t.date between ?1 and ?2")
	public  List<Transactions> findBetweenDate(String firstDate,String lastDate);

}
