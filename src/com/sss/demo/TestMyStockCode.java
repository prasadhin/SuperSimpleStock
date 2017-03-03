    package com.sss.demo;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Random;

	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;

	import com.sss.demo.StockType;


	public class TestMyStockCode {
		private static Log log = LogFactory.getLog(TestMyStockCode.class);
		
		public static void main(String args[]) {
		
	        HashMap<String, SimpleStock> db = new HashMap<String, SimpleStock>();
	        db.put("TEA", new SimpleStock("TEA", StockType.Common, 0.0, 0.0, 100.0));
	        db.put("POP", new SimpleStock("POP", StockType.Common, 8.0, 0.0, 100.0));
	        db.put("ALE", new SimpleStock("ALE", StockType.Common, 23.0, 0.0, 60.0));
	        db.put("GIN", new SimpleStock("GIN", StockType.Preffered, 8.0, 0.02, 100.0));
	        db.put("JOE", new SimpleStock("JOE", StockType.Common, 13.0, 0.0, 250.0));
	        
	        for (SimpleStock simpleStock: db.values()) {
	        	log.debug( simpleStock.getStockSymbol() + " dividend: " + simpleStock.calculateDividendYield(9.1));
	        	log.debug( simpleStock.getStockSymbol() + " P/E Ratio: " + simpleStock.calulcatePERatio(9.1));
	         
	        // share trade - sample simulation with 10 trade random pricing for each stock
	        for (int i=1; i <= 10; i++) {
	    		Random ran = new Random();
	    		Integer rangeMin = 1;
	    		Integer rangeMax = 10;
	    		double ranValue = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
	    		simpleStock.buyTransaction(i, ranValue);
	    		log.debug( simpleStock.getStockSymbol() + " bought " + i + " shares at $" + ranValue);
	    		ranValue = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
	    		simpleStock.sellTransaction(i, ranValue);
	    		log.debug( simpleStock.getStockSymbol() + " sold " + i + " shares at $" + ranValue);
	    	}
	        
	        log.debug( simpleStock.getStockSymbol() + " price: £" + simpleStock.getLastTrnsactionPrice());
	    	log.debug( simpleStock.getStockSymbol() + " 15mntsstockPrice: $" + simpleStock.calculateMinutesStockPrice());  
	        
	        }
	        
	        Double GBCEIndex = Indexer.CalculateShareIndex(db);
	        log.debug( "the calculated All Share Index is  " + GBCEIndex);
	}
	}
		




