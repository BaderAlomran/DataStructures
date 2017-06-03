
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;



public class ChainedArrays<T extends Comparable<T>> implements Iterable<T> {
	private static final int DEFAULTCAPACITYOFARRAYS = 16;
	ArrayNode<T> begin;
	ArrayNode<T> end;
	int sizeOfChainedArray;
	int nodesInChainedArray;
	int capacityOfArrays;
	int modCount;
	// Workhorse constructor.
	ChainedArrays(int capacityOfArrays) {
		this.begin = new ArrayNode<T>(null, end, 0);
		this.end = new ArrayNode<T>(begin, null, 0);
		this.capacityOfArrays = capacityOfArrays;
		this.sizeOfChainedArray = 0;
		this.nodesInChainedArray = 0;
		this.modCount = capacityOfArrays;
	}

	  // Convenience constructor  
	ChainedArrays() {
		this.begin = new ArrayNode<T>(null, end, 0);
		this.end = new ArrayNode<T>(begin, null, 0);
		this.capacityOfArrays = DEFAULTCAPACITYOFARRAYS;
		this.sizeOfChainedArray = 0;
		this.nodesInChainedArray = 0;
		this.modCount = capacityOfArrays;
		  
	}
	protected static class ArrayNode<U extends Comparable<U>> {
		ArrayNode<U> prev;
		ArrayNode<U> next;
		int length;
		int numElements;
		Object []Array;
		// Workhorse constructor. Initialize prev and next and the size of the array, and 
	    // create an array of Objects with the specified capacity.
	    // Throws IllegalArgumentException if capacityOfArray < 0.
	    public ArrayNode(ArrayNode<U> prev, ArrayNode<U> next, int capacityOfArray) {
	    	this.prev = prev;
	    	this.next = next;
	    	this.numElements = 0;
	    	if (capacityOfArray < 0)
	    		throw new IllegalArgumentException("Illegal capacity of array " + Integer.toString(capacityOfArray) );
	    	this.length = capacityOfArray;
	    	Array = new Object[this.length];
		}

	    // Convenience constructor.
	    public ArrayNode(ArrayNode<U> prev, ArrayNode<U> next) {
	    	this.prev = prev;
	    	this.next = next;
	    	this.numElements = 0;
	    	this.length = DEFAULTCAPACITYOFARRAYS;
	    	Array = new Object[this.length];
		}

	    // to be completed yet
	    public int compareTo(U n) {
	    	//n.compareTo(o)
	    	return this.compareTo(n);
	    }
	    // Insert in ascending sorted order using binarySearch(). This may require elements 
	    // to be shifted.
	    // Throws IllegalArgumentException if x is null.
	    // Target Complexity: O(n)
	    public void insertSorted(U x) {
	    	if (x == null)
	    		throw new IllegalArgumentException();
	    	int idx = this.indexOf(x);
	    	if(idx < 0)
	    	{
	    		idx = (idx*-1)-1;
	    	}
	    	int i = this.numElements;
	    	for (;i>idx; i--)
	    	{
	    		this.Array[i]=this.Array[i-1];
	    	}
	    	this.Array[i] = (Object) x;
	    	this.numElements++;
	    	
	    	
		}

	    // Locate element x using binarySearch() and remove x. This may require elements 
	    // to be shifted.
	    // Returns a reference to the removed element, or null if the element was not removed.
	    // Throws IllegalArgumentException if x is null.
	    // Target Complexity: O(n)
	    public U remove(U x) {
	    	if (x == null)
	    		throw new IllegalArgumentException(" AIllegal arguments ");
	    	U node_temp = null;
	    	int index = this.indexOf(x);
	    	if (index >= 0)
	    		return this.remove(index);
	    	else
	    		return node_temp;
		}

	    // Remove the element at index idx. This may require elements to be shifted.
	    // Returns a reference to the removed element.
	    // Throws IndexOutOfBoundsException if idx is out of bounds (less than 0 
	    // or greater than array size -1)
	    // Target Complexity: O(n)
	    public U remove(int idx) {
	    	if (idx < 0 || idx >this.numElements-1)
	    		throw new IndexOutOfBoundsException(" Index out of bound ");
	    	U temp_node = (U) this.Array[idx];
	    	int i = idx+1;
	    	for (;i<this.numElements;i++)
	    	{
	    		this.Array[i-1] = this.Array[i];
	    	}
	    	this.numElements--; // decrement the total number of elements in array 
			return temp_node;
		}

	    // Uses binarySearch() to return the index of x, if x is contained in the array; 
	    // otherwise, return (-(insertion point) - 1). The insertion point is defined as the point 
	    // at which x would be inserted into the array: the index of the first element greater 
	    // than x, or array.length if all elements in the array are less than x. Note that this 
	    // guarantees that the return value will be >= 0 if and only if x is found.
	    // Throws IllegalArgumentException if x is null.
	    // Target Complexity: O(log n)
	    public int indexOf(U x) {
	    	if (x == null)
	    	{
	    		throw new IllegalArgumentException("Illegal argument exception ");
	    	}
	    	
	    	int imin = 0;
	    	int imax = this.numElements-1;
	    	// continue searching while [imin,imax] is not empty
	    	  while (imin <= imax)
	    	    {
	    	      // calculate the midpoint for roughly equal partition
	    	      int imid = (imin + imax ) / 2 ;//midpoint(imin, imax);
	    	      if(x.compareTo((U) this.Array[imid]) == 0)
	    	        // key found at index imid
	    	    	  return imid; 
	    	      // determine which subarray to search
	    	      else if ( x.compareTo((U) this.Array[imid]) > 0 )
	    	        // change min index to search upper subarray
	    	        imin = imid + 1;
	    	      else         
	    	        // change max index to search lower subarray
	    	        imax = imid - 1;
	    	    }
	    	  // key was not found
	    	  return (-1*imin-1);
		}

	    //Returns the element at the specified index. Throws IndexOutOfBoundsException if idx 
	    // is out of bounds (less than 0 or greater than array size -1)
	    //Target Complexity: O(1)
	    public U get(int idx) {
	    	if (idx < 0 || idx > this.numElements-1)
	    		throw new IndexOutOfBoundsException("Index out of bound");
	    	return (U) this.Array[idx];
		}

	    //Returns the first element. Throws IndexOutOfBoundsException if the number 
	    //of elements is 0. May call get(int idx).
	    // Target Complexity: O(1)
	    public U getFirst() {
	    	
	    	if (this.numElements == 0)
	    		throw new IndexOutOfBoundsException("Index out of bound");
	    	return (U) this.Array[0];
		}

	    // Returns the last element. Throws IndexOutOfBoundsException if the number 
	    // of elements is 0. May call get(int idx).
	    // Target Complexity: O(1)
	    public U getLast() {
	    	if (this.numElements == 0)
	    		throw new IndexOutOfBoundsException(" Index out of bound ");
	    	return (U) this.Array[this.numElements-1];
		}

	    // Remove the element at index 0. This may require elements to be shifted.
	    // Returns a reference to the removed element.
	    // Throws IndexOutOfBoundsException if the number of elements is 0.
	    // Target Complexity: O(n)
	    public U removeFirst() {
	    	if (this.numElements == 0)
	    		throw new IndexOutOfBoundsException("Index out of bound ");
	    	return this.remove(0);
		}

	    // Remove the last element.
	    // Returns a reference to the removed element.
	    // Throws IndexOutOfBoundsException if the number of elements is 0.
	    // Target Complexity: O(1)
	    public U removeLast() {
	    	if (this.numElements == 0)
	    		throw new IndexOutOfBoundsException("Index out of bound");
	    	U temp_node = (U) this.Array[this.numElements-1];
	    	this.numElements--;
	    	return temp_node;
		}

	    // toString() - create a pretty representation of the ArrayNode by showing all of the elements in the array.
	    // Target Complexity: O(n)
	    // Example: four elements in an array of capacity five:1, 2, 4, 5
	    public String toString() {
	    	String fm = new String();
	    	for (int i = 0; i< this.numElements; i++)
	    	{
	    		fm += this.Array[i].toString();
	    		if(i == this.numElements-1)
	    			continue;
	    		fm += ", ";
	    	}
			return fm;
		}

	    // Return array of Objects
	    protected Object[] getArray() {
/*	    	Object []arr = new Object[this.numElements];
	    	int i = 0;
	    	for (Object obj:this.Array)
	    	{
	    		arr[i] = obj;
	    		i++;
	    	}*/
			return this.Array;
		}

	    // Set array of Objects
	    protected void setArray(Object[] array) {
	    	int i=0;
	    	for (Object obj:array)
	    	{
	    		this.Array[i] = obj;
	    		i++;
	    	}
	    	this.numElements=i;
		}

	    // Return size of array (not length)
	    protected int getArraySize() {
	    	return this.numElements;
		}

	    // Set size of array
	    protected void setArraySize(int arraySize) {
	    	this.numElements = arraySize;
		}
	  }

	//  ...
	private class ChainedArraysIterator implements Iterator<T> {
		  private ArrayNode<T> current;
	      private ArrayNode<T> lastVisited = null;
	      private boolean lastMoveWasPrev = false;
	      private int expectedModCount = modCount;
	      int idx;
	      
		  // Constructor
		  // Target Complexity: O(1)
		  public ChainedArraysIterator() {
			  this.current = begin.next;
			  this.idx = 0;
		}

		  // Returns true if the iterator can be moved to the next() element.
		  public boolean hasNext() {
		         if( expectedModCount != modCount )
		             throw new ConcurrentModificationException( );
		          return current != end;
		}

		  // Move the iterator forward and return the passed-over element
		  public T next(){
			  if( !hasNext( ) )
		            throw new NoSuchElementException( ); 
		                
		         T nextItem = current.get(idx);
		         this.idx++;//idx++);
		         this.idx = this.idx % current.numElements;// modCount;
		         //lastVisited = current;
		         if (this.idx == 0)
		        	 current = current.next;
		         //lastMoveWasPrev = false;
		         return nextItem;			  
		  }

		  // The following operation is part of the Iterator interface
		  // but is not supported by the iterator. 
		  // Throws an UnsupportedOperationException if invoked.
		  public void remove(){
//		         if( expectedModCount != modCount )
//		             throw new ConcurrentModificationException( );
//		          if( lastVisited == null )
//		             throw new IllegalStateException( );
		              
		          //ChainedArrays.this.remove( (T) lastVisited );
			      current.remove(idx);
			      idx %= current.numElements;
			      if (idx == 0)
			    	  current = current.next;
//		          lastVisited = null;
//		          if( lastMoveWasPrev )
//		             current = current.Next;
//		          expectedModCount++; 
			  
		  }
		}


	  // Make the ChainedArrays logically empty.
	  // Target Complexity: O(1)
	  // Implementation note: It is not necessary to remove() all the elements; instead, some data
	  // members can be reinitialized.
	  public void clear()
	  {
		  this.begin.next= this.end;
		  this.begin.prev = null;
		  this.end.prev = this.begin;// = null;
		  this.end.next = null;
		  this.nodesInChainedArray = 0;
		  this.sizeOfChainedArray = 0;		  
	  }

	  // Returns the number of elements in the ChainedArrays
	  // Target Complexity: O(1)
	  public int size()
	  {
		 return this.sizeOfChainedArray;
	  }

	  // returns the number of ArrayNodes
	  // Target Complexity: O(1)
	  public int nodeCount()
	  {
		  return this.nodesInChainedArray;
	  }

	  // Returns true if there are no elements in the list
	  // Target Complexity: O(1)
	  public boolean isEmpty( )
	  {
		  if (this.sizeOfChainedArray == 0)
			  return true;
		  else 
			  return false;
	  }

	  // Return the first element in the list that equals data, or null 
	  // if there is no such element.
	  // Throws IllegalArgumentException if x is null.
	  // Target Complexity: O(n)
	  public T getMatch(T data)
	  {
		  if (data == null)
			  throw new IllegalArgumentException();
		 Iterator<T> itr = this.iterator();
		 while (itr.hasNext())
		 {
			 T data_get = itr.next();
			 if ( data_get.equals(data))
				 return data_get;
		 }
		 return null;  
	  }

	  // Returns true if this ChainedArray contains the specified element.
	  // Throws IllegalArgumentException if data is null.
	  public boolean contains (T data)
	  {
		  if (data == null)
			  throw new IllegalArgumentException();
		 Iterator<T> itr = this.iterator();
		 while (itr.hasNext())
		 {
			 T data_get = itr.next();
			 if ( data_get.equals(data))
				 return true;
		 }
		 return false; 
	  }

	  // Inserts data into the list. Parameter data will be inserted into the node 
	  // referenced by current, or node current will be split into two nodes, 
	  // and data will be inserted into one of these nodes.
	  // The rules for splitting a node are described in the implementation section.
	  // Implementation Note: Called by add().
	  protected void insertWithPossibleSplit(ArrayNode<T> current, T data) {
		  /* if node has room for new element*/
		  if (current.length > current.numElements )
		  {
			  current.insertSorted(data);
			  return;
		  }
		  if (current.length == 1) /*special case*/
		  {
			//split the node
			  ArrayNode<T> new_node = new ArrayNode<T>(current, current.next, this.capacityOfArrays);
			  current.next = new_node;
			  this.nodesInChainedArray++;
			  if (current.getFirst().compareTo(data) < 0)
			  {
				  current.next.insertSorted(data);
			  }
			  else
			  {
				  current.next.insertSorted(current.removeFirst()); // current moved to next
				  current.insertSorted(data);
			  }
			  return;
		  }
		  else
		  {
			  //split the node
			  ArrayNode<T> new_node = new ArrayNode<T>(current, current.next, this.capacityOfArrays);
			  current.next = new_node;
			  this.nodesInChainedArray++;
			  int num_elements_moved = (current.getArraySize()+1)/2;
			  int idx = num_elements_moved;
			  if (current.getArraySize() %2 != 0) //odd
			  {
				  idx--;
			  }
			  for (int i = 0; i< num_elements_moved; i++)
			  {
				  current.next.insertSorted(current.remove(idx));
			  }
			  if (current.next.getFirst().compareTo(data) > 0)
			  {
				  current.insertSorted(data);
				  return;
			  }
			  else
			  {
				  current.next.insertSorted(data);
				  return;
			  }
		  }
		  
		  
	}

	  // Insert data into the list. Returns true if data was added.
	  // The rules for finding the node in which to insert data are described 
	  // in the implementation section.
	  // Throws IllegalArgumentException if data is null.
	  public boolean add(T data) {
		  if (data == null)
			  throw new IllegalArgumentException("Illegal arguments to function");
		  ArrayNode<T> current;
		  if(this.nodesInChainedArray == 0) //case 1
		  {
			  this.nodesInChainedArray++;
			  current = new ArrayNode<T>(this.begin, this.end, this.capacityOfArrays);
			  this.begin.next = current;
			  this.end.prev = current;
			  this.insertWithPossibleSplit(current, data);
			  this.sizeOfChainedArray++;
			  return true;
		  }
		  if (this.nodesInChainedArray == 1) // case 2 only one node
		  {
			  current = this.begin.next;
			  this.insertWithPossibleSplit(current, data);
			  this.sizeOfChainedArray++;
			  return true;
		  }
		  
		  /* case 3 */
		  Iterator<T> itr = this.iterator();
		  if(itr.hasNext())
		  {
			  if (itr.next().compareTo(data) > 0) //case 3
			  {
				  current = this.begin.next;
				  this.insertWithPossibleSplit(current, data);
				  this.sizeOfChainedArray++;
				  return true;
			  }
		  }
		  /* case 4 */
		  current = this.begin.next; // first node
		  while (current != this.end)
		  {
			  T first = current.getFirst();
			  T last =  current.getLast();
			  if (first.compareTo(data) <= 0 && last.compareTo(data) >= 0)
			  {
				  this.insertWithPossibleSplit(current, data);
				  this.sizeOfChainedArray++;
				  return true;
			  }
			  current = current.next;
		  }
		  /* case 5 */
		  current = this.begin.next;
		  while(current.next != this.end)
		  {
			  T first = current.getLast();
			  T last =  current.next.getFirst();//getLast();
			  if ( first.compareTo(data) <0 && last.compareTo(data) > 0) //
			  {
				  if (current.numElements >= current.next.numElements) // same number of elements
				  {
					  current = current.next; // N2
				  }
				  this.insertWithPossibleSplit(current, data);
				  this.sizeOfChainedArray++;
				  return true;
			  }
			  current= current.next;
		  } // last node reached but previous case not found
		  if (current.getLast().compareTo(data) < 0)
		  {
			  this.insertWithPossibleSplit(current, data);
			  this.sizeOfChainedArray++;
			  return true;
		  }
		  return false;
	}

	  // Inserts all of the elements in the specified collection in the order 
	  // that they are returned by the specified collection's Iterator. 
	  // Returns true if at least one element was added.
	  // Implementation note: May repeatedly call add().
	  public boolean addAll(Iterable<T> c) {
		  Iterator<T> itr = c.iterator();
		  boolean added = false;
		  while (itr.hasNext())
		  {
			  this.add(itr.next());
			  added = true;
		  }
		return added;
	}

	  // Removes the first occurrence of the specified element if it is present. 
	  // Return a reference to the removed element if it is removed. 
	  // When the last data element is removed from an ArrayNode the node is 
	  // removed from the ChainedArrays.
	  // Compress() the list, if necessary.
	  protected T remove(T data) {
		  ArrayNode<T> current = this.begin.next;
		  while (current != this.end)
		  {
			  T removed = current.remove(data); 
			  if (removed == null)
			  {
				  current = current.next;
			  }
			  else
			  {
				  if (current.getArraySize() == 0) // last node removed
				  {
					  // remove node from array
						current.prev.next = current.next;
						current.next.prev = current.prev;
						this.nodesInChainedArray--;
				  }
				  this.sizeOfChainedArray--;
				  this.compress();
				  return removed;
			  }
		  }
		return null;
	}

	  // Reduce the amount of allocated space by shifting elements and possibly 
	  // removing nodes. No new nodes can be created during compression.
	  // The compression procedure is described in the implementation section.
	  protected void compress() {
		  if (this.nodesInChainedArray <= 1)
			  return; // no compression needed
		  if (this.sizeOfChainedArray >= (this.nodesInChainedArray*this.capacityOfArrays*0.5))
			  return; // no compression needed
		  ArrayNode<T> current = this.begin.next; // start from first
		  ArrayNode<T> Next_temp = current.next;
		  while(current.next != this.end) // iterate till end
		  {
			  while((current.length) > current.numElements)
			  {
				  //if(current == Next_temp)
			//			Next_temp = Next_temp.next;
				  if(Next_temp.numElements == 0 && Next_temp != this.end)
				  {
					  Next_temp = Next_temp.next;
				  }
				  if (Next_temp == this.end)
					  break;
				  if(Next_temp.numElements == 0) // if still node is zero
				  {
					  Next_temp = Next_temp.next;
					  continue;
				  }
				  current.insertSorted(Next_temp.removeFirst());
			  }
			  current = current.next;
			  Next_temp = current.next;
		  }
		  // remove current as it's free now
		  if (current.numElements == 0) // just checking
		  {
			current.prev.next = current.next;
			//this.end = current.prev;
			current.next.prev = current.prev;
			this.nodesInChainedArray--;
		  }	  
	}

	  // Returns the first item.
	  // Throws NoSuchElementException if the ChainedArrays are empty.
	  public T getFirst( ) {
		  if (this.isEmpty())
			  throw new NoSuchElementException("No such element");
		  return this.begin.next.getFirst();
	}

	  // Returns the last item.
	  // Throws NoSuchElementException if the ChainedArrays are empty.
	  public T getLast( ) {
		  if (this.isEmpty())
			  throw new NoSuchElementException("No such element");
		  Iterator<T> itr = this.iterator();
		  T node = null;
		  while(itr.hasNext())
			  node = itr.next();
		  return node;
	}

	  // Removes the first item.
	  // Return a reference to the removed element if it is removed. 
	  // When the last data element is removed from an ArrayNode the node is 
	  // removed from the ChainedArrays.
	  // Compress() the list, if necessary.
	  // Throws NoSuchElementException if the ChainedArrays are empty.
	  public T removeFirst( ) {
		  return this.remove(this.getFirst());
	}

	  // Returns the last item.
	  // Return a reference to the removed element if it is removed. 
	  // When the last data element is removed from an ArrayNode the node is 
	  // removed from the ChainedArrays.
	  // Compress() the list, if necessary.
	  // Throws NoSuchElementException if the ChainedArrays are empty.
	  public T removeLast( ) {
		  return this.remove(this.getLast());
	}
	       
	  // Gets the Node at position idx, which must range from 0 to numNodes( )-1.
	  // Throws IndexOutOfBoundsException if idx is not between 
	  //   0 and numNodes()-1, inclusive.
	  protected ArrayNode<T> getNode(int idx) {
		  if(idx < 0 || idx > this.nodesInChainedArray-1)
			  throw new IndexOutOfBoundsException("Index out of Bound");
		  ArrayNode<T> node = this.begin;
		  for(int i = 0; i <= idx;i++)
		  {
			  node = node.next;
		  }
		  return node;
	}
	   
	  // Gets the Node at position idx, which must range in position 
	  // from lower to upper.
	  // Throws IndexOutOfBoundsException if idx is not between 
	  //   lower and upper, inclusive.
	  protected ArrayNode<T> getNode( int idx, int lower, int upper) {
		  if(idx < lower || idx > upper)
			  throw new IndexOutOfBoundsException("Index out of Bound");
		  return this.getNode(idx);
	}

	  // Return true if the items in other are equal to the items in
	  // this ChainedArrays (same order, and same values according to equals).
	  // Requires the provided iterator to be implemented correctly.
	  public boolean equals( Object other ) {
		  /*
		  if (this.getClass() != other.getClass())
			  return false;
		  ChainedArrays<T> Other = (ChainedArrays<T>)other;
		  if(this.nodesInChainedArray != Other.nodesInChainedArray)
			  return false;
		  Iterator<T> itr1 = this.iterator();
		  Iterator<T> itr2 = Other.iterator();
		  while (itr1.hasNext())
		  {
			  if (!(itr1.next().equals(itr2.next()))) // if correspondign elements are not equal
				  return false;
		  }
		return true; // all checks passed
		*/
        if( other == this )
            return true;
            
        if ( this.getClass() != other.getClass())
            return false;
        
        ChainedArrays<T> rhs = (ChainedArrays<T>) other;
        if( size( ) != rhs.size( ) )
            return false;
        
        Iterator<T> lhsItr = this.iterator( );
        Iterator rhsItr = rhs.iterator( );
        
        while( lhsItr.hasNext( ) )
            if( !isEqual( lhsItr.next( ), rhsItr.next( ) ) )
                return false;
        return true;
	}
	    
	  // Return true if two objects are equal; works if objects can be
	  // null. Used internally for implementation of equals(other).
	  protected boolean isEqual( Object lhs, Object rhs ) {
		  
		    /**
		     * Return true if two objects are equal; works
		     * if objects can be null.
		     */
		        if( lhs == null )
		            return rhs == null;
		        if (rhs == null)
		        	return lhs == null;
		        return lhs.equals( rhs );    
	}

	  // Returns an iterator over the elements in the proper sequence.
	  public Iterator<T> iterator() {
		return new ChainedArraysIterator();
	}
	  // toString() - create a pretty representation of the ArrayNode.
	  // Runtime: O(n)
	  // Example: ChainedArray with two nodes of capacity two: | 1, 2 | 3 |
	  public String toString() {
		  String fm = new String();
		  ArrayNode<T> node = this.begin.next;
		  for (int i = 0; i< this.nodesInChainedArray; i++)
		  {
			  fm += "| ";
			  for (int idx = 0; idx < node.getArraySize(); idx++ )
			  {
				  fm += node.get(idx).toString();
				  if(idx == node.getArraySize()-1)
					  fm += " ";
				  else
					  fm += ", ";
			  }
			  node = node.next;
		  }
		  fm += "|";
		return fm;
	}

}
