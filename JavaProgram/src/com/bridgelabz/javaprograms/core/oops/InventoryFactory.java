package com.bridgelabz.javaprograms.core.oops;

import java.util.List;

public class InventoryFactory {
	List<Product> inventories;

	public List<Product> getInventories() {
		return inventories;
	} 
	public List<Product> setInventories(List<Product> inventories) {
		return this.inventories = inventories;
	} 
}
