package com.anil.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.anil.binding.Product;

@Service
public class ProductService {

	List<Product> collect=Stream.of(new Product(10, "Iphone", "electronics", 10000.0),
			new Product(12, "TV", "electronics", 25000.0), new Product(13, "Table", "Furniture", 5000.0),
			new Product(11, "Chair", "Furniture", 2000.0), new Product(15, "ContinetalGT", "Vehicle", 400000.0),
			new Product(16, "Xplus200V", "Vehicle", 250000.0), new Product(17, "Himalayan", "Vehicle", 300000.0))
			.collect(Collectors.toList());

	public List<Product>getAllProduct() {
		
		return collect;
	}
	public List<Product> getProductByName(String productName) {
		List<Product> product = collect.stream().filter(x->x.getCategorie().equalsIgnoreCase(productName)).collect(Collectors.toList());
	System.out.println(product);
		return product;
	}
	public Product getProductById(int id) {
		Product product = collect.stream().filter(p->p.getPid()==id).findAny().get();
	return product;
	}

}
