package com.bridgelabz.javaprograms.core.oops.stock;

public interface Account {
	
	double valueOf();

	void buy(int amount, String symbol);

	void sell(int amount, String symbol);

	void save(String filename);

	void printReport();
}
