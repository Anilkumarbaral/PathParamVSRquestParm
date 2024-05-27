package com.anil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anil.binding.Product;
import com.anil.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Product>>getAllProducts(){
		List<Product> allProduct = productService.getAllProduct();
		return  ResponseEntity.ok(allProduct);
	}
	@GetMapping("/filter")
	public ResponseEntity<?>getProductByName(@RequestParam(value="productType",required =false,defaultValue = "Vehicle")String productType){
		
		List<Product> result = productType != null ? productService.getProductByName(productType) : productService.getAllProduct();

		return ResponseEntity.ok(result);
			
	}
	@GetMapping("/{pid}")
	public ResponseEntity<Product>getProductById(@PathVariable("pid")Integer id){
		Product productById = productService.getProductById(id);
		return ResponseEntity.ok(productById);
	}
}


