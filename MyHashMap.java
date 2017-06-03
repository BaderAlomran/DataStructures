import java.util.Set;

public class MyHashMap<KeyType extends Comparable<KeyType>, ValueType> {

  // Table to hold key/val pairs 
  private MyHashTable<Entry<KeyType,ValueType>> items;
  
  // Constructor
  public MyHashMap() {
}

  // Associates the specified value with the specified key in this map.
  // Throws IllegalArgumentException if key is null or val is null;
  public void put( KeyType key, ValueType val ) {
	  if (key == null || val == null)
		  throw new IllegalArgumentException();
	  
}

  // Returns the value to which the specified key is mapped, or null if 
  // this map contains no mapping for the key.
  // Throws IllegalArgumentException if key is null.
  public ValueType get(KeyType key ) {
	return null;
}

  // Returns true if there are no elements.
  // Target Complexity: O(1)
  public boolean isEmpty() {
	return false;
}

  // Returns the number of elements
  // Target Complexity: O(1)
  public int size() {
	return 0;
}

  // Make the hash map logically empty.
  // Target Complexity: O(1)
  public void clear() {
}

  // Returns a Set of the mappings contained in this map.
  public Set<Entry<KeyType, ValueType>> entrySet() {
	return null;
}
  
  // A helper method that returns an Entry created from the specified key and value
  //protected MyHashMap.Entry<keytype,valuetype> makeEntry( KeyType key, ValueType value ) {
  //  return new MyHashMap.Entry<keytype, valuetype="">( key, value );
  //}
 
  // A convenience helper method for creating an Entry from a key value
 // private MyHashMap.Entry<keytype,valuetype> makeEntry( KeyType key ) {
 //   return makeEntry( (KeyType) key, null );
 // }

  // Returns the hash table of items
  protected MyHashTable<Entry<KeyType,ValueType>> getItems() {
	return null;
}

  public static class Entry<KeyType extends Comparable<KeyType>, ValueType> 
  		implements Comparable<Entry<KeyType, ValueType>> {
	  	private KeyType key;
	  	private ValueType val;

		 // Constructor
		 // Target Complexity: O(1)		
		 public Entry( KeyType k, ValueType v ) {
			 this.key = k;
			 this.val = v;
		}

		 // Returns the hash code value for this map entry. The hashCode of the Entry is the hashCode of
		 // the Entry's key.
		 public int hashCode() 
		 {
			 return ((String)this.key).hashCode();
		}

		 // Compares the specified object with this entry for equality. The equality of two Entries is 
		 // based on the equality of their keys.
		 public boolean equals( Object rhs ) {
			 if (this.getClass() != rhs.getClass())
				 return false;
			 if (this.key != ((Entry<KeyType, ValueType>)rhs).key )
				 return false;
			 return true;
		}

		 // Returns the key corresponding to this entry.		
		 public KeyType getKey() {
			return this.key;
		}

		 // Returns the value corresponding to this entry.
		 public ValueType getValue() {
			return this.val;
		}

		 // toString() - create a pretty representation of the Entry.
		 // Example: When key = "Carver" and value = "CS310-003": (Carver, CS310-003)
		 public String toString() {
			 String fm =  String.format("(%s, %s)", this.key.toString(), this.val.toString());
			 return fm;
		}

	 // Compares this object with the specified object for order. Returns a negative integer, 
	 // zero, or a positive integer if this object is less than, equal to, or greater than the 
	 // other object.
		 public int compareTo(Entry other) {
			 
			 return this.key.compareTo((KeyType) other.key);
			 
		 }
	}
  
}