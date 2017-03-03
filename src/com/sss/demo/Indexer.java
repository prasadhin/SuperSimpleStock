package com.sss.demo;
import java.util.Map;

public class Indexer {
	
    /**
     * To Calculate the GBCE All Share Index using the geometric mean of prices for all stocks
     * @param simpleStocks
     * @return GBCE All Share Index
     */
    public static Double CalculateShareIndex(Map<String,SimpleStock> simpleStocks){
    Double shareIndex = 1.0;
    for(SimpleStock simpleStock: simpleStocks.values()) {
    	shareIndex *= simpleStock.getLastTrnsactionPrice() ;
    }
    return Math.pow(shareIndex,1.0/simpleStocks.size());
    }
}

