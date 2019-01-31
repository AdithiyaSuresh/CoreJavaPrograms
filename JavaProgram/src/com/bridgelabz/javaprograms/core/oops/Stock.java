package com.bridgelabz.javaprograms.core.oops;

public class Stock {
	private String name;
	private int numberOfShares;
	private  double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * gives the total stock value of a firm
	 * @return total stock value
	 */
	public double getTotalStockValue() {
		return getNumberOfShares() * getPrice();
	}
}
