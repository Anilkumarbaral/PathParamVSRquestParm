package com.anil.binding;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	
	private int pid;
	private String pname;
	private String categorie;
	private double price;

}
