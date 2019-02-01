package com.bridgelabz.javaprograms.core.oops.stock;

import com.bridgelabz.javaprograms.core.util.Utility;

public class ProcessStockData {

	public static void main(String[] args) {
		Process process = new Process();
		String result = "";
		do {
			System.out.println("Enter 1 = > Create Stock Account");
			System.out.println("Enter 2 = > Create Stock");
			System.out.println("Enter 3 = > Buy Shares");
			System.out.println("Enter 4 = > Sell Shares");
            //System.out.println("Enter 5 = > Quit");
			String name;
			double balance;
			int choice = getUserChoice();
			switch (choice) {
			case 1: // Create a Stock Account
				System.out.println("Enter Account Holder Name...!");
				name = Utility.getString();
				System.out.println("Enter Initial Balance...!");
				balance = Utility.getDouble();
				result = process.addStockAccount(name, balance);
				System.out.println(result);
				break;

			case 2: // Create a Stock
				System.out.println("Enter Stock Name");
				name = Utility.getString();
				System.out.println("Enter Number of Shares");
				int numOfShares = Utility.getPositiveInt();
				System.out.println("Enter Share Price");
				double price = Utility.getDouble();
				result = process.addStock(name, numOfShares, price);
				System.out.println(result);
				break;
				
			case 3 : //buy shares
				System.out.println("Enter the Name of the StockAccount");
				name = Utility.getString();
				//check is the account exists or not
				result = process.isStockAccountExists(name);
				if(result.equals("false"))
					System.out.println("Stock Account Doesn't Exists ...!");
				else if(!result.equals("true") && !result.equals("false")) //exceptional case
					System.out.println(result);
				else if(!process.areStocksExist())// stock account exists but no stocks available
					  System.out.println("There are no stocks available...!");
				else {
					   process.printStocks();//show the stocks
					   //performing buying ////////////////////////////////
					   System.out.println("");
				}
				break;
				
			case 4 : // sell shares
				System.out.println("Enter the Name of the StockAccount");
				name = Utility.getString();
				//check is the account exists or not
				result = process.isStockAccountExists(name);
				if(result.equals("false"))
					System.out.println("Stock Account Doesn't Exists ...!");
				else if(!result.equals("true") && !result.equals("false")) //exceptional case
					System.out.println(result);
				else if(!process.isStockAccountHasStocks(name))
					System.out.println("StockAccount '"+name+"' doesn't have any stocks to sell");
				else {//perform selling stocks////////////////////////////////////////////////
						
					}  
				break;
				
			}//end of switch
		} while (true);
	}// end of main

	public static int getUserChoice() {
		int choice;
		String error = "";
		do {
			System.out.println(error);
			choice = Utility.getPositiveInt();
			if (choice < 0 || choice > 4)
				error = "Enter a number between 1 - 4";
		} while (!error.equals(""));
		return choice;
	}
}
