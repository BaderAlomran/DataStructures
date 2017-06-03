import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StockExchange {
	protected final int maxPrice = 32767; // maximum short integer value.
	// lowest sell order price of any submitted sell order
   protected short lowestSellOrderPrice = 0;    
   // highest buy order price of any submitted buy order    
   protected short highestBuyOrderPrice = maxPrice; 
   
   protected MyHashMap<String,ArrayList<Order>> trades;
   protected ArrayList<ArrayList<Order>> submittedOrders;

   // Constructor
   public StockExchange() {
   } 

   public static class Order implements Comparable<Order> {
	   protected enum ordertype {BUY, SELL, TRADE};
	  
	   protected String symbol;     // Stock symbol, e.g., "GOOG"

	   protected ordertype type;    // order to buy or sell shares, 
	                                // or a trade that matched a BUY and a SELL order

	   protected short price;       // the price 100.50 is represented by the 
	                                // short integer value 10050

	   protected int shares;        // number of shares to buy or sell, or shares traded in 
	                                // a trade that matched a Buy order and a SELL order

	   protected String buyer;      // Name of buyer

	   protected String seller;     // Name of seller

	   //Constructor
	   //Target Complexity: O(1)
	   public Order(String symbol, short price, int shares, ordertype type, String buyer, String seller) {
	   }

	   public String toString() {
	      return (symbol + "," + type + "," + price + "," + shares + "," + buyer + "," + seller);
	   }

	   // Returns the hash code. Two equal Orders should have equal hashCodes.
	   public int hashCode() {
		return 0;
	   }

	   // Compare the prices of this and the other Order
	   public int compareTo(Order other) {
		return 0;
	}

	   // Compares the other object with this entry for equality. Two Orders are equal if all of their 
	   // data members are equal. Two equal Orders should have equal hashCodes.
	   public boolean equals(Object other) {
		return false;
	}
}

   // Attempt to trade all of the orders, i.e., the List of orders returned by readAllOrders().
   // The main method of an application that uses StockExchange would look like:
   //   create a Scanner s from the input file, and use s to get a list of orders: orders = readAllOrders(s)
   //   tradeAll(orders) matches the buy and sell orders
   //   display all the trades by showing tradesToString()
   
   //public void tradeAll(List<Order> orders) {}

   // Returns the TRADE orders
   public MyHashMap<String,ArrayList<Order>> getTrades() {
	return trades;
   }

   // Returns the currently stored submitted buys and sell orders
   protected ArrayList<ArrayList<Order>> getSubmittedOrders() {
	return null;
   }
	
   public short getLowestSellOrderPrice() { return lowestSellOrderPrice;}

   public short getHighestBuyOrderPrice() {return highestBuyOrderPrice;}

   // Extracts tokens from Scanner s and uses them to create Order objects. 
   // The source of Scanner s is the contents of the input file.
   // The Order objects are returned in a List<Order>
   // Computes and saves lowestSellOrderPrice and highestBuyOrderPrice.
   
   //public List<Order> readAllOrders(Scanner s){}

   // Reads token values from Scanner s, and uses these values to construct and 
   // return an Order object. 
   // This method is called by readAllOrders
   public Order readOrder(Scanner s)
   {
	   return null;
   }

   // Returns a String representation of the trades.
   // Trades are returned in alphabetical order of their symbols, and for each symbol, 
   // in ascending order of the prices. See the example below.
   // Implementation Note: Can use Collections.sort(List) for sorting.
   public String tradesToString() {
	return null;
   }
}
