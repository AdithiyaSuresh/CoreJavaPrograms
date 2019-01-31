package com.bridgelabz.javaprograms.core.oops;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.javaprograms.core.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryManager {

	public static void main(String[] args) {
		String path = "resource/oops/inventory2.json";
		File file = new File(path);
		ObjectMapper objMapper = new ObjectMapper();
		InventoryFactory inventoryFactory = null;
		List<Product> inventories = new ArrayList<Product>();
		try {
			inventoryFactory = objMapper.readValue(file, InventoryFactory.class);
			inventories = inventoryFactory.getInventories();
			System.out.println("\t Enter the product category name...!");
			String error = "";
			String category;
			do {
				System.out.println("\t " + error);
				category = Utility.getString();
			} while (!Utility.validateStringForAlphanumericOflength20(category));
			addProducts(inventories, category);
			//display the price of each inventory
			//write back to the file
			objMapper.writeValue(file, inventories);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printInventoriesPrice(List<Product> inventories) {
		if (inventories == null || inventories.size() == 0) {
			System.out.println("\t There are no inventries...!");
			return;
		}
		// display the price the of each inventory
	}

	public static void addProducts(List<Product> inventories, String category) {
		Product prod = new Product();
		prod.setCategory(category);
		List<ProductProperty> productProperties = new ArrayList<>();
		String choice = "Y";
		String name;
		double weight;
		double price;
		do {
			System.out.println("\t Enter name of the product");
			name = Utility.getString();
			System.out.println("\t Enter weight of the product");
			weight = Utility.getDouble();
			System.out.println("\t Enter price of the product");
			price = Utility.getDouble();
			ProductProperty prodProperty = new ProductProperty();
			prodProperty.setName(name);
			prodProperty.setWeight(weight);
			prodProperty.setPrice(price);
			productProperties.add(prodProperty);
			System.out.println("\n\t Want to add another product..?(Y/N)");
			choice = Utility.getString();
		} while (!choice.trim().toUpperCase().equals("Y"));
		prod.setProductProperties(productProperties);
		inventories.add(prod);
	}
}
