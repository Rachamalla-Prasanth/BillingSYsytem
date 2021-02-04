package com.demo.myProject.mybillingsystem1.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="product")
	private String product;
	@Column(name="price")
	private int price;
	@Column(name="multiplier")
	private int multiplier;
	@Column(name="date")
	private String date;
	@Column(name="total")
	private int total;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(String product, int price, int multiplier, String date, int total) {
		super();
		this.product = product;
		this.price = price;
		this.multiplier = multiplier;
		this.date = date;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", product=" + product + ", price=" + price + ", multiplier=" + multiplier
				+ ", date=" + date + ", total=" + total + "]";
	}
}
