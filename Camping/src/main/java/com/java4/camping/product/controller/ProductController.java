package com.java4.camping.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.java4.camping.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping
	public String listProducts(Model model) {

		model.addAttribute("products", productService.getAll());
		return "/product/product";
	}
}