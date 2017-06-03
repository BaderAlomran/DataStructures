// CHANGELOG: 

// Tests for MyHashTable.

/* To run them on the command line, make sure that the junit-310.jar
   is in the project directory.
 
   demo$ javac -cp .:junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .:junit-cs310.jar MyHashTableTests   # run tests
 
   On Windows replace : with ; (colon with semicolon)
   demo$ javac -cp .;junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .;junit-cs310.jar MyHashTableTests   # run tests
*/

import org.junit.*;
import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class MyHashTableTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("MyHashTableTests");
  }

  ////////////////////////////////////////////////////////////////////////////////
  // NEW TESTS Day Nov XX 00:00:0 EDT 2015 
  // @Test(timeout=1000,expected=SomeException.class)


// test MyHashTable.constructors

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_construct1() {
// test default capacity
  MyHashTable T = new MyHashTable();
  Object[] table = T.getTable();
  int actualCapacity = table.length;
  int expectedCapacity = 101; //default

  if(actualCapacity != expectedCapacity) {
       failFmt("MyHashTable constructor:\n"+
               "expectedCapacity: "+expectedCapacity +"\n"+
               "actualCapacity: "+actualCapacity+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_construct2() {
// test size initially 0
  MyHashTable T = new MyHashTable();
  Object[] table = T.getTable();
  int actualSize = T.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("MyHashTable constructor:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_construct3() {
// test begin marker links
  MyHashTable T = new MyHashTable();
  MyHashTable.MyListNode beginMarker = T.beginMarker;
  MyHashTable.MyListNode endMarker = T.endMarker;

  if(beginMarker.next != endMarker) {
       failFmt("MyHashTable constructor:\n"+
               "beginMarker.next: != endMarker\n");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_construct4() {
// test end marker links
  MyHashTable T = new MyHashTable(2);
  Object[] table = T.getTable();
  MyHashTable.MyListNode beginMarker = T.beginMarker;
  MyHashTable.MyListNode endMarker = T.endMarker;

  if(endMarker.prev != beginMarker) {
       failFmt("MyHashTable constructor:\n"+
               "endMarker.prev: != beginMarker\n");
  }
  }

// test MyHashTable.MyListNode

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode1() {
// test hashCode
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

  Foo f1 = new Foo(1,1);
  MyHashTable.MyListNode N = new MyHashTable.MyListNode (f1,null,null);
  int actualValue = N.hashCode();
  int expectedValue = 1;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.hashCode:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode2() {
// test equals - true
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(1,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  boolean actualValue = N1.equals(N2);
  boolean expectedValue = true;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.equals:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode3() {
// test equals - false
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  boolean actualValue = N1.equals(N2);
  boolean expectedValue = false;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.equals:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode4() {
// test isEqual - true
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(1,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  boolean actualValue = N1.isEqual(N1,N2);
  boolean expectedValue = true;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.isEqual:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode5() {
// test isEqual - false
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  boolean actualValue = N1.isEqual(N1,N2);
  boolean expectedValue = false;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.isEqual:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode6() {
// test isEqual - false
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

  Foo f1 = new Foo(1,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  boolean actualValue = N1.isEqual(N1,null);
  boolean expectedValue = false;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.isEqual:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode7() {
// test isEqual - false
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

  Foo f1 = new Foo(1,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  boolean actualValue = N1.isEqual(null,N1);
  boolean expectedValue = false;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.isEqual:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode8() {
// test compareTo : 0
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(1,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  int actualValue = N1.compareTo(N2);
  int expectedValue = 0;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.compareTo:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode9() {
// test compareTO : -1
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  int actualValue = N1.compareTo(N2);
  int expectedValue = -1;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.compareTo:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_MyListNode10() {
// test compareTo : 1
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(0,1);
  MyHashTable.MyListNode N1 = new MyHashTable.MyListNode (f1,null,null);
  MyHashTable.MyListNode N2 = new MyHashTable.MyListNode (f2,null,null);
  int actualValue = N1.compareTo(N2);
  int expectedValue = 1;
  if(actualValue != expectedValue) {
       failFmt("MyHashTable.MyListNode.compareTo:\n"+
               "expectedValue: "+expectedValue +"\n"+
               "actualValue: "+actualValue+"\n"+"");
  }
  }
 

// Test MyHashTable.insert

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insert1() {
// insert into tmepty table
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); // both hash to 1
  T.insert(f2);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable insert:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MyHashTable insert:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insert2() {
// insert two elements - both hash to 1
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); // both hash to 1
  Foo f3 = new Foo(3,1); // both hash to 1
  T.insert(f2);
  T.insert(f3);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 2;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable insert:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MyHashTable insert:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  Comparable actualLastValue1 = current.getLast();
  MyHashTable.MyListNode expectedLastValue1 = new MyHashTable.MyListNode(f3,null,null);
  if (actualLastValue1.compareTo(expectedLastValue1)!=0) {
      failFmt("MyHashTable insert:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
  }

}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insert3() {
// insert 2 elements with different hash values
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
  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); //  hash to 1
  Foo f3 = new Foo(3,3); //  hash to 3
  T.insert(f2);
  T.insert(f3);

  Object[] table = T.getTable();
  int hashValf2 = f2.hashCode( ) % 3; if( hashValf2 < 0 ) hashValf2 += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashValf2];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable insert:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MyHashTable insert:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  int hashValf3 = f3.hashCode( ) % 3; if( hashValf3 < 0 ) hashValf3 += 3;
  ChainedArrays C_0 = (ChainedArrays) table[hashValf3];
  current = C_0.getNode(0);

  int actualArraySize2 = current.getArraySize();
  int expectedArraySize2 = 1;

  if(actualArraySize2 != expectedArraySize2) {
       failFmt("MyHashTable insert:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
  }
  Comparable actualLastValue1 = current.getLast();
  MyHashTable.MyListNode expectedLastValue1 = new MyHashTable.MyListNode(f3,null,null);
  if (actualLastValue1.compareTo(expectedLastValue1)!=0) {
      failFmt("MyHashTable insert:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insert4() {
// insert null throws exception 
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  boolean thrown = false;
  try {T.insert(null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("gMyHashTable insert:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
    }
}

// test MyHashTable.clear
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_clear1() {
// test MyHashTable.clear : doesn't change capacity
  MyHashTable T = new MyHashTable();
  T.insert(1);
  T.clear();
  Object[] table = T.getTable();
  int actualCapacity = table.length;
  int expectedCapacity = 101; //default

  if(actualCapacity != expectedCapacity) {
       failFmt("MyHashTable clear:\n"+
               "expectedCapacity: "+expectedCapacity +"\n"+
               "actualCapacity: "+actualCapacity+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_clear2() {
// test clear - reset size
  MyHashTable T = new MyHashTable();
  Object[] table = T.getTable();
  T.insert(1);
  T.clear();
  int actualSize = T.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("MyHashTable clear:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_clear3() {
// test clear - beginMarker links
  MyHashTable T = new MyHashTable();
  MyHashTable.MyListNode beginMarker = T.beginMarker;
  MyHashTable.MyListNode endMarker = T.endMarker;

  if(beginMarker.next != endMarker) {
       failFmt("MyHashTable clear:\n"+
               "beginMarker.next: != endMarker\n");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_clear4() {
// test clear - endMarker links
  MyHashTable T = new MyHashTable(2);
  Object[] table = T.getTable();
  T.insert(1);
  T.clear();
  MyHashTable.MyListNode beginMarker = T.beginMarker;
  MyHashTable.MyListNode endMarker = T.endMarker;

  if(endMarker.prev != beginMarker) {
       failFmt("MyHashTable clear:\n"+
               "endMarker.prev: != beginMarker\n");
  }
  }
*/
// test MyHashTable remove
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_remove1() {
// insert item and remove it
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); // both hash to 1
  T.insert(f2);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MyHashTable remove:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  T.remove(f2);

  int actualSize = T.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("MyHashTable remove:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
}

// test MyHashTable remove
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_remove2() {
// insert 2 items and remove 1
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); //  hash to 1
  Foo f3 = new Foo(3,1); //  hash to 1
  T.insert(f2);
  T.insert(f3);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 2;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MyHashTable remove:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  T.remove(f2);
  C_1 = (ChainedArrays) table[hashVal];
  current = C_1.getNode(0);

  int actualArraySize2 = current.getArraySize();
  int expectedArraySize2 = 1;

  if(actualArraySize2 != expectedArraySize2) {
       failFmt("MyHashTable remove:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_remove3() {
// remove null throws excpetion
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  boolean thrown = false;
  T.insert(1);
  try {T.remove(null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("gMyHashTable remove:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
    }
}
*/
// test MyHashTable.contains
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_contains1() {
// insert(x) and check contains(x)
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); //  hash to 1
  T.insert(f2);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable contains:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MMyHashTable contains:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  boolean actualValue = T.contains(f2);
  boolean expectedValue = true;

  if (actualValue != expectedValue) {
      failFmt("MyHashTable contains:\n"+
               "expectedValue: " + expectedValue +"\n"+
               "actualValue: " + actualValue + "");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_contains2() {
// insert(x) but contains(y) - false
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); //  hash to 1
  Foo f3 = new Foo(3,1); //  hash to 1
  T.insert(f2);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable contains:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MMyHashTable contains:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  boolean actualValue = T.contains(f3);
  boolean expectedValue = false;

  if (actualValue != expectedValue) {
      failFmt("MyHashTable contains:\n"+
               "expectedValue: " + expectedValue +"\n"+
               "actualValue: " + actualValue + "");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_contains3() {
// contains null throws exception
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  boolean thrown = false;
  T.insert(1);
  try {T.contains(null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("gMyHashTable contains:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
    }
}
*/
// test MyHashTable.getMatch
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_getMatch1() {
// insert(x) getMatch(x)
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

  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); //  hash to 1
  T.insert(f2);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable contains:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MMyHashTable contains:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  Foo actualValue = T.getMatch(f2);
  Foo expectedValue = f2;

  if (actualValue.compareTo(expectedValue) != 0) {
      failFmt("MyHashTable getMatch:\n"+
               "expectedValue: " + expectedValue +"\n"+
               "actualValue: " + actualValue + "");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_getMatch2() {
// insert(x) getMAtch(y) - false
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
  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); // both hash to 1
  Foo f3 = new Foo(3,1);
  T.insert(f2);
  Object[] table = T.getTable();
  int hashVal = f2.hashCode( ) % 3; if( hashVal < 0 ) hashVal += 3;
  ChainedArrays C_1 = (ChainedArrays) table[hashVal];
  ChainedArrays.ArrayNode current = C_1.getNode(0);

  int actualArraySize1 = current.getArraySize();
  int expectedArraySize1 = 1;

  if(actualArraySize1 != expectedArraySize1) {
       failFmt("MyHashTable contains:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
  }

  Comparable actualFirstValue1 = current.getFirst();
  MyHashTable.MyListNode expectedFirstValue1 = new MyHashTable.MyListNode(f2,null,null);
  if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
      failFmt("MMyHashTable contains:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
  }

  Foo actualValue = T.getMatch(f3);
  Foo expectedValue = null;

  if (actualValue != expectedValue) {
      failFmt("MyHashTable getMatch:\n"+
               "expectedValue: " + expectedValue +"\n"+
               "actualValue: " + actualValue + "");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_getMatch4() {
// getMatch null is false
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  boolean thrown = false;
  T.insert(1);
  try {T.getMatch(null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("gMyHashTable getMatch:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
    }
}
*/
// Test MyHashTable.tableToString
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_tableToString1() {
// toString : ignore spaces
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
  MyHashTable<Foo> T = new MyHashTable<Foo>(3);
  Foo f2 = new Foo(2,1); // both hash to 1
  Foo f3 = new Foo(3,3);
  T.insert(f2);
  T.insert(f3);

  String actualString = T.tableToString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
  String expectedString = new String("Table:\n0:|3|\n1:|2|\n2:").replaceAll("\\s+","");

  if(actualString.compareTo(expectedString)!=0) {
       failFmt("MyHashTable toString:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  }
}
*/
// test MyHashTable isEmpty
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_isEmpty1() {
// isEmpty on empty table - true
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);

  boolean actual = T.isEmpty();
  boolean expected = true;
  if(actual != expected) {
       failFmt("MyHashTable isEmpty:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_isEmpty2() {
// insert(x); isEmpty is false
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  T.insert(1);
  boolean actual = T.isEmpty();
  boolean expected = false;
  if(actual != expected) {
       failFmt("MyHashTable isEmpty:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
}
*/
// test MyHashTable size
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_size1() {
// size of empty table - 0
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  int actual = T.size();
  int expected = 0;
  if(actual != expected) {
       failFmt("MyHashTable size:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_size2() {
// insert(1); size is 1
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  T.insert(1);
  int actual = T.size();
  int expected = 1;
  if(actual != expected) {
       failFmt("MyHashTable size:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
}

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_size3() {
// insert(x); remove(x); isEmpty is true.
  MyHashTable<Integer> T = new MyHashTable<Integer>(3);
  T.insert(1);
  T.remove(1);
  int actual = T.size();
  int expected = 0;
  if(actual != expected) {
       failFmt("MyHashTable size:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
}
*/
// test MyHashTable.insertListNodeAfter
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insertListNodeAfter1() {
// build f1 --> f2
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable T = new MyHashTable(3);
  MyHashTable.MyListNode returedNode = T.insertListNodeAfter(T.beginMarker,f1);
  T.insertListNodeAfter(returedNode,f2);
  Comparable actualFirstFoo = T.beginMarker.next.data;
  Comparable expectedFirstFoo = f1;
  if(actualFirstFoo.compareTo(expectedFirstFoo) != 0) {
       failFmt("MyHashTable insertListNodeAfter:\n"+
               "expectedFirstFoo: "+expectedFirstFoo +"\n"+
               "actualFirstFoo: "+actualFirstFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualFirstFooPrev = T.beginMarker.next.prev;
  MyHashTable.MyListNode expectedFirstFooPrev = T.beginMarker;
  if(actualFirstFooPrev != expectedFirstFooPrev) {
       failFmt("MyHashTable insertListNodeAfter:\n"+
               "expectedFirstFooPrev: "+expectedFirstFooPrev +"\n"+
               "actualFirstFooPrev: "+actualFirstFooPrev+"\n"+"");
  }

  Comparable actualSecondFoo = T.beginMarker.next.next.data;
  Comparable expectedSecondFoo = f2;
  if(actualSecondFoo.compareTo(expectedSecondFoo) != 0) {
       failFmt("MyHashTable insertListNodeAfter:\n"+
               "expectedSecondFoo: "+expectedSecondFoo +"\n"+
               "actualSecondFoo: "+actualSecondFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualSecondFooPrev = T.beginMarker.next.next.prev;
  MyHashTable.MyListNode expectedSecondFooPrev = T.beginMarker.next;
  if(!actualSecondFooPrev.equals(expectedSecondFooPrev)) {
       failFmt("MyHashTable insertListNodeAfter:\n"+
               "expectedSecondFooPrev: "+expectedSecondFooPrev +"\n"+
               "actualSecondFooPrev: "+actualSecondFooPrev+"\n"+"");
  }

  Comparable actualLastNode = T.beginMarker.next.next.next;
  Comparable expectedLastNode = T.endMarker;
  if(actualLastNode != expectedLastNode) {
       failFmt("MyHashTable insertListNodeAfter:\n"+
               "expectedLastNode: "+expectedLastNode +"\n"+
               "actualLastNode: "+actualLastNode+"\n"+"");
  }
  }

// test MyHashTable insertListNodeBefore

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insertListNodeBefore1() {
// build f1 --> f2
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable T = new MyHashTable(3);
  MyHashTable.MyListNode returedNode = T.insertListNodeBefore(T.endMarker,f2);
  T.insertListNodeBefore(returedNode,f1);
  Comparable actualFirstFoo = T.beginMarker.next.data;
  Comparable expectedFirstFoo = f1;
  if(actualFirstFoo.compareTo(expectedFirstFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFoo: "+expectedFirstFoo +"\n"+
               "actualFirstFoo: "+actualFirstFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualFirstFooPrev = T.beginMarker.next.prev;
  MyHashTable.MyListNode expectedFirstFooPrev = T.beginMarker;
  if(actualFirstFooPrev != expectedFirstFooPrev) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFooPrev: "+expectedFirstFooPrev +"\n"+
               "actualFirstFooPrev: "+actualFirstFooPrev+"\n"+"");
  }

  Comparable actualSecondFoo = T.beginMarker.next.next.data;
  Comparable expectedSecondFoo = f2;
  if(actualSecondFoo.compareTo(expectedSecondFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFoo: "+expectedSecondFoo +"\n"+
               "actualSecondFoo: "+actualSecondFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualSecondFooPrev = T.beginMarker.next.next.prev;
  MyHashTable.MyListNode expectedSecondFooPrev = T.beginMarker.next;
  if(!actualSecondFooPrev.equals(expectedSecondFooPrev)) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFooPrev: "+expectedSecondFooPrev +"\n"+
               "actualSecondFooPrev: "+actualSecondFooPrev+"\n"+"");
  }

  Comparable actualLastNode = T.beginMarker.next.next.next;
  Comparable expectedLastNode = T.endMarker;
  if(actualLastNode != expectedLastNode) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedLastNode: "+expectedLastNode +"\n"+
               "actualLastNode: "+actualLastNode+"\n"+"");
  }
  }

// test MyHashTable removeListNode

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_removeListNode1() {
// build begin --> f1 --> end; remove f1 ==> begin --> end
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

  Foo f1 = new Foo(1,1);
  MyHashTable T = new MyHashTable(3);
  MyHashTable.MyListNode returedNode = T.insertListNodeAfter(T.beginMarker,f1);
  T.removeListNode(returedNode);

  MyHashTable.MyListNode beginMarker = T.beginMarker;
  MyHashTable.MyListNode endMarker = T.endMarker;

  if(beginMarker.next != endMarker) {
       failFmt("MyHashTable removeListNode:\n"+
               "beginMarker.next: != endMarker\n");
  }

  if(endMarker.prev != beginMarker) {
       failFmt("MyHashTable removeListNode:\n"+
               "endMarker.prev != beginMarker\n");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_listNodesToString1() {
 // test displayListNodes: 1 --> 2 outputs "1, 2"
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable.MyListNode returedNode = T.insertListNodeAfter(T.beginMarker,f1);
  MyHashTable T = new MyHashTable(3);
  T.insertListNodeAfter(returedNode,f2);
  // 1 --> 2
  String actualString = T.listNodesToString().replaceAll("\\s+","");
  String expectedString = new String("1, 2").replaceAll("\\s+","");
  if(!actualString.equals(expectedString)) {
       failFmt("MyHashTable listNodesToString:\n"+
               "expectedString: "+expectedString +"\n"+
               "actualString: "+actualString+"\n"+"");
  }
  }

// Test MyHashTable insert + remove + linked lists

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insertremoveLL1() {
// insert(f1); insert(f2) ==> begin --> f1 --> f2 --> end
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  MyHashTable T = new MyHashTable(3);
  T.insert(f1);
  T.insert(f2);

  Comparable actualFirstFoo = T.beginMarker.next.data;
  Comparable expectedFirstFoo = f1;
  if(actualFirstFoo.compareTo(expectedFirstFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFoo: "+expectedFirstFoo +"\n"+
               "actualFirstFoo: "+actualFirstFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualFirstFooPrev = T.beginMarker.next.prev;
  MyHashTable.MyListNode expectedFirstFooPrev = T.beginMarker;
  if(actualFirstFooPrev != expectedFirstFooPrev) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFooPrev: "+expectedFirstFooPrev +"\n"+
               "actualFirstFooPrev: "+actualFirstFooPrev+"\n"+"");
  }

  Comparable actualSecondFoo = T.beginMarker.next.next.data;
  Comparable expectedSecondFoo = f2;
  if(actualSecondFoo.compareTo(expectedSecondFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFoo: "+expectedSecondFoo +"\n"+
               "actualSecondFoo: "+actualSecondFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualSecondFooPrev = T.beginMarker.next.next.prev;
  MyHashTable.MyListNode expectedSecondFooPrev = T.beginMarker.next;
  if(!actualSecondFooPrev.equals(expectedSecondFooPrev)) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFooPrev: "+expectedSecondFooPrev +"\n"+
               "actualSecondFooPrev: "+actualSecondFooPrev+"\n"+"");
  }

  Comparable actualLastNode = T.beginMarker.next.next.next;
  Comparable expectedLastNode = T.endMarker;
  if(actualLastNode != expectedLastNode) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedLastNode: "+expectedLastNode +"\n"+
               "actualLastNode: "+actualLastNode+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insertremoveLL2() {
// insert(f1; insert(f2); insert(f3); remove(f3) ==> begin --> f1 --> f2 --> end
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  Foo f3 = new Foo(3,1);

  MyHashTable T = new MyHashTable(3);
  T.insert(f1);
  T.insert(f2);
  T.insert(f3);
  T.remove(f3);

  Comparable actualFirstFoo = T.beginMarker.next.data;
  Comparable expectedFirstFoo = f1;
  if(actualFirstFoo.compareTo(expectedFirstFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFoo: "+expectedFirstFoo +"\n"+
               "actualFirstFoo: "+actualFirstFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualFirstFooPrev = T.beginMarker.next.prev;
  MyHashTable.MyListNode expectedFirstFooPrev = T.beginMarker;
  if(actualFirstFooPrev != expectedFirstFooPrev) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFooPrev: "+expectedFirstFooPrev +"\n"+
               "actualFirstFooPrev: "+actualFirstFooPrev+"\n"+"");
  }

  Comparable actualSecondFoo = T.beginMarker.next.next.data;
  Comparable expectedSecondFoo = f2;
  if(actualSecondFoo.compareTo(expectedSecondFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFoo: "+expectedSecondFoo +"\n"+
               "actualSecondFoo: "+actualSecondFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualSecondFooPrev = T.beginMarker.next.next.prev;
  MyHashTable.MyListNode expectedSecondFooPrev = T.beginMarker.next;
  if(!actualSecondFooPrev.equals(expectedSecondFooPrev)) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFooPrev: "+expectedSecondFooPrev +"\n"+
               "actualSecondFooPrev: "+actualSecondFooPrev+"\n"+"");
  }

  Comparable actualLastNode = T.beginMarker.next.next.next;
  Comparable expectedLastNode = T.endMarker;
  if(actualLastNode != expectedLastNode) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedLastNode: "+expectedLastNode +"\n"+
               "actualLastNode: "+actualLastNode+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insertremoveLL3() {
// same as preceding only begin --> f1 --> f3 --> end
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  Foo f3 = new Foo(3,1);

  MyHashTable T = new MyHashTable(3);
  T.insert(f1);
  T.insert(f2);
  T.insert(f3);
  T.remove(f2);

  Comparable actualFirstFoo = T.beginMarker.next.data;
  Comparable expectedFirstFoo = f1;
  if(actualFirstFoo.compareTo(expectedFirstFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFoo: "+expectedFirstFoo +"\n"+
               "actualFirstFoo: "+actualFirstFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualFirstFooPrev = T.beginMarker.next.prev;
  MyHashTable.MyListNode expectedFirstFooPrev = T.beginMarker;
  if(actualFirstFooPrev != expectedFirstFooPrev) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFooPrev: "+expectedFirstFooPrev +"\n"+
               "actualFirstFooPrev: "+actualFirstFooPrev+"\n"+"");
  }

  Comparable actualSecondFoo = T.beginMarker.next.next.data;
  Comparable expectedSecondFoo = f3;
  if(actualSecondFoo.compareTo(expectedSecondFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFoo: "+expectedSecondFoo +"\n"+
               "actualSecondFoo: "+actualSecondFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualSecondFooPrev = T.beginMarker.next.next.prev;
  MyHashTable.MyListNode expectedSecondFooPrev = T.beginMarker.next;
  if(!actualSecondFooPrev.equals(expectedSecondFooPrev)) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFooPrev: "+expectedSecondFooPrev +"\n"+
               "actualSecondFooPrev: "+actualSecondFooPrev+"\n"+"");
  }

  Comparable actualLastNode = T.beginMarker.next.next.next;
  Comparable expectedLastNode = T.endMarker;
  if(actualLastNode != expectedLastNode) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedLastNode: "+expectedLastNode +"\n"+
               "actualLastNode: "+actualLastNode+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_insertremoveLL4() {
// same as preceding only begin --> f2 --> f3 --> end
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

  Foo f1 = new Foo(1,1);
  Foo f2 = new Foo(2,1);
  Foo f3 = new Foo(3,1);

  MyHashTable T = new MyHashTable(3);
  T.insert(f1);
  T.insert(f2);
  T.insert(f3);
  T.remove(f1);

  Comparable actualFirstFoo = T.beginMarker.next.data;
  Comparable expectedFirstFoo = f2;
  if(actualFirstFoo.compareTo(expectedFirstFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFoo: "+expectedFirstFoo +"\n"+
               "actualFirstFoo: "+actualFirstFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualFirstFooPrev = T.beginMarker.next.prev;
  MyHashTable.MyListNode expectedFirstFooPrev = T.beginMarker;
  if(actualFirstFooPrev != expectedFirstFooPrev) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedFirstFooPrev: "+expectedFirstFooPrev +"\n"+
               "actualFirstFooPrev: "+actualFirstFooPrev+"\n"+"");
  }

  Comparable actualSecondFoo = T.beginMarker.next.next.data;
  Comparable expectedSecondFoo = f3;
  if(actualSecondFoo.compareTo(expectedSecondFoo) != 0) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFoo: "+expectedSecondFoo +"\n"+
               "actualSecondFoo: "+actualSecondFoo+"\n"+"");
  }

  MyHashTable.MyListNode actualSecondFooPrev = T.beginMarker.next.next.prev;
  MyHashTable.MyListNode expectedSecondFooPrev = T.beginMarker.next;
  if(!actualSecondFooPrev.equals(expectedSecondFooPrev)) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedSecondFooPrev: "+expectedSecondFooPrev +"\n"+
               "actualSecondFooPrev: "+actualSecondFooPrev+"\n"+"");
  }

  Comparable actualLastNode = T.beginMarker.next.next.next;
  Comparable expectedLastNode = T.endMarker;
  if(actualLastNode != expectedLastNode) {
       failFmt("MyHashTable insertListNodeBefore:\n"+
               "expectedLastNode: "+expectedLastNode +"\n"+
               "actualLastNode: "+actualLastNode+"\n"+"");
  }
  }
*/
  // test MyHashTable iterator
/*
@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_iterator1() {
// iterate over empty table
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

   MyHashTable<Foo> T = new MyHashTable<Foo>(3);
	Iterator<Foo> i = T.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = false;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_iterator2() {
// iterate over f3 --> f2 --> f1; note: iterate uses insertion order
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

   MyHashTable<Foo> T = new MyHashTable<Foo>(3);

   Foo f1 = new Foo(1,0);
   Foo f2 = new Foo(2,1);
   Foo f3 = new Foo(3,2);
   T.insert(f3);
   T.insert(f2);
   T.insert(f1);

	Iterator<Foo> i = T.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Foo actualNext1 = i.next();
	Foo expectedNext1 = f3;
   if (actualNext1.compareTo(expectedNext1) != 0) {
       failFmt("MyHashTable iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = true;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   Foo actualNext2 = i.next();
	Foo expectedNext2 = f2;
   if (actualNext2.compareTo(expectedNext2) != 0) {
       failFmt("MyHashTable iterator:\n"+
               "expectedNext2: " + expectedNext2 +"\n"+
               "actualNext2: " + actualNext2 + "");
   }

   boolean actualHasNext3 = i.hasNext();
	boolean expectedHasNext3 = true;
   if (actualHasNext3 != expectedHasNext3) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext3: " + expectedHasNext3 +"\n"+
               "actualHasNext3: " + actualHasNext3 + "");
   }
   Foo actualNext3 = i.next();
	Foo expectedNext3 = f1;
   if (actualNext3.compareTo(expectedNext3) != 0) {
       failFmt("MyHashTable iterator:\n"+
               "expectedNext3: " + expectedNext3 +"\n"+
               "actualNext3: " + actualNext3 + "");
   }

   boolean actualHasNext4 = i.hasNext();
	boolean expectedHasNext4 = false;
   if (actualHasNext4 != expectedHasNext4) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext4: " + expectedHasNext4 +"\n"+
               "actualHasNext4: " + actualHasNext4 + "");
   }
   }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashTable_iterator3() {
// iterate over a single element 
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

   MyHashTable<Foo> T = new MyHashTable<Foo>(3);

   Foo f1 = new Foo(1,0);
   T.insert(f1);

	Iterator<Foo> i = T.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Foo actualNext1 = i.next();
	Foo expectedNext1 = f1;
   if (actualNext1.compareTo(expectedNext1) != 0) {
       failFmt("MyHashTable iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = false;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("MyHashTable iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   }
*/
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
}

