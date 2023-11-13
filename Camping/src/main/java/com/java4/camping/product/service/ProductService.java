
package com.java4.camping.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.camping.product.dao.ProductDAO;
import com.java4.camping.product.domain.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<Product> getAll() {
		return productDAO.getAll();
	}

	public List<Product> getAvailableProducts() {
		return productDAO.getAvailableProducts();
	}

	public Product getProductById(int productId) {
		return productDAO.getProductById(productId);
	}

}