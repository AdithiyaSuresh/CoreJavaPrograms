package com.bridgelabz.javaprograms.core.oops.stock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.javaprograms.core.oops.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Process {
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * creates a new StockAccount
	 * 
	 * @param name    name of the account holder
	 * @param balance initial balance
	 * @return SUCCESS if account created else some error message
	 */
	public String addStockAccount(String name, Double balance) {
		String result = "SUCCESS";// variable to return result of the function

		StockAccount newAccount = new StockAccount();
		newAccount.setName(name);
		newAccount.setBalance(balance);
		newAccount.setCompanyShares(new ArrayList<CompanyShare>());

		// get previous data from the file
		JsonAccounts jsonData = null;
		List<StockAccount> stockAccounts = null;

		File file = new File("resource/stock/stockAccounts.json");
		try {
			if (file.length() == 0) {// empty file
				stockAccounts = new ArrayList<>();
				jsonData = new JsonAccounts();
				jsonData.setNameForJson("StockAccounts");
				jsonData.setStockAccounts(stockAccounts);
			} else {
				jsonData = mapper.readValue(file, JsonAccounts.class);
				stockAccounts = jsonData.getStockAccounts();
			}
			stockAccounts.add(newAccount);
			// write back to the file
			mapper.writeValue(file, jsonData);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	/**
	 * create a new Stock
	 * 
	 * @param name           name of the company
	 * @param numberOfShares no. of shares
	 * @param price          price of each share
	 * @return SUCCESS if account created else some error message
	 */
	public String addStock(String name, int numberOfShares, double price) {

		String result = "SUCCESS";// variable to return result of the function

		Stock newStock = new Stock();
		newStock.setName(name);
		newStock.setNumberOfShares(numberOfShares);
		newStock.setPrice(price);

		// get previous data from the file
		JsonStocks jsonData = null;
		List<Stock> stocks = null;
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("resource/stock/stocks2.json");
		try {
			if (file.length() == 0) {// empty file
				stocks = new ArrayList<>();
				jsonData = new JsonStocks();
				jsonData.setJsonObjName("stocks");
				jsonData.setStocks(stocks);
			} else {
				jsonData = mapper.readValue(file, JsonStocks.class);
				stocks = jsonData.getStocks();
			}
			stocks.add(newStock);
			// write back to the file
			mapper.writeValue(file, jsonData);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	public String isStockAccountExists(String stockAccountName) {
		String result;
		File file = new File("resource/stock/stockAccounts.json");
		try {
			JsonAccounts jsonData = mapper.readValue(file, JsonAccounts.class);
			if (jsonData == null)
				result = "false";
			else if (jsonData.getStockAccounts().stream().filter(a -> a.getName().equals(stockAccountName.trim()))
					.findFirst().isPresent())
				result = "true";
			else
				result = "false";
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	/**
	 * chesks the stocks are there are not
	 * 
	 * @return true if stocks are there else false
	 */
	public boolean areStocksExist() {
		File file = new File("resource/stock/stocks2.json");
		if (file.length() == 0)
			return false;
		else
			return true;
	}

	/**
	 * prints all the available stocks
	 */
	public void printStocks() {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("resource/stock/stocks2.json");
		try {
			JsonStocks jsonData = mapper.readValue(file, JsonStocks.class);
			System.out.println("Stock Name \t Available Share \t Share Price");
			System.out.println("----------------------------------------------------------");
			for (Stock s : jsonData.getStocks()) {
				System.out.println(s.getName() + "\t " + s.getNumberOfShares() + "\t " + s.getPrice());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * checks a stock account has the stocks or not
	 * @param stockAccountName name of the StockAccount
	 * @return true or false
	 */
	public boolean isStockAccountHasStocks(String stockAccountName) {
		JsonAccounts jsonData = null;
		List<StockAccount> stockAccounts = null;
		boolean result = false;
		File file = new File("resource/stock/stockAccounts.json");
		try {
			jsonData = mapper.readValue(file, JsonAccounts.class);
			stockAccounts = jsonData.getStockAccounts();
			if (stockAccounts.size() == 0)
				result = false;
			else
				result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
