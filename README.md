# SuperSimpleStock
test program for stock calculation

#Summary of project
This project is used to load the stock entities in memmory
For each stock - shares traded are recorder date and time wise using TreeMap and logged in console or plain text file using log42j API.
               - dividend and p/e ratio, and other params necessary are calulated.
               
# External Jars used
log4j-api-2.8.1.jar
log4j-core-2.8.1.jar

#JDK Version
1.7 or 1.8

#Implementation
1.Enumerators TransactionType  holds the fixed options like buy or sell
            and StockType holds the fixed options like Common or Preffered Stock
			
2.Class Transaction is simple POJO object representing transaction object

3.Class SimpleStock represents Stock attributies and also contains a TreeMap Strucutre to hold 
the volume of transactions happening for the stock at any instance with date and time as key.
Also contains calculation methods for its attributes.

4.Class Indexer used to calculate the index for all stocks at any instance.

5. Every 15 mnts the TreeMap holding collection of trades for a particular stock for the last 15 mnts is fetched
   and stock price is calcualted.
   
Note: Database is not used to store the data for making the program very simple.

With regards,
Author.
               
