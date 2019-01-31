package com.bridgelabz.javaprograms.core.oops;

import java.util.List;

public class Product {
	private String category;
	private List<ProductProperty> productProperties;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<ProductProperty> getProductProperties() {
		return productProperties;
	}
	public void setProductProperties(List<ProductProperty> productProperties) {
		this.productProperties = productProperties;
	}
}
