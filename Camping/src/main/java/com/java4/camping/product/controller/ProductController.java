
package com.java4.camping.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.product.domain.Product;
import com.java4.camping.product.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model) {

		model.addAttribute("products", productService.getAll());
		return "/payment/product";
	}

	@RequestMapping(value = "/availableProducts", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> listAvailableProducts() {
        List<Product> availableProducts = productService.getAvailableProducts();
        return new ResponseEntity<>(availableProducts, HttpStatus.OK);
    }
	
	
}
