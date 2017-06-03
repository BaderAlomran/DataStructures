
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyHashTable<T extends Comparable<T>> implements Iterable<T> {

  // Constructor. DEFAULT_TABLE_SIZE is 101
	private static final int DEFAULT_TABLE_SIZE = 101;

	int tableSize;
	int numEntries;
	MyListNode<T> beginMarker;
	MyListNode<T> endMarker;
	Object []table;
  public MyHashTable( ) {
	  this.numEntries = 0;
	  this.tableSize = this.DEFAULT_TABLE_SIZE;
	  this.table = new Object[this.tableSize];
	  this.beginMarker = new MyListNode<T>(null, null);
	  this.endMarker =   new MyListNode<T>(null, null);
	  this.beginMarker.next = this.endMarker;
	  this.endMarker.prev = this.beginMarker;
}

  // Construct an instance; the internal table size is is initially the
  // parameter size if size is prime or the next prime number which is
  // greater than size if it is not prime
  public MyHashTable( int size ) {
	  this.numEntries = 0;
	  this.tableSize = size;
	  this.table = new Object[this.tableSize];
	  this.beginMarker = new MyListNode<T>(null, null);
	  this.endMarker =   new MyListNode<T>(null, null);
	  this.beginMarker.next = this.endMarker;
	  this.endMarker.prev = this.beginMarker;
}
  
  // Make the hash table logically empty.
  public void clear( ) {
	  this.numEntries = 0;
	  
}

  // Helper method for the linked list. Insert a new node after the given node.
  // Returns a reference to the new node
  protected MyListNode<T> insertListNodeAfter(MyListNode<T> pos, T data) {
	  MyListNode<T> new_node = new MyListNode<T>(data, pos, pos.next);
	  pos.next = new_node;
	  if(pos.next != null)
		  pos.next.prev = new_node;
	return new_node;
}

  // Helper method for the linked list. Insert a new node before the given node 
  // Returns a reference to the new node
  protected MyListNode<T> insertListNodeBefore(MyListNode<T> pos, T data) {
	  MyListNode<T> new_node = new MyListNode<T>(data, pos.prev, pos);
	  pos.prev = new_node;
	  if (pos.prev != null)
		  pos.prev.next = new_node;
	return new_node;
}

  // Helper method for the linked list. Remove the selected node.
  // Returns a reference to the removed node
  protected MyListNode<T> removeListNode(MyListNode<T> pos) {
	  MyListNode<T> prev = pos.prev;
	  MyListNode<T> next = pos.next;
	  if (prev != null)
		  prev.next = next;
	  if (next != null)
		  next.prev = prev;
	return pos;
}

  // Return a String representation of the linked list, 
  // Example: 2, 1, 3, 5, 4 
  protected String listNodesToString() {
	  //this.beginMarker.toString();
	  
	return null;
}

  // Insert x into the hash table. If x is already present, then do nothing.
  // Throws IllegalArgumentException if x is null.
  public void insert(T x) {
	  int idx = x.hashCode()%this.tableSize;
}

  // Remove x from the hash table.
  // Throws IllegalArgumentException if x is null.
  public void remove( T x ) {
}

  // Return true if x is in the hash table
  // Throws IllegalArgumentException if x is null.
  public boolean contains( T x ) {
	return false;
}

  // Return an element in the list that equals x, or null if there is no such element.
  // Throws IllegalArgumentException if x is null.
  public T getMatch(T x) {
	return null;
}

  // Create a pretty representation of the hash table. Does not include the linked list.
  // See the representation of the Table in toString()
  public String tableToString() {
	return null;
}

  // Create a pretty representation of the hash table and linked list.
  // Uses toString() of ChainedArrays.
  // May call tableToString() and listNodesToString
  // Example: table size is 3, insertion order: one, three, two
  // Table:
  // 0: | two |
  // 1: | one, three |
  // 2: 
  // Linked List: 
  // one, three, two
  public String toString() {
	return null;
}

  // Increases the size of the table by finding a prime number (nextPrime) at least as large as 
  // twice the table size. Rehashes the elements in the linked list of the hash table.
  private void rehash( ) {
}

  // internal method for computing the hash value from the hashCode of x.
  private int myhash( MyListNode<T> x ) {
    int hashVal = x.hashCode( );
    hashVal %= this.tableSize;
    if( hashVal < 0 )
      hashVal += this.tableSize;
    return hashVal;
  }

  // Internal method to find a prime number at least as large as n. 
  private static int nextPrime( int n ){
    if( n % 2 == 0 )
      n++;
    for( ; !isPrime( n ); n += 2 )
      ;
    return n;
  }

  // Internal method to test if a number is prime. Not an efficient algorithm. 
  private static boolean isPrime( int n ) {
    if( n == 2 || n == 3 )
      return true;
    if( n == 1 || n % 2 == 0 )
      return false;
    for( int i = 3; i * i <= n; i += 2 )
      if( n % i == 0 )
        return false;
    return true;
  }

  // Returns true if there are no elements.
  // Target Complexity: O(1)
  public boolean isEmpty( ) {
	  if (this.numEntries == 0)
		  return true;
	return false;
}

  // Returns the number of elements
  //Target Complexity: O(1)
  public int size() {
	return this.numEntries;
}

  // Returns an iterator over the elements in the proper sequence.
  public Iterator<T> iterator() {
	return null;
}

  // Returns the hash table array of Objects
  protected Object[] getTable() {
	  return this.table;
}

  // Internal node class which links all elements in the hash table
  // together. See documentation elsewhere
  public static class MyListNode<U extends Comparable<U>> implements Comparable<MyListNode<U>> {

	  // Constructors
	  // Target Complexity: O(1)
	  U data;
	  MyListNode<U> prev;
	  MyListNode<U> next;
	  
	  public MyListNode(U data, MyListNode<U> prev, MyListNode<U> next) {
		  this.data = data;
		  this.prev = prev;
		  this.next = next;
	}
	  public MyListNode(MyListNode<U> prev, MyListNode<U> next) {
		  this.prev = prev;
		  this.next = next;
	}

	  //Returns the hashCode() value of data.
	  public int hashCode() {
		//return ((String)this.data).hashCode();
		  return this.data.hashCode();
	}

	  // Return true if the two objects are equal.
	  // Two MyListNode objects are equal if their data values are equal 
	  public boolean equals(Object other) {
		  if (this.getClass() != other.getClass())
			  return false;
		  if (this.data.equals(((MyListNode<U>)other).data))
			  return true;
		  return false;
	}

	  // Return true if two objects are equal; works if objects can be
	  // null.  Used internally for implementation of equals(other).
	  protected boolean isEqual( Object lhs, Object rhs ) {
		  if (lhs == null)
			  return rhs == null;
		  if (rhs == null)
			  return lhs == null;
		  if (lhs.getClass() == rhs.getClass())
		  {
			  if(lhs.equals(rhs))
				  return true;
		  }
		return false;
	}

	  // Compares this object with the specified other object for order. 
	  public int compareTo(MyListNode<U> other) {
		  return this.data.compareTo(other.data);
	}

	  // toString() - create a pretty representation of the MyListNode.
	  // Example: for an integer: 3
	  public String toString() {
		  String fm = new String();
		  fm = String.format("%s", this.data.toString());
		return fm;
	}
	}
  // Internal class for iteration; see documentation elsewhere
  private class MyHashTableIterator implements Iterator<T> {
	  // Constructor
	  // Target Complexity: O(1)
	  
	  private MyListNode<T> current;
      //private ArrayNode<T> lastVisited = null;
      //private boolean lastMoveWasPrev = false;
      int idx;
	  
	  public MyHashTableIterator () {
		  this.current = beginMarker.next;
		  this.idx = 0;
		  
	}

	  // Returns true if the iterator can be moved to the next() element.
	  // Target Complexity: O(1)
	  public boolean hasNext() {
	          return current != endMarker;	
	  }

	  // Move the iterator forward and return the passed-over element
	  // Target Complexity: O(1)
	  public T next() {
		  if( !hasNext( ) )
	            throw new NoSuchElementException( ); 
	                
	         T nextItem = current.next.data;
	         //this.idx++;
	         //this.idx = this.idx % current.numElements;// modCount;
	         //lastVisited = current;
	         //if (this.idx == 0)
	        	 current = current.next;
	         //lastMoveWasPrev = false;
	         return nextItem;	
		//return null;
	}

	  // The following operation is part of the Iterator interface
	  // but are not supported by the iterator.
	  // Throws UnsupportedOperationException exceptions if invoked.
	  public void remove() {
		  removeListNode(current);
		  //current = current.next;
	}
	}
  
}