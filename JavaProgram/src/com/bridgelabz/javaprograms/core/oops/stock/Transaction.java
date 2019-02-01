package com.bridgelabz.javaprograms.core.oops.stock;

import java.util.Date;

public class Transaction {
private String userName;
private String stockName;
private int type;		//1 = > buy 2= > sell
private Date transactionDate;

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getStockName() {
	return stockName;
}
public void setStockName(String stockName) {
	this.stockName = stockName;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public Date getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
}

}
