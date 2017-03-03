package com.sss.demo;

public class Transaction {
	
    // Basic Transaction entity variables
	private TransactionType transType  ;
    private Integer quantity ;
	private Double price ;
	
	public TransactionType getTransType() {
		return transType;
	}
	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public Transaction(TransactionType transType, Integer quantity, Double price) {
		this.transType = transType;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Transaction [transType=" + transType + ", quantity=" + quantity + ", price=" + price + "]";
	}
	 
	 
}
