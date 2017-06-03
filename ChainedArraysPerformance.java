import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

public class ChainedArraysPerformance { 
   static Integer[] array;                // array of random integers
   static ChainedArrays<Integer> ca1;     // ChainedArrays of array capcity 1
   static ChainedArrays<Integer> ca2;     // ChainedArrays of array capacity 16
   static ChainedArrays<Integer> ca3;     // ChainedArrays of array capacity size
   static Random random;

   public static class ExecutionResults {
     int size;   
     long CA1Time;
     long CA2Time;
     long CA3Time;                       
     public ExecutionResults(int size) {
          this.size = size;
     }
   } 
 
   public static void main(String[] args) throws Exception {	 
      // warm up the JVM
      for (int i = 0; i < 100; i++)
         CheckPerformance(1000);
                  
		System.out.println(); System.out.println();
      // print header
		System.out.println("add:");
      System.out.printf("%15s %18s %20s %22s %n", 
         "size",  "ChainedArrays(1)", "ChainedArrays(16)",      "ChainedArrays(size)");

      // perform the benchmarking for add
      displayResult(CheckPerformance(100));
      displayResult(CheckPerformance(200));
      displayResult(CheckPerformance(500));
      displayResult(CheckPerformance(1000));
      displayResult(CheckPerformance(2000));
      displayResult(CheckPerformance(3000));
      displayResult(CheckPerformance(4000));
      displayResult(CheckPerformance(8000));
      //displayResult(CheckPerformance(16000));   // for faster computers
      //displayResult(CheckPerformance(32000)); 
 
      System.out.println(); System.out.println();
		System.out.println("contains:");
      // print header
      System.out.printf("%15s %18s %20s %22s %n", 
         "size",  "ChainedArrays(1)", "ChainedArrays(16)",      "ChainedArrays(size)");

		// perform the benchmark for contains
      displayResult(CheckPerformanceContains(100));
      displayResult(CheckPerformanceContains(200));
      displayResult(CheckPerformanceContains(500));
      displayResult(CheckPerformanceContains(1000));
      displayResult(CheckPerformanceContains(2000));
      displayResult(CheckPerformanceContains(3000));
      displayResult(CheckPerformanceContains(4000));
      displayResult(CheckPerformanceContains(8000));
      //displayResult(CheckPerformanceContains(16000));  // for faster computers
      //displayResult(CheckPerformanceContains(32000));

		System.out.println(); System.out.println();
		System.out.println("removeFirst:");
      // print header
      System.out.printf("%15s %18s %20s %22s %n", 
       "size",  "ChainedArrays(1)", "ChainedArrays(16)",      "ChainedArrays(size)");

		// peform the benchmark for removeFirst
      displayResult(CheckPerformanceRemoveFirst(100));
      displayResult(CheckPerformanceRemoveFirst(200));
      displayResult(CheckPerformanceRemoveFirst(500));
      displayResult(CheckPerformanceRemoveFirst(1000));
      displayResult(CheckPerformanceRemoveFirst(2000));
      displayResult(CheckPerformanceRemoveFirst(3000));
      //displayResult(CheckPerformanceRemoveFirst(4000));
      //displayResult(CheckPerformanceRemoveFirst(8000));
      //displayResult(CheckPerformanceRemoveFirst(16000)); // for faster computers
      //displayResult(CheckPerformanceRemoveFirst(32000));   
   }
 
   private static void displayResult(ExecutionResults r) {    
     long min = 1;    
	  min = Math.min(r.CA1Time, Math.min(r.CA2Time, r.CA3Time));          
     System.out.printf("%15d %10d (%4.0f%%)    %-10d (%3.0f%%)     %-10d (%3.0f%%)%n", 
       r.size, 
       r.CA1Time,   (100 * (double) r.CA1Time) / min,
       r.CA2Time,    (100 * (double) r.CA2Time) / min,
       r.CA3Time, (100 * (double) r.CA3Time) / min);                              
   }
 
   private static ExecutionResults CheckPerformance(int size) {
		 array = new Integer[size];
       random = new Random(123456789L);
               
       if (ca1 == null) { // create ChainedArrays for first run
         ca1 = new ChainedArrays<Integer>(1);
         ca2 = new ChainedArrays<Integer>(16);
         ca3 = new ChainedArrays<Integer>(size);
       }
       else { // clear for next runs
         ca1.clear(); ca2.clear(); ca3.clear();
       }

       for (int i = 0; i < array.length; i++)  // fill arrays with random values less than 3*size
			array[i] = random.nextInt(3*size);
 
       ExecutionResults result = new ExecutionResults(size);
       System.gc(); // run garbage collector so it might not run during experiment

       long before = System.nanoTime();
       insertIntoCA(array, ca1);
       result.CA1Time = (System.nanoTime() - before) / 1000;
       System.gc(); // run garbage collector so it might not run during experiment

       before = System.nanoTime();
       insertIntoCA(array, ca2);
       result.CA2Time = (System.nanoTime() - before) / 1000;
       System.gc(); // run garbage collector so it might not run during experiment

       before = System.nanoTime();
       insertIntoCA(array, ca3);
       result.CA3Time = (System.nanoTime() - before) / 1000;
   		           
       return result;
   }

   private static void insertIntoCA(Integer[] intArray, ChainedArrays<Integer> list) {       
       for (Integer i : intArray) {
          list.add(i);
       }     
   }

   private static ExecutionResults CheckPerformanceContains(int size) {
		 array = new Integer[size];
       random = new Random(123456789L);

       ca1.clear(); ca2.clear(); ca3.clear();

       for (int i = 0; i < array.length; i++)  // fill arrays with random values less than 3*size
			array[i] = random.nextInt(3*size);

       ExecutionResults result = new ExecutionResults(size);
       System.gc(); // run garbage collector so it might not run during experiment

       insertIntoCA(array, ca1);
       long before = System.nanoTime();
       CAContains(array, ca1);
       result.CA1Time = (System.nanoTime() - before) / 1000;
       System.gc(); // run garbage collector so it might not run during experiment

       insertIntoCA(array, ca2);
       before = System.nanoTime();
       CAContains(array, ca2);
       result.CA2Time = (System.nanoTime() - before) / 1000;
       System.gc(); // run garbage collector so it might not run during experiment

       insertIntoCA(array, ca3);
       before = System.nanoTime();
       CAContains(array, ca3);
       result.CA3Time = (System.nanoTime() - before) / 1000;         		 
   
       return result;
   } 

   private static void CAContains(Integer[] intArray, ChainedArrays<Integer> list) { 
      for (int i=0; i< intArray.length; i++) {
         list.contains(i);
      }
   } 

   private static ExecutionResults CheckPerformanceRemoveFirst(int size) {
		 array = new Integer[size];
       random = new Random(123456789L);

       ca1.clear(); ca2.clear(); ca3.clear();

       for (int i = 0; i < array.length; i++)  // fill arrays with random values less than 3*size
			array[i] = random.nextInt(3*size);

      ExecutionResults result = new ExecutionResults(size);
      System.gc(); // run garbage collector so it might not run during experiment

      insertIntoCA(array, ca1);
      long before = System.nanoTime();
      CARemoveFirst(array, ca1);
      result.CA1Time = (System.nanoTime() - before) / 1000;
      System.gc(); // run garbage collector so it might not run during experiment

      insertIntoCA(array, ca2);
      before = System.nanoTime();
      CARemoveFirst(array, ca2);
      result.CA2Time = (System.nanoTime() - before) / 1000;
      System.gc(); // run garbage collector so it might not run during experiment

      insertIntoCA(array, ca3);
      before = System.nanoTime();
      CARemoveFirst(array, ca3);
      result.CA3Time = (System.nanoTime() - before) / 1000;         		 
               
      return result;
   } 

  private static void CARemoveFirst(Integer[] intArray, ChainedArrays<Integer> list) { 
       for (int i=0; i< intArray.length; i++) {
           list.removeFirst();
       }
  }       
}
