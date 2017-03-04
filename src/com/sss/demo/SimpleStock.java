package com.sss.demo;
import com.sss.demo.StockType;
import com.sss.demo.TransactionType;
import com.sss.demo.Transaction;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Date: 03-mar-2017
 * @author Prasadh
 * Version: Sample
 *
 */
public class SimpleStock {
	
	
	/**
	 * Basic Simple Stock entity variables
	 */
	private String stockSymbol ;
	private StockType stockType;
	private Double lastDividend ;
	private Double fixedDividend;
	private Double parValue;
	
	
	/**
	 * store the transaction made for this stock with timestamp as key in tree
	 */
	private TreeMap<Date,Transaction> transactions;
	
	
	/**
	 * Normal setter getter methods
	 * @return
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
	public StockType getStockType() {
		return stockType;
	}
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}
	public Double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public Double getParValue() {
		return parValue;
	}
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	@Override
	public String toString() {
		return "SimpleStock [stockSymbol=" + stockSymbol + ", stockType=" + stockType + ", lastDividend=" + lastDividend
				+ ", fixedDividend=" + fixedDividend + ", parValue=" + parValue + "]";
	}
	public SimpleStock(String stockSymbol, StockType stockType, Double lastDividend, Double fixedDividend,
			Double parValue) {
		this.stockSymbol = stockSymbol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.transactions = new TreeMap<Date,Transaction>();
	}
	
	
	
	
    /**operations to be performed on this stock to generate results */  
 
	/**
	 * calculate the dividend, given the TickerPrice for the stcok as parameter
	 * @param tickerPrice
	 * @return DividendYield
	 */
	public Double calculateDividendYield(Double tickerPrice){
		 switch(this.getStockType()) {
		 
		 case Common:
	     return this.getLastDividend() / tickerPrice;
		 
		 case Preffered:
	     return (this.getFixedDividend()*this.getParValue()) / tickerPrice;
		
		 default:
		 return 0.0;
	}
		
	}
	
	
	/**
	 * calculate the P/E Ratio
	 * @param tickerPrice
	 * @return P E RATIO
	 */
	public Double calulcatePERatio(Double tickerPrice){
		Double dividend = this.calculateDividendYield(tickerPrice);
		return tickerPrice / dividend; 
	}
	
    /**	
	 * iii. Record a trade, with timestamp, quantity of shares, buy or sell indicator and price
	 * a-buying transaction
	 * @param units
	 * @param price
	 */
	public void buyTransaction(Integer units,Double price){
	    Transaction	buyTransaction = new Transaction(TransactionType.Buy,units,price);
	    //System.out.println(buyTransaction.toString());
	    transactions.put(new Date(), buyTransaction);
	}
	
	/**
	 * b-slling transaction
	 * @param units
	 * @param price
	 */
	public void sellTransaction(Integer units,Double price){
		Transaction	sellTransaction = new Transaction(TransactionType.Sell,units,price);
		transactions.put(new Date(), sellTransaction);
	}	

	/**
	 * iv. Calculate Stock Price based on trades recorded in past 15 minutes
	 * @return
	 */
	public Double calculateMinutesStockPrice(){
		Date currentTime = new Date();
		Date minutesBefore = new Date(currentTime.getTime() - (15 * 60 * 1000));
		SortedMap<Date, Transaction> transactions = this.transactions.tailMap(minutesBefore);
		Double minutesStockPrice = 0.0;
		Integer totalUnits = 0;
		for (Transaction transaction: transactions.values()) {
			 minutesStockPrice += transaction.getPrice() * transaction.getQuantity();
			 totalUnits += transaction.getQuantity();
		}
		return minutesStockPrice/totalUnits;
	}
	
	
	/**
	 * additional method required to know the last price of this stock,
	 * using this method, to calculate GBCE All Share Index 
	 * @return Price of the last transacted stock.
	 */
	public Double getLastTrnsactionPrice() {
		//if(this.transactions.size()= 0 ) return 0.0;
		//else return this.transactions.lastEntry().getValue().getPrice();
		if (this.transactions.size() > 0)  return this.transactions.lastEntry().getValue().getPrice();
		else return 0.0;		
	}
}
