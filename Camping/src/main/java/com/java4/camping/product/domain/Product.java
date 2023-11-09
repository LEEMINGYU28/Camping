package com.java4.camping.product.domain;

import java.time.LocalDateTime;

public class Product {
	private int id;
	private String name;
	private String detail;
	private int price;
	private int available;
	private LocalDateTime date;

	
	public Product() {
	}

	public Product(int id, String name, String detail, int price, int available, LocalDateTime date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.available = available;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}