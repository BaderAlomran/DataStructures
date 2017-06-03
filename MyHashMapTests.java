// CHANGELOG: 

// Tests for MyHashMap.

/* To run them on the command line, make sure that the junit-310.jar
   is in the project directory.
 
   demo$ javac -cp .:junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .:junit-cs310.jar MyHashMapTests   # run tests
 
   On Windows replace : with ; (colon with semicolon)
   demo$ javac -cp .;junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .;junit-cs310.jar MyHashMapTests   # run tests
*/

import org.junit.*;
import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class MyHashMapTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("MyHashMapTests");
  }

  ////////////////////////////////////////////////////////////////////////////////
  // NEW TESTS Day Nov XX 00:00:0 EDT 2015 
  // @Test(timeout=1000,expected=SomeException.class)


// test MyHashMap constructor

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_construct1() {
// test initial size 0
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  int actualSize = M.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("MyHashMap constructor:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  }

// test MyHashMap put

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_put1() {
// test put
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  int actualSize = M.getItems().size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("MyHashMap put:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_put2() {
// test put null
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  boolean thrown = false;
  try {M.put(f1,null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("MyHashTable put:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_put3() {
// test put null
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  boolean thrown = false;
  try {M.put(null,"f1");}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("MyHashTable put:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
  }
  }

// test MyHashMap get

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_get1() {
// test get return non-null
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  String actual = M.get(f1);
  String expected = "f1";
  if(actual != expected) {
       failFmt("MyHashMap get:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_get2() {
// test get return null
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  Foo f2 = new Foo(2,2);
  String actual = M.get(f2);
  String expected = null;
  if(actual != expected) {
       failFmt("MyHashMap get:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_get3() {
// test get null
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  boolean thrown = false;
  try {M.get(null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("MyHashTable get:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_get4() {
// test get null
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  boolean thrown = false;
  try {M.get(null);}
  catch (IllegalArgumentException e) {
    thrown = true;
  }
  if(!thrown) {
       failFmt("MyHashTable get:\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+" IllegalArgumentException not thrown"+"\n"+"");
  }
  }

// test MyHashMap.Entry

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry1() {
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  int actualhashCode = e1.hashCode();
  int expectedhashCode = 1;
  if(actualhashCode != expectedhashCode) {
       failFmt("MMyHashMap.Entry hashCode:\n"+
               "expectedhashCode: "+expectedhashCode +"\n"+
               "actualhashCode: "+actualhashCode+"\n"+"");
  } 
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry2() {
// test equals true
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  boolean actualEquals = e1.equals(e1);
  boolean expectedEquals = true;
  if(actualEquals != expectedEquals) {
       failFmt("MyHashMap.Entry equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry3() {
// test equals false
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");
  Foo f2 = new Foo(2,1);
  MyHashMap.Entry e2 = new MyHashMap.Entry(f2,"f2");

  boolean actualEquals = e1.equals(e2);
  boolean expectedEquals = false;
  if(actualEquals != expectedEquals) {
       failFmt("MMyHashMap.Entry equals:\n"+
               "expectedEquals: "+expectedEquals +"\n"+
               "actualEquals: "+actualEquals+"\n"+"");
  } 
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry4() {
// test getKey
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  Foo actual = (Foo) e1.getKey();
  Foo expected = f1;
  if(actual != expected) {
       failFmt("MyHashMap.Entry getKey:\n"+
               "expectedEquals: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  } 
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry5() {
// test getValue
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  String actual = (String) e1.getValue();
  String expected = "f1";
  if(actual != expected) {
       failFmt("MyHashMap.Entry getValue:\n"+
               "expectedEquals: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  } 
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry6() {
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  int actual = e1.compareTo(e1);
  int expected = 0;
  if(actual != expected) {
       failFmt("MyHashMap.Entry compareTo:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  } 
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry7() {
// test compareTo: -1
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");
  Foo f2 = new Foo(2,1);
  MyHashMap.Entry e2 = new MyHashMap.Entry(f2,"f2");

  int actual = e1.compareTo(e2);
  int expected = -1;
  if(actual != expected) {
       failFmt("MyHashMap.Entry compareTo:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }  
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry8() {
// test copareTo: 1
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");
  Foo f2 = new Foo(0,1);
  MyHashMap.Entry e2 = new MyHashMap.Entry(f2,"f2");

  int actual = e1.compareTo(e2);
  int expected = 1;
  if(actual != expected) {
       failFmt("MyHashMap.Entry compareTo:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }  
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entry9() {
// test toString "(1, f1)"
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  String actual = e1.toString().replaceAll("\\s+","");
  String expected = "(1, f1)".replaceAll("\\s+","");
  if(!actual.equals(expected)) {
       failFmt("MyHashMap.Entry toString:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }  
  }

// test MyHashMap entrySet

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_entrySet1() {
// test entrySet with Set of 2 Entries - order of entry of 
// underlying hash table is not required/checked
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  Foo f2 = new Foo(2,2);
  M.put(f2,"f2");
  Set s = M.entrySet();

  int actualSize = s.size();
  int expectedSize = 2;
  if(actualSize != expectedSize) {
       failFmt("MyHashMap entrySet:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }

  MyHashMap.Entry e1 = new MyHashMap.Entry(f1,"f1");

  boolean actualcontainsf1 = s.contains(e1);
  boolean expectedcontainsf1 = true;
  if(actualcontainsf1 != expectedcontainsf1) {
       failFmt("MyHashMap entrySet:\n"+
               "expectedcontainsf1: "+expectedcontainsf1 +"\n"+
               "actualcontainsf1: "+actualcontainsf1+"\n"+"");
  }

  MyHashMap.Entry e2 = new MyHashMap.Entry(f2,"f2");

  boolean actualcontainsf2 = s.contains(e1);
  boolean expectedcontainsf2 = true;
  if(actualcontainsf2 != expectedcontainsf2) {
       failFmt("MyHashMap entrySet:\n"+
               "expectedcontainsf2: "+expectedcontainsf2 +"\n"+
               "actualcontainsf2: "+actualcontainsf2+"\n"+"");
  }
  }

// test MyHashMap clear

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_clear1() {
// test initial size 0
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  M.clear();
  
  int actualSize = M.size();
  int expectedSize = 0;

  if(actualSize != expectedSize) {
       failFmt("MyHashMap clear:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  }

// test MyHashMap size

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_size1() {
// test size after put
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  int actualSize = M.size();
  int expectedSize = 1;

  if(actualSize != expectedSize) {
       failFmt("MyHashMap size:\n"+
               "expectedSize: "+expectedSize +"\n"+
               "actualSize: "+actualSize+"\n"+"");
  }
  }

// test MyHashMap isEmpty

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_isEmpty1() {
// test initial isEmpty 0
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  boolean actual = M.isEmpty();
  boolean expected = true;

  if(actual != expected) {
       failFmt("MyHashMap isEmpty:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
  }
  }

@SuppressWarnings("unchecked")
@Test(timeout=1000) public void MyHashMap_isEmpty2() {
// test isEmpty after put
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

  MyHashMap<Foo,String> M = new MyHashMap<Foo,String>();
  Foo f1 = new Foo(1,1);
  M.put(f1,"f1");
  boolean actual = M.isEmpty();
  boolean expected = false;

  if(actual != expected) {
       failFmt("MyHashMap isEmpty:\n"+
               "expected: "+expected +"\n"+
               "actual: "+actual+"\n"+"");
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
}

