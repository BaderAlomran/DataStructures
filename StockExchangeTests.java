// CHANGELOG: Fixed a bug Monday 11/9 @10:00pm.

// Tests for StockExchange.

/* To run them on the command line, make sure that the junit-310.jar
   is in the project directory.
 
   demo$ javac -cp .:junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .:junit-cs310.jar StockExchangeTests   # run tests
 
   On Windows replace : with ; (colon with semicolon)
   demo$ javac -cp .;junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .;junit-cs310.jar StockExchangeTests   # run tests
*/

import org.junit.*;
import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class StockExchangeTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("StockExchangeTests");
  }
  

  ////////////////////////////////////////////////////////////////////////////////
  // NEW TESTS Day Nov XX 00:00:0 EDT 2015 
  // @Test(timeout=1000,expected=SomeException.class)

// test StockExchange.Orders equals  // given in the spec

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals1() {
// equal orders
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = true;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals2() {
// unequal orders due to symbol
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("B"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals3() {
// unequal orders due to price
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10220,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals4() {
// unequal orders due to shares
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10221,99,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals5() {
// unequal orders due to type
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.BUY,new String("ETRADE"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals6() {
// unequal orders due to buyer
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("E"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equals7() {
// unequal orders due to seller
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("S"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
}

// test StockExchange.Order compareTo

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_compareTo1() {
// test compareTo : 0

  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)1,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)1,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  
  int actualValue = FBOrder1.compareTo(FBOrder2);
  int expectedValue = 0;
  if(actualValue != expectedValue) {
       failFmt("StockExchange.Order.compareTo:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_compareTo2() {
// test compareTo : -1

  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)1,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)2,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  
  int actualValue = FBOrder1.compareTo(FBOrder2);
  int expectedValue = -1;
  if(actualValue != expectedValue) {
       failFmt("StockExchange.Order.compareTo:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_compareTo3() {
// test compareTo : 1

  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)1,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)0,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  
  int actualValue = FBOrder1.compareTo(FBOrder2);
  int expectedValue = 1;
  if(actualValue != expectedValue) {
       failFmt("StockExchange.Order.compareTo:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }


// test StockExchange.Orders toString  // given in the spec

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_toString1() {
  StockExchange.Order FBOrder = new StockExchange.Order("FB",(short)10221,100,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  String actualString = FBOrder.toString().replaceAll("\\s+","");
  String expectedString = new String("FB,TRADE,10221,100,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order toString:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
}

// test StockExchange.Orders hashCode 

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_Order_equalhashCodes() {
// equal orders must have equal hashCodes
  StockExchange.Order FBOrder1 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));
  StockExchange.Order FBOrder2 = new StockExchange.Order(new String("FB"),(short)10221,100,StockExchange.Order.ordertype.TRADE,new String("ETRADE"),new String("Schwab"));

  boolean actualEquals = FBOrder1.equals(FBOrder2);
  boolean expectedEquals = true;
  if(actualEquals != expectedEquals) {
       failFmt("StockExchange.Order equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 

  boolean actualEqualhashCodes = FBOrder1.hashCode() == FBOrder2.hashCode();
  boolean expectedEqualhashCodes = true;
  if(actualEqualhashCodes != expectedEqualhashCodes) {
       failFmt("StockExchange.Order equal hashCodes:\n"+
               "expectedEqualhashCodes: "+expectedEqualhashCodes +"\n"+
               "actualEqualhashCodes: "+actualEqualhashCodes+"\n"+"");
  } 
}


// test StockExchange getLowestSellOrderPrice

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_getLowestSellOrderPrice1() {

  StockExchange E = new StockExchange();
  E.lowestSellOrderPrice = 10;
  int actualPrice = E.getLowestSellOrderPrice();
  int expectedPrice = 10;

  if(actualPrice != expectedPrice) {
       failFmt("StockExchange getLowestSellOrderPrice:\n"+
               "expectedPrice: "+expectedPrice +"\n"+
               "actualPrice: "+actualPrice+"\n"+"");
  }

}

// test StockExchange getHighestBuyOrderPrice

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_getHighestBuyOrderPrice1() {

  StockExchange E = new StockExchange();
  E.highestBuyOrderPrice = 10;
  int actualPrice = E.getHighestBuyOrderPrice();
  int expectedPrice = 10;

  if(actualPrice != expectedPrice) {
       failFmt("StockExchange getHighestBuyOrderPrice:\n"+
               "expectedPrice: "+expectedPrice +"\n"+
               "actualPrice: "+actualPrice+"\n"+"");
  }
}

// test StockExchange readOrder

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_readOrder1() {

  StockExchange E = new StockExchange();
  String orderString = "GOOG buy 30000 75 ETRADE Seller";
  Scanner s = new Scanner(orderString);
  StockExchange.Order actualOrder = E.readOrder(s);
  StockExchange.Order expectedOrder = 
    new StockExchange.Order("GOOG",(short)30000,75,StockExchange.Order.ordertype.BUY,"ETRADE","Seller");

  if(!actualOrder.equals(expectedOrder)) {
       failFmt("StockExchange readOrder:\n"+
               "expectedOrder: "+expectedOrder +"\n"+
               "actualOrder: "+actualOrder+"\n"+"");
  }
}

// test StockExchange readAllOrders

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_readAllOrders1() {
// test readAllOrders with Scanner containing 3 lines: number of lines + 2 orders
  StockExchange E = new StockExchange();
  String orderString = "2" + "\n" + "GOOG buy 30000 75 ETRADE Seller" + "\n" + "FB sell 10219 100 Buyer Schwab";
  Scanner s = new Scanner(orderString);
  List<StockExchange.Order> actualOrderList = E.readAllOrders(s);

  int actualSize = actualOrderList.size();
  int expectedSize = 2;

  if(actualSize != expectedSize) {
       failFmt("StockExchange readAllOrders:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGOrder = new StockExchange.Order("GOOG",(short)30000,75,StockExchange.Order.ordertype.BUY,"ETRADE","Seller");
  boolean actualContains = actualOrderList.contains(GOOGOrder);
  boolean expectedContains = true;

  if(actualContains != expectedContains) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains: "+expectedContains +"\n"+
               "actualContains: "+actualContains+"\n"+"");
  } 

  StockExchange.Order FBOrder = new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.SELL,"Buyer","Schwab");
  boolean actualContains1 = actualOrderList.contains(FBOrder);
  boolean expectedContains1 = true;

  if(actualContains1 != expectedContains1) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains1: "+expectedContains1 +"\n"+
               "actualContains1: "+actualContains1+"\n"+"");
  } 
}


// test StockExchange tradeAll

/*
5
GOOG buy 30000 75 ETrade Seller 
FB sell 10219 100 Buyer Schwab 
GOOG sell 29999 50 Buyer Schwab
FB buy 10221 100 ETrade Seller
GOOG sell 29950 25 ETrade Seller 
*/


@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll1() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("FB",(short)10221,100,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  E.lowestSellOrderPrice = 10219;
  E.highestBuyOrderPrice = 10221;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("FB");

  int actualSize = tradeList.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order FBTrade = tradeList.get(0);
  String actualString = FBTrade.toString().replaceAll("\\s+","");
  String expectedString = new String("FB,TRADE,10219,100,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
  
}


@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll2() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)30000,75,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29999,25,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  E.lowestSellOrderPrice = 29999;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = tradeList.get(0);
  String actualString = GOOGTrade.toString().replaceAll("\\s+","");
  String expectedString = new String("GOOG,TRADE,30000,25,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll3() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)30000,50,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29950,50,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  E.lowestSellOrderPrice = 29950;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = tradeList.get(0);
  String actualString = GOOGTrade.toString().replaceAll("\\s+","");
  String expectedString = new String("GOOG,TRADE,30000,50,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
  
}


@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll4() {
// matching buys and sells: 75 - 25 = 50 for second match
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)30000,75,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29999,25,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)29950,50,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  E.lowestSellOrderPrice = 29950;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 2;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  //System.out.println();
  //System.out.println(tradeList.get(0));
  //System.out.println(tradeList.get(1));
  StockExchange.Order GOOGTrade = new StockExchange.Order("GOOG",(short)30000,25,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains = tradeList.contains(GOOGTrade);
  boolean expectedContains = true;

  if(actualContains != expectedContains) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains: "+expectedContains +"\n"+
               "actualContains: "+actualContains+"\n"+"");
  } 

  StockExchange.Order GOOGTrade1 = new StockExchange.Order("GOOG",(short)30000,50,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains1 = tradeList.contains(GOOGTrade1);
  boolean expectedContains1 = true;

  if(actualContains1 != expectedContains1) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains1: "+expectedContains1 +"\n"+
               "actualContains1: "+actualContains1+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll5() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("FB",(short)10221,100,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  E.lowestSellOrderPrice = 10219;
  E.highestBuyOrderPrice = 10221;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("FB");

  int actualSize = tradeList.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order FBTrade = tradeList.get(0);
  String actualString = FBTrade.toString().replaceAll("\\s+","");
  String expectedString = new String("FB,TRADE,10221,100,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll6() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)29999,75,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)30000,25,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  E.lowestSellOrderPrice = 29999;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = tradeList.get(0);
  String actualString = GOOGTrade.toString().replaceAll("\\s+","");
  String expectedString = new String("GOOG,TRADE,29999,25,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll7() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)29950,50,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)30000,50,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  E.lowestSellOrderPrice = 29950;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = tradeList.get(0);
  String actualString = GOOGTrade.toString().replaceAll("\\s+","");
  String expectedString = new String("GOOG,TRADE,29950,50,ETRADE,Schwab").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll8() {
// matching buy and sell
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)29950,75,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)30000,25,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29999,50,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  E.lowestSellOrderPrice = 29950;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();
  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 2;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = new StockExchange.Order("GOOG",(short)29950,25,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains = tradeList.contains(GOOGTrade);
  boolean expectedContains = true;

  if(actualContains != expectedContains) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains: "+expectedContains +"\n"+
               "actualContains: "+actualContains+"\n"+"");
  } 

  StockExchange.Order GOOGTrade1 = new StockExchange.Order("GOOG",(short)29950,50,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains1 = tradeList.contains(GOOGTrade1);
  boolean expectedContains1 = true;

  if(actualContains1 != expectedContains1) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains1: "+expectedContains1 +"\n"+
               "actualContains1: "+actualContains1+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll9() {
// matching buy and sell (similar to example from spec)
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)29950,75,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)30000,25,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("FB",(short)10221,100,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29999,50,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));

  E.lowestSellOrderPrice = 10219;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();

  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 2;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = new StockExchange.Order("GOOG",(short)29950,25,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains = tradeList.contains(GOOGTrade);
  boolean expectedContains = true;

  if(actualContains != expectedContains) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains: "+expectedContains +"\n"+
               "actualContains: "+actualContains+"\n"+"");
  } 

  StockExchange.Order GOOGTrade1 = new StockExchange.Order("GOOG",(short)29950,50,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains1 = tradeList.contains(GOOGTrade1);
  boolean expectedContains1 = true;

  if(actualContains1 != expectedContains1) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains1: "+expectedContains1 +"\n"+
               "actualContains1: "+actualContains1+"\n"+"");
  }

  tradeList = trades.get("FB");

  int actualSize1 = tradeList.size();
  int expectedSize1 = 1;

  if(actualSize1 != expectedSize1) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize1: "+expectedSize1 +"\n"+
               "actualSize1: "+actualSize1+"\n"+"");
  }

  StockExchange.Order FBTrade = new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains2 = tradeList.contains(FBTrade);
  boolean expectedContains2 = true;

  if(actualContains2 != expectedContains2) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedContains2: "+expectedContains2 +"\n"+
               "actualContains2: "+actualContains2+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll10() {
// no match
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  StockExchange.Order FB_sell = new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.SELL,"Buyer","Schwab");
  E.lowestSellOrderPrice = 10219;
  E.highestBuyOrderPrice = 32767;

  orders.add(FB_sell);
  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();

  int actualSize = trades.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  ArrayList<ArrayList<StockExchange.Order>> submittedOrders = E.getSubmittedOrders();
  ArrayList<StockExchange.Order> actualOrderList = submittedOrders.get(10219);
  StockExchange.Order actualOrder = actualOrderList.get(0);

  if(actualOrder == null || !actualOrder.equals(FB_sell)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedOrder: "+FB_sell +"\n"+
               "actualOrder: "+actualOrder+"\n"+"");
  } 
}


@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll11() {
// no match
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  StockExchange.Order FB_buy =  new StockExchange.Order("FB",(short)10221,100,StockExchange.Order.ordertype.BUY,"ETRADE","Seller");
  E.lowestSellOrderPrice = 0;
  E.highestBuyOrderPrice = 10221;

  orders.add(FB_buy);
  E.lowestSellOrderPrice = 10221;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();

  int actualSize = trades.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  ArrayList<ArrayList<StockExchange.Order>> submittedOrders = E.getSubmittedOrders();
  ArrayList<StockExchange.Order> actualOrderList = submittedOrders.get(10221);
  StockExchange.Order actualOrder = actualOrderList.get(0);

  if(actualOrder == null || !actualOrder.equals(FB_buy)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedOrder: "+FB_buy +"\n"+
               "actualOrder: "+actualOrder+"\n"+"");
  } 
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradeAll12() {
// matching 25 + 25 buys with 75 - 50 shares left over
  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();

  orders.add(new StockExchange.Order("GOOG",(short)29950,75,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)30000,25,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29999,25,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  E.lowestSellOrderPrice = 29950;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();

  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");
  int actualSize = tradeList.size();
  int expectedSize = 2;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradeAll:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  ArrayList<ArrayList<StockExchange.Order>> submittedOrders = E.getSubmittedOrders();
  ArrayList<StockExchange.Order> actualOrderList = submittedOrders.get(29950);
  StockExchange.Order actualOrder = actualOrderList.get(0);

  StockExchange.Order GOOG_sell =  
     new StockExchange.Order("GOOG",(short)29950,25,StockExchange.Order.ordertype.SELL,"Buyer","Schwab");

  if(actualOrder == null || !actualOrder.equals(GOOG_sell)) {
       failFmt("StockExchange.Order tradeAll:\n"+
               "expectedOrder: "+GOOG_sell +"\n"+
               "actualOrder: "+actualOrder+"\n"+"");
  } 
}

// test StockExchange tradesToString

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void StockExchange_tradesToString1() {
// Example from Spec

  StockExchange E = new StockExchange();
  List<StockExchange.Order> orders = new ArrayList<StockExchange.Order>();
  orders.add(new StockExchange.Order("GOOG",(short)30000,75,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("GOOG",(short)29999,25,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));
  orders.add(new StockExchange.Order("FB",(short)10221,100,StockExchange.Order.ordertype.BUY,"ETRADE","Seller"));
  orders.add(new StockExchange.Order("GOOG",(short)29950,50,StockExchange.Order.ordertype.SELL,"Buyer","Schwab"));

  E.lowestSellOrderPrice = 10219;
  E.highestBuyOrderPrice = 30000;

  E.tradeAll(orders);
  MyHashMap<String,ArrayList<StockExchange.Order>> trades = E.getTrades();

  ArrayList<StockExchange.Order> tradeList = trades.get("GOOG");

  int actualSize = tradeList.size();
  int expectedSize = 2;

  if(actualSize != expectedSize) {
       failFmt("StockExchange tradesToString:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  StockExchange.Order GOOGTrade = new StockExchange.Order("GOOG",(short)30000,25,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains = tradeList.contains(GOOGTrade);
  boolean expectedContains = true;

  if(actualContains != expectedContains) {
       failFmt("StockExchange.Order tradesToString:\n"+
               "expectedContains: "+expectedContains +"\n"+
               "actualContains: "+actualContains+"\n"+"");
  } 

  StockExchange.Order GOOGTrade1 = new StockExchange.Order("GOOG",(short)30000,50,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains1 = tradeList.contains(GOOGTrade1);
  boolean expectedContains1 = true;

  if(actualContains1 != expectedContains1) {
       failFmt("StockExchange.Order tradesToString:\n"+
               "expectedContains1: "+expectedContains1 +"\n"+
               "actualContains1: "+actualContains1+"\n"+"");
  }

  tradeList = trades.get("FB");

  int actualSize1 = tradeList.size();
  int expectedSize1 = 1;

  if(actualSize1 != expectedSize1) {
       failFmt("StockExchange tradesToString:\n"+
               "expectedSize1: "+expectedSize1 +"\n"+
               "actualSize1: "+actualSize1+"\n"+"");
  }

  StockExchange.Order FBTrade = new StockExchange.Order("FB",(short)10219,100,StockExchange.Order.ordertype.TRADE,"ETRADE","Schwab");
  boolean actualContains2 = tradeList.contains(FBTrade);
  boolean expectedContains2 = true;

  if(actualContains2 != expectedContains2) {
       failFmt("StockExchange.Order tradesToString:\n"+
               "expectedContains2: "+expectedContains2 +"\n"+
               "actualContains2: "+actualContains2+"\n"+"");
  } 

  // ignore white space
  String actualString = E.tradesToString().replaceAll("\\s+","");
  String expectedString =   "Symbol:FB" + "\n"   + "FB,TRADE,10219,100,ETRADE,Schwab" + "\n"
    + "Symbol:GOOG" + "\n"  + "GOOG,TRADE,30000,25,ETRADE,Schwab" + "\n" 
    + "GOOG,TRADE,30000,50,ETRADE,Schwab" + "\n";  // last line ends with println()
  expectedString = expectedString.replaceAll("\\s+","");

  if(!actualString.equals(expectedString)) {
       failFmt("StockExchange.Order tradesToString:\n"+
               "expectedString:"+ "\n" + expectedString +"\n"+
               "actualString: "+ "\n" + actualString+"\n"+"");
  } 
}

// utility functions

  static String printArray(Object[] array) {
		StringBuilder B = new StringBuilder();
		B.append("[ ");
		for(Object o: array)
			B.append(o + " ");
		B.append("]");
		return B.toString();
  }

  public static void failFmt(String fmt, Object... args){
    fail(String.format(fmt,args));
  }

  class Foo implements Comparable<Foo> {
    int x;
    int hc;
    Foo(int value, int hashCode) {this.x=value; this.hc = hashCode;}
  	 public int hashCode() {return hc;}
    public int compareTo(Foo other) {
		return x - other.x;
    }
    public boolean equals(Object other) {
      if (this == other) return true;
      if (!(other instanceof Foo)) return false;
      Foo that = (Foo) other; 
      return this.x == that.x;
    }
    public String toString() { return new Integer(x).toString();}
  }
}

