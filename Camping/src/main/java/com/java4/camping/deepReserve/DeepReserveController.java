/*
 * package com.java4.camping.deepReserve;
 * 
 * import java.util.Arrays;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.java4.camping.product.domain.Product; import
 * com.java4.camping.product.service.ProductService;
 * 
 * @Controller public class DeepReserveController {
 * 
 * @Autowired private ProductService productService;
 * 
 * @RequestMapping(value = "/deepReserve/{id}", method = RequestMethod.GET)
 * public String deepReserve(Model model,
 * 
 * @RequestParam(value = "id", required = false, defaultValue = "1") int
 * productId) { Product product = productService.getProductById(productId);
 * 
 * model.addAttribute("products", Arrays.asList(product)); // "products" 속성을
 * 리스트로 추가 model.addAttribute("products",
 * productService.getAvailableProducts()); return "/payment/deepReserve"; } }
 */