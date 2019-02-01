package com.bridgelabz.javaprograms.core.oops.stock;

import java.util.List;

public class StockAccount implements Account {
    private String name;
    private double balance;
    private List<CompanyShare> companyShares;
	
    @Override
	public double valueOf() {
		return 0;
	}

	@Override
	public void buy(int amount, String symbol) {

	}

	@Override
	public void sell(int amount, String symbol) {

	}

	@Override
	public void save(String filename) {

	}

	@Override
	public void printReport() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<CompanyShare> getCompanyShares() {
		return companyShares;
	}

	public void setCompanyShares(List<CompanyShare> companyShares) {
		this.companyShares = companyShares;
	}
}
