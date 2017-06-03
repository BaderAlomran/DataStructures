// CHANGELOG: 

// Tests for ArrayNode and ChainedArrays

/* To run them on the command line, make sure that the junit-310.jar
   is in the project directory.
 
   demo$ javac -cp .:junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .:junit-cs310.jar ArrayNodeChainedArraysTests   # run tests
 
   On Windows replace : with ; (colon with semicolon)
   demo$ javac -cp .;junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .;junit-cs310.jar ArrayNodeChainedArraysTests   # run tests
*/

import org.junit.*;
import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class ArrayNodeChainedArraysTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("ArrayNodeChainedArraysTests");
  }
  

  ////////////////////////////////////////////////////////////////////////////////
  // NEW TESTS Day Nov XX 00:00:0 EDT 2015 
  // @Test(timeout=1000,expected=SomeException.class)


// test ArrayNode.insertedSorted

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted1(){
  // Check insert in sorted order: insert 1 into []
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,1);
  n.insertSorted(new Integer(1));
  Object[] actual = n.getArray();
  Object[] expect = {1};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSorted:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted2(){
  // Check insert in sorted order: insert 4 into [2]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(4));
  Object[] actual = n.getArray();
  Object[] expect = {2,4};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSorted:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted3(){
  // Check insert in sorted order: insert 1 into [2,4]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,3);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(4));
  n.insertSorted(new Integer(1));
  Object[] actual = n.getArray();
  Object[] expect = {1,2,4};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSorted:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted4(){
  // Check insert in sorted order: insert 3 into [1,2,4]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,4);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(4));
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(3));
  Object[] actual = n.getArray();
  Object[] expect = {1,2,3,4};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSorted:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted5(){
  // Check insert in sorted order: insert 5 into [1,2,3,4]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,5);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(4));
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(3));
  n.insertSorted(new Integer(5));
  Object[] actual = n.getArray();
  Object[] expect = {1,2,3,4,5};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSorted:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted6(){
  // Check insert in sorted order: array capcity > size
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,10);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(4));
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(3));
  n.insertSorted(new Integer(5));
  Object[] actual = n.getArray();
  Object[] expect = {1,2,3,4,5,null,null,null,null,null};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSorted:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }

  }

// Test getArraySize

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getArraySize1(){
  // Check getArraySize: on []
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  int actual = n.getArraySize();
  int expect = 0;
    if(actual != expect) {
       failFmt("getArraySize:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getArraySize2(){
  // Check getArraySize: on [1]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  int actual = n.getArraySize();
  int expect = 1;
    if(actual != expect) {
       failFmt("getArraySize:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getArraySize3(){
  // Check getArraySize: on [1,2]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,3);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  int actual = n.getArraySize();
  int expect = 2;
    if(actual != expect) {
       failFmt("getArraySize:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }


// Test ArrayNode.IndexOf

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_indexOf1(){
  // Check indexOf: index of 1 in [1]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,1);
  n.insertSorted(new Integer(1));
  int actual = n.indexOf(1);
  int expect = 0;
    if(n.indexOf(1) != expect) {
       failFmt("indexOf:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_indexOf2(){
  // Check indexOf: index of 2 in [1,2]; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  int actual = n.indexOf(2);
  int expect = 1;
    if(actual != expect) {
       failFmt("indexOf:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_indexOf3(){
  // Check indexOf: index of 0 in [1,2]; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,3);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  int actual = n.indexOf(0);
  int expect = -1; 
  if(actual != expect) {
       failFmt("indexOf:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_indexOf4(){
  // Check indexOf: index of 3 in [1,2]; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,3);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  int actual = n.indexOf(0);
  int expect = -1; 
  if(actual != expect) {
       failFmt("indexOf:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

// test ArrayNode.getFirst

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getFirst1(){
  // Check getFirst: getFirst of [1,2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actual = n.getFirst();
  Integer expect = 1;
  if(actual.compareTo(expect)!= 0) {
       failFmt("getFirst:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getFirst2(){
  // Check getFirst: getFirst of [1]; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  Comparable actual = n.getFirst();
  Integer expect = 1; 
  if(actual.compareTo(expect)!= 0) {
       failFmt("getFirst:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getFirst3(){
  // Check getFirst: getFirst of []; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {Comparable actual = n.getFirst();}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("getFirst:\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }

// test ArrayNode.getLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getLast1(){
  // Check getFirst: getLast of [1,2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actual = n.getLast();
  Integer expect = 2; 
  if(actual.compareTo(expect)!= 0) {
       failFmt("getLast:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getLast2(){
  // Check getFirst: getLast of [1]; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  Comparable actual = n.getLast();
  Integer expect = 1; 
  if(actual.compareTo(expect)!= 0) {
       failFmt("getLast:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_getLast3(){
  // Check getFirst: getLast of []; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {Comparable actual = n.getLast();}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("getLast:\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }

// test ArrayNode.get

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_get1(){
  // Check get: get index 0 in [2,1];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(1));
  Comparable actual = n.get(1);
  Integer expect = 2; 
  if(actual.compareTo(expect)!= 0) {
       failFmt("get:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_get2(){
  // Check get: get index 1 in [1,2]; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,3);
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(1));
  Comparable actual = n.get(1);
  Integer expect = 2; 
  if(actual.compareTo(expect)!= 0) {
       failFmt("get:\n"+
               "Expect: "+expect +"\n"+
               "Actual: "+actual+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_get3(){
  // Check getFirst: get index 0 in []; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {Comparable actual = n.get(0);}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("get:\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }

// test ArrayNode.removeFirst (and also test getArraySize after some removes)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_removeFirst1(){
  // Check : removeFirst for [1,2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.removeFirst();
  Integer expectedValue = 1;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 1;

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("removeFirst:\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("removeFirst:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }
  if (actualArraySize > 0) {
	  Comparable actualArrayElement = n.getFirst();
	  Integer expectedArrayElement = 2;
	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
       failFmt("removeFirst:\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
		}
  }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_removeFirst2(){
  // Check : removeFirst for [2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.removeFirst();
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 0;
  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("removeFirst:\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("removeFirst:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_removeFirst3(){
  // Check removeFirst: removeFirst for []; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {Comparable actual = n.removeFirst();}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("removeFirst:\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }


// test ArrayNode.removeLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_removeLast1(){
  // Check : removeLast for [1,2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.removeLast();
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 1;

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("removeLast:\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("removeLast:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }
  if (actualArraySize>0) {
	  Comparable actualArrayElement = n.getFirst();
	  Integer expectedArrayElement = 1;

	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
   	    failFmt("removeLast:\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
    }
  }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_removeLast2(){
  // Check : removeLast for [2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.removeLast();
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 0;
  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("removeLast:\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("removeLast:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_removeLast3(){
  // Check removeLast: removeLast for []; capacity of array > size of array
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {Comparable actual = n.removeLast();}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("removeLast:\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }

// test ArrayNode.remove(int idx)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_idx1(){
  // Check : remove at position 1 for [1,2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.remove(1); // position 1
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 1;

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("remove(idx):\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }
  if (actualArraySize > 0) {
	  Comparable actualArrayElement = n.getFirst();
	  Integer expectedArrayElement = 1;
	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
		}
  }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_idx2(){
  // Check : remove at position 0 for [2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.remove(0); // position 0
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 0;
  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("remove(idx):\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_idx3(){
  // Check remove at position 1 for [2]; index out of bounds
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  boolean thrown = false;
  try {Comparable actual = n.remove(1);}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("remove(idx):\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_idx4(){
  // Check remove at position -1 for [2]; index out of bounds
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  boolean thrown = false;
  try {Comparable actual = n.remove(-1);}
  catch (IndexOutOfBoundsException e) {thrown = true;}
  if(!thrown) {
       failFmt("remove(idx):\n"+
               "Expect: "+"IndexOutOfBoundsException" +"\n"+
               "Actual: "+" IndexOutOfBoundsException not thrown"+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_idx5(){
  // Check : remove at position 1 [1,2,3];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,4);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(3));
  Comparable actualValue = n.remove(1); // position 1
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 2;

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("remove(idx):\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }
  if (actualArraySize == 2) {
	  Comparable actualArrayElement1= n.getFirst();
	  Integer expectedArrayElement1 = 1;
	  if(actualArrayElement1.compareTo(expectedArrayElement1)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectedArrayElement1: "+expectedArrayElement1 +"\n"+
               "ActualArrayElement1: "+actualArrayElement1+"\n"+"");
	  }
	  Comparable actualArrayElement3 = n.getLast();
	  Integer expectedArrayElement3 = 3;
	  if(actualArrayElement3.compareTo(expectedArrayElement3)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectedArrayElement3: "+expectedArrayElement3 +"\n"+
               "ActualArrayElement3: "+actualArrayElement3+"\n"+"");
		}
  }

  }

// test ArrayNode.remove(U x)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_Ux1(){
  // Check : remove(U x): remove the 2 in [1,2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.remove(new Integer(2));
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 1;

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(U x):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("remove(U x):\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }
  if (actualArraySize > 0) {
	  Comparable actualArrayElement = n.getFirst();
	  Integer expectedArrayElement = 1;
	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
       failFmt("remove(U x):\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
		}
  }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_Ux2(){
  // Check : remove(U x): remove the 2 in [2];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(2));
  Comparable actualValue = n.remove(new Integer(2));
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 0;
  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("remove(idx):\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_Ux3(){
  // Check : remove(U x): remove the 3 in [1,2]; return null since no 3
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  Comparable actual = n.remove(new Integer(3));
  if(actual != null) {
       failFmt("remove(idx):\n"+
               "Expect: "+"null" +"\n"+
               "Actual: "+actual+"\n"+"");
    } 

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_Ux4(){
  // Check : remove(U x): remove the 2 in [1,2,3]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,4);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(3));
  Comparable actualValue = n.remove(new Integer(2)); // position 1
  Integer expectedValue = 2;
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 2;

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
    }
  if(actualArraySize != expectedArraySize) {
       failFmt("remove(idx):\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
    }
  if (actualArraySize == 2) {
	  Comparable actualArrayElement1= n.getFirst();
	  Integer expectedArrayElement1 = 1;
	  if(actualArrayElement1.compareTo(expectedArrayElement1)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectedArrayElement1: "+expectedArrayElement1 +"\n"+
               "ActualArrayElement1: "+actualArrayElement1+"\n"+"");
	  }
	  Comparable actualArrayElement3 = n.getLast();
	  Integer expectedArrayElement3 = 3;
	  if(actualArrayElement3.compareTo(expectedArrayElement3)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectedArrayElement3: "+expectedArrayElement3 +"\n"+
               "ActualArrayElement3: "+actualArrayElement3+"\n"+"");
		}
  }

  }

// test insertSorted(null)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_remove_null1(){
  // Check remove(x) where x is null throws exception
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {Comparable actual = n.remove(null);}
  catch (IllegalArgumentException  e) {thrown = true;}
  if(!thrown) {
       failFmt("remove(null):\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+"IllegalArgumentException not thrown"+"\n"+"");
    }
  }

// test remove(null)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_insertSorted_null1(){
  // Check insertSorted(x) where x is null throws exception
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,2);
  boolean thrown = false;
  try {n.insertSorted(null);}
  catch (IllegalArgumentException  e) {thrown = true;}
  if(!thrown) {
       failFmt("insertSorted(null):\n"+
               "Expect: "+"IllegalArgumentException" +"\n"+
               "Actual: "+"IllegalArgumentException not thrown"+"\n"+"");
    }
  }

// test ArrayNode.toString()

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_toString1(){
  // Check : toString for [1,2,3]
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null,4);
  n.insertSorted(new Integer(1));
  n.insertSorted(new Integer(2));
  n.insertSorted(new Integer(3));
  // Consider "1, 2, 3" and "1,2,3" as passing
  String actualValue = n.toString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
  String expectedValue = "1,2,3"; // 

  if(actualValue.compareTo(expectedValue)!= 0) {
       failFmt("remove(idx):\n"+
               "ExpectValue: "+expectedValue +"\n"+
               "ActualValue: "+actualValue+"\n"+"");
  }
  }

// test ArrayNode convenience constructor

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayNode_convenience_constructor1(){
  // Check : remove at position 1 [1,2,3];
  ChainedArrays.ArrayNode n = new ChainedArrays.ArrayNode(null,null);
  Object[] array = n.getArray();
  int actualDefaultCapacity = array.length;
  int expectedDefaultCapacity = 16;

  if(actualDefaultCapacity != expectedDefaultCapacity) {
       failFmt("remove(idx):\n"+
               "expectedDefaultCapacity: "+expectedDefaultCapacity +"\n"+
               "actualDefaultCapacity: "+actualDefaultCapacity+"\n"+"");
  }
  }

// test ChainedArrays.getNode

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getNode1() {
  // test getNode()
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("getNode:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("getNode:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 1;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("getNode:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 2;
   if (actualLastValue1.compareTo(expectedLastValue1)!=0) {
       failFmt("getNode:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node1 = C.getNode(1);

   int actualArraySize2 = node1.getArraySize();
   int expectedArraySize2 = 2;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("getNode:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Comparable actualFirstValue2 = node1.getFirst();
   Integer expectedFirstValue2 = 3;
   if (actualFirstValue2.compareTo(expectedFirstValue2)!=0) {
       failFmt("getNode:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }

   Comparable actualLastValue2 = node1.getLast();
   Integer expectedLastValue2 = 2;
   if (actualLastValue1.compareTo(expectedLastValue2)!=0) {
       failFmt("getNode:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(2);

   int actualArraySize3 = node2.getArraySize();
   int expectedArraySize3 = 2;

   if(actualArraySize3 != expectedArraySize3) {
       failFmt("getNode:\n"+
               "expectedArraySize3: "+expectedArraySize3 +"\n"+
               "actualArraySize3: "+actualArraySize3+"\n"+"");
   }

   Comparable actualFirstValue3 = node2.getFirst();
   Integer expectedFirstValue3 = 5;
   if (actualFirstValue3.compareTo(expectedFirstValue3)!=0) {
       failFmt("getNode:\n"+
               "expectedFirstValue3: " + expectedFirstValue3 +"\n"+
               "actualFirstValue3: " + actualFirstValue3 + "");
   }

   Comparable actualLastValue3 = node2.getLast();
   Integer expectedLastValue3 = 6;
   if (actualLastValue3.compareTo(expectedLastValue3)!=0) {
       failFmt("getNode:\n"+
               "expectedLastValue3: " + expectedLastValue3 +"\n"+
               "actualLastValue3: " + actualLastValue3 + "");
   }
   }

// test ChainedArrays.getNode( int idx, int lower, int upper )

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getNodeLowerUpper1() {
  // test getNode(idx,lower,upper) in range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("getNode:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0,0,C.nodeCount()-1);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("getNode:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 1;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("getNode:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 2;
   if (actualLastValue1.compareTo(expectedLastValue1)!=0) {
       failFmt("getNode:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node1 = C.getNode(1);

   int actualArraySize2 = node1.getArraySize();
   int expectedArraySize2 = 2;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("getNode:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Comparable actualFirstValue2 = node1.getFirst();
   Integer expectedFirstValue2 = 3;
   if (actualFirstValue2.compareTo(expectedFirstValue2)!=0) {
       failFmt("getNode:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }

   Comparable actualLastValue2 = node1.getLast();
   Integer expectedLastValue2 = 2;
   if (actualLastValue1.compareTo(expectedLastValue2)!=0) {
       failFmt("getNode:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(2);

   int actualArraySize3 = node2.getArraySize();
   int expectedArraySize3 = 2;

   if(actualArraySize3 != expectedArraySize3) {
       failFmt("getNode:\n"+
               "expectedArraySize3: "+expectedArraySize3 +"\n"+
               "actualArraySize3: "+actualArraySize3+"\n"+"");
   }

   Comparable actualFirstValue3 = node2.getFirst();
   Integer expectedFirstValue3 = 5;
   if (actualFirstValue3.compareTo(expectedFirstValue3)!=0) {
       failFmt("getNode:\n"+
               "expectedFirstValue3: " + expectedFirstValue3 +"\n"+
               "actualFirstValue3: " + actualFirstValue3 + "");
   }

   Comparable actualLastValue3 = node2.getLast();
   Integer expectedLastValue3 = 6;
   if (actualLastValue3.compareTo(expectedLastValue3)!=0) {
       failFmt("getNode:\n"+
               "expectedLastValue3: " + expectedLastValue3 +"\n"+
               "actualLastValue3: " + actualLastValue3 + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getNodeLowerUpper2() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("getNode:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
	boolean thrown = false;
   // -1 is out of range
	try {ChainedArrays.ArrayNode current = C.getNode(-1,0,C.nodeCount()-1);}
	catch (IndexOutOfBoundsException e) {thrown=true;}
   if(!thrown) {
       failFmt("removeLast:\n"+
               "Expect: "+"NoSuchElementException" +"\n"+
               "Actual: "+"NoSuchElementException not thrown"+"\n"+"");
   }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getNodeLowerUpper3() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("getNode:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
	boolean thrown = false;
   // nodeCount() is out of range
	try {ChainedArrays.ArrayNode current = C.getNode(0,C.nodeCount(),C.nodeCount()-1);}
	catch (IndexOutOfBoundsException e) {thrown=true;}
   if(!thrown) {
       failFmt("removeLast:\n"+
               "Expect: "+"NoSuchElementException" +"\n"+
               "Actual: "+"NoSuchElementException not thrown"+"\n"+"");
   }
   }


// test ChainedArrays.add (More tests later ... )

/*
If A is empty, then the first data Node is created and linked into 
the list and current is the first data node.

>***************        ***************
* beginMarker *   -->   *  endMarker  *
***************   <--   *************** 


***************        ***************         ***************
* beginMarker *   -->  *             *    -->  *  endMarker  *
***************   <--  ***************    >--  *************** 
                           current
*/

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add1(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   int actualNumberNodes = C.nodeCount();
   int expectedActualNodes = 1;
   ChainedArrays.ArrayNode n = C.getNode(0);
   if (n == null) {
       failFmt("add:\n"+
               "Expect: "+"non-null first data node" +"\n"+
               "Actual: "+"null first data node"+"");
   }
  int actualArraySize = n.getArraySize();
  int expectedArraySize = 1;

  if(actualArraySize != expectedArraySize) {
       failFmt("add:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
  }

  if (actualArraySize == 1) {
	  Comparable actualArrayElement = n.getFirst();
	  Integer expectedArrayElement = 2;
	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
	  }
  }
  }


// test ChainedArrays.insertSortedWithPossibleSplit

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit1() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 1 into [2 ] w/ capacity 2
   // There is a single data node with [2 ]
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   // C is empty
   C.add(1);
   ChainedArrays.ArrayNode n = C.getNode(0);
   C.insertWithPossibleSplit(n,new Integer(2));
   Object[] actual1 = n.getArray();
   Object[] expect1 = {1,2};
    if(!Arrays.deepEquals(actual1,expect1)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect1: "+printArray(expect1) +"\n"+
               "Actual1: "+printArray(actual1)+"\n"+"");
    }
   int actualNodeCount = C.nodeCount();
   int expectedNodeCount = 1;
   if(actualNodeCount != expectedNodeCount) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount: "+expectedNodeCount +"\n"+
               "actualNodeCount: "+actualNodeCount+"\n"+"");
  }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit2() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 2 into [1] w/ capacity 1
   // There is a single data node with [1]. Special case: capacity 1 node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(1);
   C.add(1);
   int actualNodeCount1 = C.nodeCount();
   int expectedNodeCount1 = 1;
   if(actualNodeCount1 != expectedNodeCount1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount1: "+expectedNodeCount1 +"\n"+
               "actualNodeCount1: "+actualNodeCount1+"\n"+"");
  }
   ChainedArrays.ArrayNode current = C.getNode(0);
   C.insertWithPossibleSplit(current,new Integer(2));
   Object[] actual2 = current.getArray();
   Object[] expect2 = {1};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }
   int actualNodeCount2 = C.nodeCount();
   int expectedNodeCount2 = 2;
   if(actualNodeCount2 != expectedNodeCount2) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount2: "+expectedNodeCount2 +"\n"+
               "actualNodeCount2: "+actualNodeCount2+"\n"+"");
   }
   ChainedArrays.ArrayNode next = C.getNode(1);
   Object[] actual3 = next.getArray();
   Object[] expect3 = {2};
    if(!Arrays.deepEquals(actual3,expect3)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect3: "+printArray(expect3) +"\n"+
               "Actual3: "+printArray(actual3)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit3() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 1 into [2] w/ capacity 1
   // There is a single data node with [2]. Special case: capacity 1 node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(1);
   C.add(2);
   int actualNodeCount1 = C.nodeCount();
   int expectedNodeCount1 = 1;
   if(actualNodeCount1 != expectedNodeCount1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount1: "+expectedNodeCount1 +"\n"+
               "actualNodeCount1: "+actualNodeCount1+"\n"+"");
  }
   ChainedArrays.ArrayNode current = C.getNode(0);
   C.insertWithPossibleSplit(current,new Integer(1));
   Object[] actual2 = current.getArray();
   Object[] expect2 = {1};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }
   int actualNodeCount2 = C.nodeCount();
   int expectedNodeCount2 = 2;
   if(actualNodeCount2 != expectedNodeCount2) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount2: "+expectedNodeCount2 +"\n"+
               "actualNodeCount2: "+actualNodeCount2+"\n"+"");
   }
   ChainedArrays.ArrayNode next = C.getNode(1);
   Object[] actual3 = next.getArray();
   Object[] expect3 = {2};
    if(!Arrays.deepEquals(actual3,expect3)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect3: "+printArray(expect3) +"\n"+
               "Actual3: "+printArray(actual3)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit4() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 1 into [2,3] w/ capacity 2
   // There is a single data node with [2,3]. 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   int actualNodeCount1 = C.nodeCount();
   int expectedNodeCount1 = 1;
   if(actualNodeCount1 != expectedNodeCount1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount1: "+expectedNodeCount1 +"\n"+
               "actualNodeCount1: "+actualNodeCount1+"\n"+"");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);
   C.insertWithPossibleSplit(current,new Integer(1));
   int actualNodeCount2 = C.nodeCount();
   int expectedNodeCount2 = 2;
   if(actualNodeCount2 != expectedNodeCount2) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount2: "+expectedNodeCount2 +"\n"+
               "actualNodeCount2: "+actualNodeCount2+"\n"+"");
   }
   current = C.getNode(0);
   Object[] actual2 = current.getArray();
   Object[] expect2 = {1,2};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }
   ChainedArrays.ArrayNode next = C.getNode(1);
   Object[] actual3 = next.getArray();
   Object[] expect3 = {3,null};
    if(!Arrays.deepEquals(actual3,expect3)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect3: "+printArray(expect3) +"\n"+
               "Actual3: "+printArray(actual3)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit5() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 3 into [1,2] w/ capacity 2
   // There is a single data node with [2,3]. 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(1);
   C.add(2);
   int actualNodeCount1 = C.nodeCount();
   int expectedNodeCount1 = 1;
   if(actualNodeCount1 != expectedNodeCount1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount1: "+expectedNodeCount1 +"\n"+
               "actualNodeCount1: "+actualNodeCount1+"\n"+"");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);
   C.insertWithPossibleSplit(current,new Integer(3));
   int actualNodeCount2 = C.nodeCount();
   int expectedNodeCount2 = 2;
   if(actualNodeCount2 != expectedNodeCount2) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount2: "+expectedNodeCount2 +"\n"+
               "actualNodeCount2: "+actualNodeCount2+"\n"+"");
   }
   current = C.getNode(0);
   int actualArraySize = current.getArraySize();
   int expectedArraySize = 1;

   if(actualArraySize != expectedArraySize) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
   }
   if (actualArraySize == 1) {
	  Comparable actualArrayElement = current.getFirst();
	  Integer expectedArrayElement = 1;
	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
	  }
   }
   ChainedArrays.ArrayNode next = C.getNode(1);
   Object[] actual3 = next.getArray();
   Object[] expect3 = {2,3};
    if(!Arrays.deepEquals(actual3,expect3)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect3: "+printArray(expect3) +"\n"+
               "Actual3: "+printArray(actual3)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit6() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 4 into [1,2,3] w/ capacity 3
   // There is a single data node with [2,3]. 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(3);
   C.add(1);
   C.add(2);
   C.add(3);
   int actualNodeCount1 = C.nodeCount();
   int expectedNodeCount1 = 1;
   if(actualNodeCount1 != expectedNodeCount1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount1: "+expectedNodeCount1 +"\n"+
               "actualNodeCount1: "+actualNodeCount1+"\n"+"");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);
   C.insertWithPossibleSplit(current,new Integer(4));
   int actualNodeCount2 = C.nodeCount();
   int expectedNodeCount2 = 2;
   if(actualNodeCount2 != expectedNodeCount2) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount2: "+expectedNodeCount2 +"\n"+
               "actualNodeCount2: "+actualNodeCount2+"\n"+"");
   }
   current = C.getNode(0);
   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "ExpectedArraySize1: "+expectedArraySize1 +"\n"+
               "ActualArrayValue1: "+actualArraySize1+"\n"+"");
   }
   if (actualArraySize1 == 1) {
	  Comparable actualArrayElement1 = current.getFirst();
	  Integer expectedArrayElement1 = 1;
	  if(actualArrayElement1.compareTo(expectedArrayElement1)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement1: "+expectedArrayElement1 +"\n"+
               "ActualArrayElement1: "+actualArrayElement1+"\n"+"");
	  }

   }
   ChainedArrays.ArrayNode next = C.getNode(1);
   int actualArraySize2 = next.getArraySize();
   int expectedArraySize2 = 3;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "ExpectedArraySize2: "+expectedArraySize2 +"\n"+
               "ActualArrayValue2: "+actualArraySize2+"\n"+"");
   }
   if (actualArraySize2 == 2) {
	  Comparable actualArrayElement3 = next.getFirst();
	  Integer expectedArrayElement3 = 2;
	  if(actualArrayElement3.compareTo(expectedArrayElement3)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement3: "+expectedArrayElement3 +"\n"+
               "ActualArrayElement3: "+actualArrayElement3+"\n"+"");
	  }
	  Comparable actualArrayElement4 = next.get(1);
	  Integer expectedArrayElement4 = 3;
	  if(actualArrayElement4.compareTo(expectedArrayElement4)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement4: "+expectedArrayElement4 +"\n"+
               "ActualArrayElement4: "+actualArrayElement4+"\n"+"");
	  }
	  Comparable actualArrayElement5 = next.getLast();
	  Integer expectedArrayElement5 = 4;
	  if(actualArrayElement5.compareTo(expectedArrayElement5)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement5: "+expectedArrayElement5 +"\n"+
               "ActualArrayElement5: "+actualArrayElement5+"\n"+"");
	  }
   }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_insertSortedWithPossibleSplit7() {
   // test ChainedArrays_insertSortedWithPossibleSplit1 insert 2 into [1] w/ capacity 1
   // There is a single data node with [1]. Special case: capacity 1 node

   ChainedArrays<Integer> C = new ChainedArrays<Integer>(1);
   C.add(1);
   int actualNodeCount1 = C.nodeCount();
   int expectedNodeCount1 = 1;
   if(actualNodeCount1 != expectedNodeCount1) {
       failFmt("insertSortedWithPossibleSplit:\n"+
               "expectedNodeCount1: "+expectedNodeCount1 +"\n"+
               "actualNodeCount1: "+actualNodeCount1+"\n"+"");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);
   ChainedArrays.ArrayNode end = new ChainedArrays.ArrayNode(current,current.next,1);
  	end.insertSorted(new Integer(3));
	current.next.prev = end;
	current.next = end;

   C.insertWithPossibleSplit(current,new Integer(2));

   Object[] actual2 = current.getArray();
   Object[] expect2 = {1};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }

   ChainedArrays.ArrayNode next = current.next;
   Object[] actual3 = next.getArray();
   Object[] expect3 = {2};
    if(!Arrays.deepEquals(actual3,expect3)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect3: "+printArray(expect3) +"\n"+
               "Actual3: "+printArray(actual3)+"\n"+"");
    }

   end = next.next;
   Object[] actual4 = end.getArray();
   Object[] expect4 = {3};
    if(!Arrays.deepEquals(actual4,expect4)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect4: "+printArray(expect4) +"\n"+
               "Actual4: "+printArray(actual4)+"\n"+"");
    }
  }

// 

// test ChainedArrays.add

/*
If A has one data node N, which is node beginMarker.next and node endMarker.prev, 
then current is node N.
***************        ***************       ***************
* beginMarker *   -->  *             *  -->  *  endMarker  *
***************   <--  ***************  <--  ***************
                           current
*/
/*
  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add2(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(4);
   C.add(1); // create first data node and insert 1
   C.add(2); // insert 2, 3, and 4 into first data node
   C.add(3);
   C.add(4);
   int actualNumberNodes = C.nodeCount();
   int expectedActualNodes = 1;
   ChainedArrays.ArrayNode current = C.getNode(0);
   if (current == null) {
       failFmt("add:\n"+
               "Expect: "+"non-null first data node" +"\n"+
               "Actual: "+"null first data node"+"");
   }
  int actualArraySize = current.getArraySize();
  int expectedArraySize = 4;

  if(actualArraySize != expectedArraySize) {
       failFmt("add:\n"+
               "ExpectedArraySize: "+expectedArraySize +"\n"+
               "ActualArrayValue: "+actualArraySize+"\n"+"");
  }

  if (actualArraySize == 1) {
	  Comparable actualArrayElement = current.getFirst();
	  Integer expectedArrayElement = 2;
	  if(actualArrayElement.compareTo(expectedArrayElement)!= 0) {
       failFmt("add:\n"+
               "ExpectedArrayElement: "+expectedArrayElement +"\n"+
               "ActualArrayElement: "+actualArrayElement+"\n"+"");
	  }
   }
   Object[] actual = current.getArray();
   Object[] expect = {1,2,3,4};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("insertSortedWithPossibleSplit:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }
  }

/*
If A has more than one data node, but the inserted data value is less than the minimum value in the first 
data node (i.e., beginMarker.next) then current is the first data node.
insert: 1

***************        ************       *********       ***************
* beginMarker *   -->  *  2   3   *  -->  *  5       -->  *  endMarker  *
***************   <--  ************  <--  *********  <--  ***************
                           current
*/

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add3(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2); // add 2 to first node
   C.add(5); // add 5 to first node
   C.add(3); // split first node into [2, ] -> [5, ] and add 3: [2,3] -> [5, ]
   // more than one data node 
   C.add(1); // 1 < 2  ==> [1,2] -> [3, ] -> [5, ]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 1;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue = current.getLast();
   Integer expectedLastValue = 2;
   if (actualLastValue.compareTo(expectedLastValue) != 0) {
       failFmt("add:\n"+
               "expectedLastValue: " + expectedLastValue +"\n"+
               "actualLastValue: " + actualLastValue + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(1);

   Comparable actualFirstValue2 = node2.getFirst();
   Integer expectedFirstValue2 = 3;
   if (actualFirstValue2.compareTo(expectedFirstValue2) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }
  
   int actualArraySize1 = node2.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   ChainedArrays.ArrayNode node3 = C.getNode(2);

   Comparable actualFirstValue3 = node3.getFirst();
   Integer expectedFirstValue3 = 5;
   if (actualFirstValue3.compareTo(expectedFirstValue3)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue3: " + expectedFirstValue3 +"\n"+
               "actualFirstValue3: " + actualFirstValue3 + "");
   }
  
   int actualArraySize2 = node3.getArraySize();
   int expectedArraySize2 = 1;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("add:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }
  }

/*
If there are two data nodes N1 and N2 in A such that: N1.next == N2, and the inserted data value is greater 
than the maximum value in Node N1 and less than the minimum value in node N2, then current is the 
node with the smallest number of data elements. If N1 and N2 have the same number of elements, 
then current is N2.
insert: 4

***************        ************       *********       ***************
* beginMarker *   -->  *  2   3   *  -->  *  5       -->  *  endMarker  *
***************   <--  ************  <--  *********  <--  ***************
                           current
*/

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add4(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2); // add 2 to first node
   C.add(5); // add 5 to first node
   C.add(3); // split first node into [2, ] -> [5, ] and add 3: [2,3] -> [5, ]
   // more than one data node 
   C.add(4); // 4 > 3 && 4 < 5 and the node with 5 is smaller ==> [2,3] -> [4,5]
;
   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 2;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 3;
   if (actualLastValue1.compareTo(expectedLastValue1) != 0) {
       failFmt("add:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(1);

   Comparable actualFirstValue2 = node2.getFirst();
   Integer expectedFirstValue2 = 4;
   if (actualFirstValue2.compareTo(expectedFirstValue2) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }
  
   int actualArraySize1 = node2.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualLastValue2 = node2.getLast();
   Integer expectedLastValue2 = 5;
   if (actualLastValue2.compareTo(expectedLastValue2) != 0) {
       failFmt("add:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }
  }


/*
If A has more than one data node, and the inserted data value is greater than the maximum value in the last
data node L of A, then current is node L.

insert: 6

***************        ************       *********       ***************
* beginMarker *   -->  *  2   3   *  -->  *  5       -->  *  endMarker  *
***************   <--  ************  <--  *********  <--  ***************
                           current
*/

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add5(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2); // add 2 to first node
   C.add(5); // add 5 to first node
   C.add(3); // split first node into [2, ] -> [5, ] and add 3: [2,3] -> [5, ]
   // 6 > 5 and there is space in the last node
   C.add(6); //  [2,3] -> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 2;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 3;
   if (actualLastValue1.compareTo(expectedLastValue1) != 0) {
       failFmt("add:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(1);

   Comparable actualFirstValue2 = node2.getFirst();
   Integer expectedFirstValue2 = 5;
   if (actualFirstValue2.compareTo(expectedFirstValue2) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }
  
   int actualArraySize1 = node2.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualLastValue2 = node2.getLast();
   Integer expectedLastValue2 = 6;
   if (actualLastValue2.compareTo(expectedLastValue2) != 0) {
       failFmt("add:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }
  }

/*
If A has more than one data node, and the inserted data value is greater than the maximum value in the last
data node L of A, then current is node L.

insert: 7

***************        ************       *********       ***************
* beginMarker *   -->  *  2   3   *  -->  *  5   6    -->  *  endMarker  *
***************   <--  ************  <--  *********   <--  ***************
                           current
*/

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add6(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2); // add 2 to first node
   C.add(5); // add 5 to first node
   C.add(3); // split first node into [2, ] -> [5, ] and add 3: [2,3] -> [5, ]
   C.add(6); // [2,3] -> [5,6]
   // 7 > 6
   C.add(7); // [2,3] -> [5, ] -> [6,7]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 2;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 3;
   if (actualLastValue1.compareTo(expectedLastValue1) != 0) {
       failFmt("add:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(1);

   Comparable actualFirstValue2 = node2.getFirst();
   Integer expectedFirstValue2 = 5;
   if (actualFirstValue2.compareTo(expectedFirstValue2) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }
  
   int actualArraySize2 = node2.getArraySize();
   int expectedArraySize2 = 1;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("add:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   ChainedArrays.ArrayNode node3 = C.getNode(2);

   Comparable actualFirstValue3 = node3.getFirst();
   Integer expectedFirstValue3 = 6;
   if (actualFirstValue3.compareTo(expectedFirstValue3) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue3: " + expectedFirstValue3 +"\n"+
               "actualFirstValue3: " + actualFirstValue3 + "");
   }

   int actualArraySize3 = node3.getArraySize();
   int expectedArraySize3 = 2;

   if(actualArraySize3 != expectedArraySize3) {
       failFmt("add:\n"+
               "expectedArraySize3: "+expectedArraySize3 +"\n"+
               "actualArraySize3: "+actualArraySize3+"\n"+"");
   }

   Comparable actualLastValue2 = node3.getLast();
   Integer expectedLastValue2 = 7;
   if (actualLastValue2.compareTo(expectedLastValue2) != 0) {
       failFmt("add:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }

  }


/*
If there are two data nodes N1 and N2 in A such that: N1.next == N2, and the inserted data value is greater 
than the maximum value in Node N1 and less than the minimum value in node N2, then current is the 
node with the smallest number of data elements. If N1 and N2 have the same number of elements, 
then current is N2.


insert: 4

***************        ************       *********       ***************
* beginMarker *   -->  *  2   3   *  -->  *  5  6    -->  *  endMarker  *
***************   <--  ************  <--  *********  <--  ***************
                           current

*/

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add7(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2); // add 2 to first node
   C.add(5); // add 5 to first node
   C.add(3); // split first node into [2, ] -> [5, ] and add 3: [2,3] -> [5, ]
   C.add(6); // [2,3] -> [5,6]
   // 4 < 5 and 4 > 3 and nodes have equal size
   C.add(4); // [2,3] -> [4,5] -> [6,]


   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 2;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 3;
   if (actualLastValue1.compareTo(expectedLastValue1) != 0) {
       failFmt("add:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(1);

   Comparable actualFirstValue2 = node2.getFirst();
   Integer expectedFirstValue2 = 4;
   if (actualFirstValue2.compareTo(expectedFirstValue2) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }
  
   int actualArraySize1 = node2.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualLastValue2 = node2.getLast();
   Integer expectedLastValue2 = 5;
   if (actualLastValue2.compareTo(expectedLastValue2) != 0) {
       failFmt("add:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }

   ChainedArrays.ArrayNode node3 = C.getNode(2);

   Comparable actualFirstValue3 = node3.getFirst();
   Integer expectedFirstValue3 = 6;
   if (actualFirstValue3.compareTo(expectedFirstValue3) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue3: " + expectedFirstValue2 +"\n"+
               "actualFirstValue3: " + actualFirstValue3 + "");
   }
  
   int actualArraySize2 = node3.getArraySize();
   int expectedArraySize2 = 1;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("add:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }
  }

/*
If A has more than one data node, and for some data node N the inserted data value is greater than or 
equal to the minimum data value in node N and less than or equal to the maximum data value in node N,
then current is node N.

insert: 4

***************        ************       *********       ***************
* beginMarker *   -->  *  2   3   *  -->  *  5  6    -->  *  endMarker  *
***************   <--  ************  <--  *********  <--  ***************
                           current

*/


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add8(){
  // test adding to empty ChainedArrays
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(3);
   C.add(2); // add 2 to first node
   C.add(3); // add 3 to first node
   C.add(5); // add 5 to the first node
   C.add(1); //split first node into [2, ] -> [3,5] and add 1: [1,2] -> [3,5]
   // 4 < 5 and 4 > 3
   C.add(4); // [1,2] -> [3,4,5] 


   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 1;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }

   Comparable actualLastValue1 = current.getLast();
   Integer expectedLastValue1 = 2;
   if (actualLastValue1.compareTo(expectedLastValue1) != 0) {
       failFmt("add:\n"+
               "expectedLastValue1: " + expectedLastValue1 +"\n"+
               "actualLastValue1: " + actualLastValue1 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(1);

   Comparable actualFirstValue2 = node2.getFirst();
   Integer expectedFirstValue2 = 3;
   if (actualFirstValue2.compareTo(expectedFirstValue2) != 0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }
  
   int actualArraySize1 = node2.getArraySize();
   int expectedArraySize1 = 3;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualLastValue2 = node2.getLast();
   Integer expectedLastValue2 = 5;
   if (actualLastValue2.compareTo(expectedLastValue2) != 0) {
       failFmt("add:\n"+
               "expectedLastValue2: " + expectedLastValue2 +"\n"+
               "actualLastValue2: " + actualLastValue2 + "");
   }

   Comparable actualMiddleValue1 = node2.get(1);
   Integer expectedMiddleValue1 = 4;
   if (actualMiddleValue1.compareTo(expectedMiddleValue1) != 0) {
       failFmt("add:\n"+
               "expectedMiddleValue1: " + expectedMiddleValue1 +"\n"+
               "actualMiddleValue1: " + actualMiddleValue1 + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_add9(){
  // test adding with nodes that have an array capacity of 1
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(1);
   C.add(3);
   C.add(5);
   C.add(1); 
   C.add(6);
   C.add(4); // 1 -> 3 -> 4 -> 5 -> 6


   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 5;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("add:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("add:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualFirstValue1 = current.getFirst();
   Integer expectedFirstValue1 = 1;
   if (actualFirstValue1.compareTo(expectedFirstValue1)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue1: " + expectedFirstValue1 +"\n"+
               "actualFirstValue1: " + actualFirstValue1 + "");
   }


   ChainedArrays.ArrayNode node1 = C.getNode(1);

   int actualArraySize2 = node1.getArraySize();
   int expectedArraySize2 = 1;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("add:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Comparable actualFirstValue2 = node1.getFirst();
   Integer expectedFirstValue2 = 3;
   if (actualFirstValue2.compareTo(expectedFirstValue2)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue2: " + expectedFirstValue2 +"\n"+
               "actualFirstValue2: " + actualFirstValue2 + "");
   }

   ChainedArrays.ArrayNode node2 = C.getNode(2);

   int actualArraySize3 = node2.getArraySize();
   int expectedArraySize3 = 1;

   if(actualArraySize3 != expectedArraySize3) {
       failFmt("add:\n"+
               "expectedArraySize3: "+expectedArraySize3 +"\n"+
               "actualArraySize3: "+actualArraySize3+"\n"+"");
   }

   Comparable actualFirstValue3 = node2.getFirst();
   Integer expectedFirstValue3 = 4;
   if (actualFirstValue3.compareTo(expectedFirstValue3)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue3: " + expectedFirstValue3 +"\n"+
               "actualFirstValue3: " + actualFirstValue3 + "");
   }

   ChainedArrays.ArrayNode node3 = C.getNode(3);

   int actualArraySize4 = node3.getArraySize();
   int expectedArraySize4 = 1;

   if(actualArraySize4 != expectedArraySize4) {
       failFmt("add:\n"+
               "expectedArraySize4: "+expectedArraySize4 +"\n"+
               "actualArraySize4: "+actualArraySize4+"\n"+"");
   }

   Comparable actualFirstValue4 = node3.getFirst();
   Integer expectedFirstValue4 = 5;
   if (actualFirstValue4.compareTo(expectedFirstValue4)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue4: " + expectedFirstValue4 +"\n"+
               "actualFirstValue4: " + actualFirstValue4 + "");
   }

   ChainedArrays.ArrayNode node4 = C.getNode(4);

   int actualArraySize5 = node4.getArraySize();
   int expectedArraySize5 = 1;

   if(actualArraySize5 != expectedArraySize5) {
       failFmt("add:\n"+
               "expectedArraySize5: "+expectedArraySize5 +"\n"+
               "actualArraySize5: "+actualArraySize5+"\n"+"");
   }

   Comparable actualFirstValue5 = node4.getFirst();
   Integer expectedFirstValue5 = 6;
   if (actualFirstValue5.compareTo(expectedFirstValue5)!=0) {
       failFmt("add:\n"+
               "expectedFirstValue5: " + expectedFirstValue5 +"\n"+
               "actualFirstValue5: " + actualFirstValue5 + "");
   }
  }


// test ChainedArrays.contains

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_contains1(){
  // test contains - true for first data node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
   C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   boolean actualContains = C.contains(2);
	boolean expectedContains = true;

   if (actualContains != expectedContains) {
       failFmt("contains:\n"+
               "expectedContains: " + expectedContains +"\n"+
               "actualContains: " + actualContains + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_contains2(){
  // test contains - true for middle data node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   boolean actualContains = C.contains(3);
	boolean expectedContains = true;

   if (actualContains != expectedContains) {
       failFmt("contains:\n"+
               "expectedContains: " + expectedContains +"\n"+
               "actualContains: " + actualContains + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_contains3(){
  // test contains - true for last data node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   boolean actualContains = C.contains(6);
	boolean expectedContains = true;

   if (actualContains != expectedContains) {
       failFmt("contains:\n"+
               "expectedContains: " + expectedContains +"\n"+
               "actualContains: " + actualContains + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_contains4(){
  // test contains - false
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   boolean actualContains = C.contains(7);
	boolean expectedContains = false;

   if (actualContains != expectedContains) {
       failFmt("contains:\n"+
               "expectedContains: " + expectedContains +"\n"+
               "actualContains: " + actualContains + "");
   }
  }

// tests for ChainedArrays.getMatch

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getMatch1(){
  // test getMatch - match in first data node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualMatch = C.getMatch(2);
	Integer expectedMatch = 2;

   if (actualMatch.compareTo(expectedMatch) != 0) {
       failFmt("getMatch:\n"+
               "expectedMatch: " + expectedMatch +"\n"+
               "actualMatch: " + actualMatch + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getMatch2(){
  // test getMatch - match in middle data node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  // => [1,2] --> [3,4] --> [5,6]

   Comparable actualMatch = C.getMatch(3);
	Integer expectedMatch = 3;

   if (actualMatch.compareTo(expectedMatch) != 0) {
       failFmt("getMatch:\n"+
               "expectedMatch: " + expectedMatch +"\n"+
               "actualMatch: " + actualMatch + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getMatch3(){
  // test getMatch - match in last data node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualMatch = C.getMatch(6);
	Integer expectedMatch = 6;

   if (actualMatch.compareTo(expectedMatch) != 0) {
       failFmt("getMatch:\n"+
               "expectedMatch: " + expectedMatch +"\n"+
               "actualMatch: " + actualMatch + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getMatch4(){
  // test getMatch - no match
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);   //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualMatch = C.getMatch(7);
	Integer expectedMatch = null;

   if (actualMatch != expectedMatch) {
       failFmt("getMatch:\n"+
               "expectedMatch: " + expectedMatch +"\n"+
               "actualMatch: " + actualMatch + "");
   }
  }

// test ChainedArrays.getFirst

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getFirst1(){
  // test getFirst 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualFirst = C.getFirst();
	Integer expectedFirst = 1;

   if (actualFirst.compareTo(expectedFirst) != 0) {
       failFmt("getFirst:\n"+
               "expectedFirst: " + expectedFirst +"\n"+
               "actualFirst: " + actualFirst + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getFirst2(){
  // test getFirst on empty 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   boolean thrown = false;
   try {Comparable actualFirst = C.getFirst();}
	catch (NoSuchElementException e) {
		thrown = true;;
	}
   if(!thrown) {
       failFmt("getFirst:\n"+
               "Expect: "+"NoSuchElementException" +"\n"+
               "Actual: "+"NoSuchElementException not thrown"+"\n"+"");
   }
  }

// test ChainedArrays.getLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getLast1(){
  // test getLast 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.getLast();
	Integer expectedLast = 6;

   if (actualLast.compareTo(expectedLast) != 0) {
       failFmt("getLast:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_getLast2(){
  // test getLast on empty 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   boolean thrown = false;
   try {Comparable actualFirst = C.getLast();}
	catch (NoSuchElementException e) {
		thrown = true;;
	}
   if(!thrown) {
       failFmt("getLast:\n"+
               "Expect: "+"NoSuchElementException" +"\n"+
               "Actual: "+"NoSuchElementException not thrown"+"\n"+"");
   }
  }

// Test ChainedArays iterator

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_iterator1() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("ChainedArrays Iterator:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

	Iterator<Integer> i = C.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Integer actualNext1 = i.next();
	Integer expectedNext1 = 1;
   if (actualNext1 != expectedNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = true;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   Integer actualNext2 = i.next();
	Integer expectedNext2 = 2;
   if (actualNext2 != expectedNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext2: " + expectedNext2 +"\n"+
               "actualNext2: " + actualNext2 + "");
   }

   boolean actualHasNext3 = i.hasNext();
	boolean expectedHasNext3 = true;
   if (actualHasNext3 != expectedHasNext3) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext3: " + expectedHasNext3 +"\n"+
               "actualHasNext3: " + actualHasNext3 + "");
   }
   Integer actualNext3 = i.next();
	Integer expectedNext3 = 3;
   if (actualNext3 != expectedNext3) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext3: " + expectedNext3 +"\n"+
               "actualNext3: " + actualNext3 + "");
   }

   boolean actualHasNext4 = i.hasNext();
	boolean expectedHasNext4 = true;
   if (actualHasNext4 != expectedHasNext4) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext4: " + expectedHasNext4 +"\n"+
               "actualHasNext4: " + actualHasNext4 + "");
   }
   Integer actualNext4 = i.next();
	Integer expectedNext4 = 4;
   if (actualNext4 != expectedNext4) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext4: " + expectedNext4 +"\n"+
               "actualNext4: " + actualNext4 + "");
   }

   boolean actualHasNext5 = i.hasNext();
	boolean expectedHasNext5 = true;
   if (actualHasNext5 != expectedHasNext5) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext5: " + expectedHasNext5 +"\n"+
               "actualHasNext5: " + actualHasNext5 + "");
   }
   Integer actualNext5 = i.next();
	Integer expectedNext5 = 5;
   if (actualNext5 != expectedNext5) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext5: " + expectedNext5 +"\n"+
               "actualNext5: " + actualNext5 + "");
   }

   boolean actualHasNext6 = i.hasNext();
	boolean expectedHasNext6 = true;
   if (actualHasNext6 != expectedHasNext6) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext6: " + expectedHasNext6 +"\n"+
               "actualHasNext6: " + actualHasNext6 + "");
   }
   Integer actualNext6 = i.next();
	Integer expectedNext6 = 6;
   if (actualNext6 != expectedNext6) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext6: " + expectedNext6 +"\n"+
               "actualNext6: " + actualNext6 + "");
   }

   boolean actualHasNext7 = i.hasNext();
	boolean expectedHasNext7 = false;
   if (actualHasNext7 != expectedHasNext7) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext7: " + expectedHasNext7 +"\n"+
               "actualHasNext7: " + actualHasNext7 + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_iterator2() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	//C.add(4);
   C.add(5);  //=> [1,2] --> [3, ] --> [5,6]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

	Iterator<Integer> i = C.iterator();
	
   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Integer actualNext1 = i.next();
	Integer expectedNext1 = 1;
   if (actualNext1 != expectedNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = true;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   Integer actualNext2 = i.next();
	Integer expectedNext2 = 2;
   if (actualNext2 != expectedNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext2: " + expectedNext2 +"\n"+
               "actualNext2: " + actualNext2 + "");
   }

   boolean actualHasNext3 = i.hasNext();
	boolean expectedHasNext3 = true;
   if (actualHasNext3 != expectedHasNext3) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext3: " + expectedHasNext3 +"\n"+
               "actualHasNext3: " + actualHasNext3 + "");
   }
   Integer actualNext3 = i.next();
	Integer expectedNext3 = 3;
   if (actualNext3 != expectedNext3) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext3: " + expectedNext3 +"\n"+
               "actualNext3: " + actualNext3 + "");
   }

   // no value 4

   boolean actualHasNext5 = i.hasNext();
	boolean expectedHasNext5 = true;
   if (actualHasNext5 != expectedHasNext5) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext5: " + expectedHasNext5 +"\n"+
               "actualHasNext5: " + actualHasNext5 + "");
   }
   Integer actualNext5 = i.next();
	Integer expectedNext5 = 5;
   if (actualNext5 != expectedNext5) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext5: " + expectedNext5 +"\n"+
               "actualNext5: " + actualNext5 + "");
   }

   boolean actualHasNext6 = i.hasNext();
	boolean expectedHasNext6 = true;
   if (actualHasNext6 != expectedHasNext6) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext6: " + expectedHasNext6 +"\n"+
               "actualHasNext6: " + actualHasNext6 + "");
   }
   Integer actualNext6 = i.next();
	Integer expectedNext6 = 6;
   if (actualNext6 != expectedNext6) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext6: " + expectedNext6 +"\n"+
               "actualNext6: " + actualNext6 + "");
   }

   boolean actualHasNext7 = i.hasNext();
	boolean expectedHasNext7 = false;
   if (actualHasNext7 != expectedHasNext7) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext7: " + expectedHasNext7 +"\n"+
               "actualHasNext7: " + actualHasNext7 + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_iterator3() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(1);
   C.add(2); //=> [1,2]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 1;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

	Iterator<Integer> i = C.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Integer actualNext1 = i.next();
	Integer expectedNext1 = 1;
   if (actualNext1 != expectedNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = true;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   Integer actualNext2 = i.next();
	Integer expectedNext2 = 2;
   if (actualNext2 != expectedNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext2: " + expectedNext2 +"\n"+
               "actualNext2: " + actualNext2 + "");
   }

   boolean actualHasNext3 = i.hasNext();
	boolean expectedHasNext3 = false;
   if (actualHasNext3 != expectedHasNext3) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext3: " + expectedHasNext3 +"\n"+
               "actualHasNext3: " + actualHasNext3 + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_iterator4() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(1); //=> [1, ]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 1;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

	Iterator<Integer> i = C.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Integer actualNext1 = i.next();
	Integer expectedNext1 = 1;
   if (actualNext1 != expectedNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = false;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_iterator5() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(1);
   C.add(1);
   C.add(2); //=> [1] --> [2]

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

	Iterator<Integer> i = C.iterator();

   boolean actualHasNext1 = i.hasNext();
	boolean expectedHasNext1 = true;
   if (actualHasNext1 != expectedHasNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext1: " + expectedHasNext1 +"\n"+
               "actualHasNext1: " + actualHasNext1 + "");
   }
   Integer actualNext1 = i.next();
	Integer expectedNext1 = 1;
   if (actualNext1 != expectedNext1) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext1: " + expectedNext1 +"\n"+
               "actualNext1: " + actualNext1 + "");
   }
	
   boolean actualHasNext2 = i.hasNext();
	boolean expectedHasNext2 = true;
   if (actualHasNext2 != expectedHasNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext2: " + expectedHasNext2 +"\n"+
               "actualHasNext2: " + actualHasNext2 + "");
   }
   Integer actualNext2 = i.next();
	Integer expectedNext2 = 2;
   if (actualNext2 != expectedNext2) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedNext2: " + expectedNext2 +"\n"+
               "actualNext2: " + actualNext2 + "");
   }

   boolean actualHasNext3 = i.hasNext();
	boolean expectedHasNext3 = false;
   if (actualHasNext3 != expectedHasNext3) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedHasNext3: " + expectedHasNext3 +"\n"+
               "actualHasNext3: " + actualHasNext3 + "");
   }
   }

// test ChainedArrays.equals

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_equals1(){
  // test equals true 
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = new ChainedArrays<Integer>(2);
   C2.add(2);
   C2.add(3);
   C2.add(1); 
   C2.add(6);
	C2.add(4);
   C2.add(5);  //=> [1,2] --> [3,4] --> [5,6]


   boolean actualEquals = C1.equals(C2);
	boolean expectedEquals = true;

   if (actualEquals != expectedEquals) {
       failFmt("equals:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_equals2(){
  // test equals false 
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = new ChainedArrays<Integer>(2);
   C2.add(2);
   C2.add(3);
   C2.add(1); 
   C2.add(6);
	C2.add(4);
   //C2.add(5); 


   boolean actualEquals = C1.equals(C2);
	boolean expectedEquals = false;

   if (actualEquals != expectedEquals) {
       failFmt("equals:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_equals3(){
  // test equals false 
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = new ChainedArrays<Integer>(2);
   C2.add(2);
   C2.add(3);
   //C2.add(1); 
   C2.add(6);
	C2.add(4);
   C2.add(5);


   boolean actualEquals = C1.equals(C2);
	boolean expectedEquals = false;

   if (actualEquals != expectedEquals) {
       failFmt("equals:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }

// test ChainedArrays.isEqual

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_isEqual1(){
  // test isEqual true 
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = new ChainedArrays<Integer>(2);
   C2.add(2);
   C2.add(3);
   C2.add(1); 
   C2.add(6);
	C2.add(4);
   C2.add(5);  //=> [1,2] --> [3,4] --> [5,6]


   boolean actualEquals = C1.isEqual(C1,C2);
	boolean expectedEquals = true;

   if (actualEquals != expectedEquals) {
       failFmt("isEqual:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_isEqual2(){
  // test isEqual false 
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = new ChainedArrays<Integer>(2);
   C2.add(2);
   C2.add(3);
   C2.add(1); 
   C2.add(6);
	C2.add(4);
   //C2.add(5); 


   boolean actualEquals = C1.isEqual(C1,C2);
	boolean expectedEquals = false;

   if (actualEquals != expectedEquals) {
       failFmt("isEqual:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_isEqual3(){
  // test isEqual false : isEqual(null,non-null)
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = null;


   boolean actualEquals = C1.isEqual(C1,C2);
	boolean expectedEquals = false;

   if (actualEquals != expectedEquals) {
       failFmt("isEqual:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_isEqual4(){
  // test isEqual false : isEqual(null,non-null)
   ChainedArrays<Integer> C1 = new ChainedArrays<Integer>(2);
   C1.add(2);
   C1.add(3);
   C1.add(1); 
   C1.add(6);
	C1.add(4);
   C1.add(5);  //=> [1,2] --> [3,4] --> [5,6]
   ChainedArrays<Integer> C2 = null;

   boolean actualEquals = C1.isEqual(C2,C1);
	boolean expectedEquals = false;

   if (actualEquals != expectedEquals) {
       failFmt("isEqual:\n"+
               "expectedEquals: " + expectedEquals +"\n"+
               "actualEquals: " + actualEquals + "");
   }
  }




// test ChainedArrays.addAll

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_addAll1(){
  // test addAll: add from ArrayList
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(4);
   ArrayList<Integer> L = new ArrayList<Integer>(4);
   L.add(4);
   L.add(3);
   L.add(2);
   L.add(1);
	C.addAll(L);

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 1;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("addAll:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 4;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("addAll:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
	
   Object[] actual = current.getArray();
   Object[] expect = {1,2,3,4};
    if(!Arrays.deepEquals(actual,expect)){
       failFmt("addAll:\n"+
               "Expect: "+printArray(expect) +"\n"+
               "Actual: "+printArray(actual)+"\n"+"");
    }
  }

//ChainedArrays.removeFirst

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_removeFirst1(){
  // test removeFirst - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualFirst = C.removeFirst();
	Integer expectedFirst = 1;

   if (actualFirst.compareTo(expectedFirst) != 0) {
       failFmt("removeFirst:\n"+
               "expectedFirst: " + expectedFirst +"\n"+
               "actualFirst: " + actualFirst + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("removeFirst:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("removeFirst:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
	
   Comparable actualFirst2 = current.getFirst();
   Integer expectedFirst2 = 2;
   if (actualFirst2.compareTo(expectedFirst2) != 0) {
       failFmt("removeFirst:\n"+
               "expectedFirst2: " + expectedFirst2 +"\n"+
               "actualFirst2: " + actualFirst2 + "");
   }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_removeFirst2(){
  // test getFirst on empty 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   boolean thrown = false;
   try {Comparable actualFirst = C.removeFirst();}
	catch (NoSuchElementException e) {
		thrown = true;;
	}
   if(!thrown) {
       failFmt("removeFirst:\n"+
               "Expect: "+"NoSuchElementException" +"\n"+
               "Actual: "+"NoSuchElementException not thrown"+"\n"+"");
   }
  }

//ChainedArrays.removeLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_removeLast1(){
  // test removeFirst - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.removeLast();
	Integer expectedLast = 6;

   if (actualLast.compareTo(expectedLast) != 0) {
       failFmt("removeLast:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("removeLast:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(2);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("removeLast:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
	
   Comparable actualLast2 = current.getFirst();
   Integer expectedLast2 = 5;
   if (actualLast2.compareTo(expectedLast2) != 0) {
       failFmt("removeLast:\n"+
               "expectedLast2: " + expectedLast2 +"\n"+
               "actualLast2: " + actualLast2 + "");
   }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_removeLast2(){
  // test getFirst on empty 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   boolean thrown = false;
   try {Comparable actualFirst = C.removeLast();}
	catch (NoSuchElementException e) {
		thrown = true;;
	}
   if(!thrown) {
       failFmt("removeLast:\n"+
               "Expect: "+"NoSuchElementException" +"\n"+
               "Actual: "+"NoSuchElementException not thrown"+"\n"+"");
   }
  }

// test ChainedArrays.remove

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove1(){
  // test remove - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.remove(5);
	Integer expectedLast = 5;

   if (actualLast.compareTo(expectedLast) != 0) {
       failFmt("remove:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(2);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
	
   Comparable actualLast2 = current.getFirst();
   Integer expectedLast2 = 6;
   if (actualLast2.compareTo(expectedLast2) != 0) {
       failFmt("remove:\n"+
               "expectedLast2: " + expectedLast2 +"\n"+
               "actualLast2: " + actualLast2 + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove2(){
  // test remove - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.remove(4);
	Integer expectedLast = 4;

   if (actualLast.compareTo(expectedLast) != 0) {
       failFmt("remove:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(1);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
	
   Comparable actualLast2 = current.getFirst();
   Integer expectedLast2 = 3;
   if (actualLast2.compareTo(expectedLast2) != 0) {
       failFmt("remove:\n"+
               "expectedLast2: " + expectedLast2 +"\n"+
               "actualLast2: " + actualLast2 + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove3(){
  // test remove - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.remove(2);
	Integer expectedLast = 2;

   if (actualLast.compareTo(expectedLast) != 0) {
       failFmt("remove:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
	
   Comparable actualLast2 = current.getFirst();
   Integer expectedLast2 = 1;
   if (actualLast2.compareTo(expectedLast2) != 0) {
       failFmt("remove:\n"+
               "expectedLast2: " + expectedLast2 +"\n"+
               "actualLast2: " + actualLast2 + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove4(){
  // test remove - not found so return null
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(3);
   C.add(5);
   C.add(1); 
   C.add(9);
	C.add(7);
   C.add(8);  //=> [1,3] --> [5,7] --> [8,9]

   Comparable actualLast = C.remove(6);
	Integer expectedLast = null;

   if (actualLast != expectedLast) {
       failFmt("remove:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(1);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove5(){
  // test remove - not found so return null
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(3);
   C.add(5);
   C.add(1); 
   C.add(9);
	C.add(7);
   C.add(8);  //=> [1,3] --> [5,7] --> [8,9]


   Comparable actualLast = C.remove(10);
	Integer expectedLast = null;

   if (actualLast != expectedLast) {
       failFmt("remove:\n"+
               "expectedLast: " + expectedLast +"\n"+
               "actualLast: " + actualLast + "");
   }

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(1);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove6(){
  // test remove -  node becomes empty so remove node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(3);
   C.add(5);
   C.add(1); 
   C.add(9);
	C.add(7);
   C.add(8);  //=> [1,3] --> [5,7] --> [8,9]

   Comparable actualLast = C.remove(1);
   actualLast = C.remove(3);

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Object[] actual1 = current.getArray();
   Object[] expect1 = {5,7};
    if(!Arrays.deepEquals(actual1,expect1)){
       failFmt("remove:\n"+
               "Expect1: "+printArray(expect1) +"\n"+
               "Actual1: "+printArray(actual1)+"\n"+"");
    }

   current = C.getNode(1);

   int actualArraySize2 = current.getArraySize();
   int expectedArraySize2 = 2;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("remove:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Object[] actual2 = current.getArray();
   Object[] expect2 = {8,9};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("remove:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove7(){
  // test remove -  node becomes empty so remove node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(3);
   C.add(5);
   C.add(1); 
   C.add(9);
	C.add(7);
   C.add(8);  //=> [1,3] --> [5,7] --> [8,9]

   Comparable actualLast = C.remove(5);
   actualLast = C.remove(7);

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Object[] actual1 = current.getArray();
   Object[] expect1 = {1,3};
    if(!Arrays.deepEquals(actual1,expect1)){
       failFmt("remove:\n"+
               "Expect1: "+printArray(expect1) +"\n"+
               "Actual1: "+printArray(actual1)+"\n"+"");
    }

   current = C.getNode(1);

   int actualArraySize2 = current.getArraySize();
   int expectedArraySize2 = 2;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("remove:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Object[] actual2 = current.getArray();
   Object[] expect2 = {8,9};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("remove:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove8(){
  // test remove -  node becomes empty so remove node
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(3);
   C.add(5);
   C.add(1); 
   C.add(9);
	C.add(7);
   C.add(8);  //=> [1,3] --> [5,7] --> [8,9]

   Comparable actualLast = C.remove(8);
   actualLast = C.remove(9);

   int actualNumberNodes = C.nodeCount();
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 2;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Object[] actual1 = current.getArray();
   Object[] expect1 = {1,3};
    if(!Arrays.deepEquals(actual1,expect1)){
       failFmt("remove:\n"+
               "Expect1: "+printArray(expect1) +"\n"+
               "Actual1: "+printArray(actual1)+"\n"+"");
    }

   current = C.getNode(1);

   int actualArraySize2 = current.getArraySize();
   int expectedArraySize2 = 2;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("remove:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Object[] actual2 = current.getArray();
   Object[] expect2 = {5,7};
    if(!Arrays.deepEquals(actual2,expect2)){
       failFmt("remove:\n"+
               "Expect2: "+printArray(expect2) +"\n"+
               "Actual2: "+printArray(actual2)+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove9(){
  // test remove - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.remove(2);
   actualLast = C.remove(4);
   actualLast = C.remove(5);

   int actualNumberNodes = C.nodeCount(); //no compression
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_remove10(){
  // test remove - no compress 
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(2);
   C.add(3);
   C.add(1); 
   C.add(6);
	C.add(4);
   C.add(5);  //=> [1,2] --> [3,4] --> [5,6]

   Comparable actualLast = C.remove(2);
   actualLast = C.remove(4);
   actualLast = C.remove(5);
   actualLast = C.remove(6); // node [5,6] is removed so no compression is needed

   int actualNumberNodes = C.nodeCount(); //no compression
   int expectedNumberNodes = 2;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

   ChainedArrays.ArrayNode current = C.getNode(0);

   int actualArraySize1 = current.getArraySize();
   int expectedArraySize1 = 1;

   if(actualArraySize1 != expectedArraySize1) {
       failFmt("remove:\n"+
               "expectedArraySize1: "+expectedArraySize1 +"\n"+
               "actualArraySize1: "+actualArraySize1+"\n"+"");
   }

   Comparable actualLast2 = current.getLast();
   Integer expectedLast2 = 1;
   if (actualLast2.compareTo(expectedLast2) != 0) {
       failFmt("remove:\n"+
               "expectedLast2: " + expectedLast2 +"\n"+
               "actualLast2: " + actualLast2 + "");
   }

   current = C.getNode(1);

   int actualArraySize2 = current.getArraySize();
   int expectedArraySize2 = 1;

   if(actualArraySize2 != expectedArraySize2) {
       failFmt("remove:\n"+
               "expectedArraySize2: "+expectedArraySize2 +"\n"+
               "actualArraySize2: "+actualArraySize2+"\n"+"");
   }

   Comparable actualLast3 = current.getLast();
   Integer expectedLast3 = 3;
   if (actualLast3.compareTo(expectedLast3) != 0) {
       failFmt("remove:\n"+
               "expectedLast3: " + expectedLast3 +"\n"+
               "actualLast3: " + actualLast3 + "");
   }
  }


// test ChainedArrays.toString

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_toString1() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(3);
   C.add(1);
   C.add(4);
   C.add(6); 
   C.add(7);
	C.add(5);
   C.add(8);  //=> | 1 | --> | 4, 5 | --> | 6, 7, 8|

   // ignore differences in white space, e.g., |1,2| equals | 1, 2 |
   String actualString = C.toString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
   String expectedString = "|1|4,5|6,7,8|";
   if (!actualString.equals(expectedString)) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedString: " + expectedString +"\n"+
               "actualString: " + actualString + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_toString2() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(3);
   C.add(1); //=> | 1 | 

   // ignore differences in white space, e.g., |1,2| equals | 1, 2 |
   String actualString = C.toString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
   String expectedString = "|1|";
   if (!actualString.equals(expectedString)) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedString: " + expectedString +"\n"+
               "actualString: " + actualString + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_toString3() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(2);
   C.add(1); 
   C.add(3);
   C.add(4); 
	C.add(2); 
   C.remove(4);
   //=> | 1, 2 | --> | 3 |

   // ignore differences in white space, e.g., |1,2| equals | 1, 2 |
   String actualString = C.toString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
   String expectedString = "|1,2|3|";
   if (!actualString.equals(expectedString)) {
       failFmt("ChainedArrays iterator:\n"+
               "expectedString: " + expectedString +"\n"+
               "actualString: " + actualString + "");
   }
   }

// test ChainedArrays.remove with compression


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_removeWithCompression1() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(3);
   C.add(1); 
   C.add(4); 
   C.add(7); 
   C.add(8);
   C.add(2);
   C.add(3);   
   C.add(5);
   C.add(6);
   C.add(9); //=> | 1, 2, 3 | --> | 4, 5, 6 | -> | 7, 8, 9 |

   C.remove(6);
   C.remove(3);
   C.remove(5);
   C.remove(2); //=> | 1, ,  | --> | 4, ,  | -> | 7, 8, 9 |

   int actualNumberNodes = C.nodeCount(); //no compression
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove with compression:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

   C.remove(7); //=> | 1, ,  | --> | 4, ,  | -> | 8, 9,  |
   // 4 elements stored in space for 9 ==> compress

   int actualNumberNodes2 = C.nodeCount();
   int expectedNumberNodes2 = 2;
   if (actualNumberNodes2 != expectedNumberNodes2) {
       failFmt("remove with compression:\n"+
               "expectedNumberNodes2: " + expectedNumberNodes2 +"\n"+
               "actualNumberNodes2: " + actualNumberNodes2 + "");
   }

   // ignore differences in white space, e.g., |1,4| equals | 1, 4 |
   String actualString = C.toString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
   String expectedString = "|1,4,8|9|";
   if (!actualString.equals(expectedString)) {
       failFmt("remove with compression:\n"+
               "expectedString: " + expectedString +"\n"+
               "actualString: " + actualString + "");
   }
   }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ChainedArrays_removeWithCompression2() {
  // test getNode(idx, lower,upper) out of range
   ChainedArrays<Integer> C = new ChainedArrays<Integer>(3);
   C.add(1); 
   C.add(4); 
   C.add(7); 
   C.add(8);
   C.add(2);
   C.add(3);   
   C.add(6);
   C.add(5);
   C.add(9); //=> | 1, 2, 3 | --> | 4, 5, 6 | -> | 7, 8, 9 |

   // FYI
   //System.out.println();
   //System.out.println(C);
   //System.out.println(3 * 3 * 0.5);

   C.remove(9);
   C.remove(6);
   C.remove(3);  //=> | 1, 2,  | --> | 4, 5,  | -> | 7, 8,  |
   C.remove(5);  //=> | 1, 2,  | --> | 4,  ,  | -> | 7, 8,  |

   int actualNumberNodes = C.nodeCount(); //no compression
   int expectedNumberNodes = 3;
   if (actualNumberNodes != expectedNumberNodes) {
       failFmt("remove with compression:\n"+
               "expectedNumberNodes: " + expectedNumberNodes +"\n"+
               "actualNumberNodes: " + actualNumberNodes + "");
   }

   C.remove(2);     C.remove(2);  //=> | 1,  ,  | --> | 4,  ,  | -> | 7, 8,  |
   // 4 elements stored in space for 3*3 ==> compress

   int actualNumberNodes2 = C.nodeCount(); //no compression
   int expectedNumberNodes2 = 2;
   if (actualNumberNodes2 != expectedNumberNodes2) {
       failFmt("remove with compression:\n"+
               "expectedNumberNodes2: " + expectedNumberNodes2 +"\n"+
               "actualNumberNodes2: " + actualNumberNodes2 + "");
   }

   // ignore differences in white space, e.g., |1,4| equals | 1, 4 |
   String actualString = C.toString().replaceAll("\\s+",""); // removes all whitespaces and non visible characters
   String expectedString = "|1,4,7|8|";
   if (!actualString.equals(expectedString)) {
       failFmt("remove with compression:\n"+
               "expectedString: " + expectedString +"\n"+
               "actualString: " + actualString + "");
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

