package com.java4.camping.product.domain;
public class Product {
	private int id;
    private String productName;
    private int availability;
    private String price;
    private String details;
    private String imgPath;

    
    public Product() {
    }

    public Product(int id, String productName, int availability, String price, String details, String imgPath) {
        this.id = id;
        this.productName = productName;
        this.availability = availability;
        this.price = price;
        this.details = details;
        this.imgPath = imgPath;
    }
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	

    
}
