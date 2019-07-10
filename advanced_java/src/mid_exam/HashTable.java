package mid_exam;

public class HashTable
{
	// Uses the generic LinkedList2 class from Display 15.7
	private LinkedList[] hashArray;
	private static final int SIZE = 311;

	public HashTable()
	{
		hashArray = new LinkedList[SIZE];
		for (int i=0; i < SIZE; i++)
			hashArray[i] = new LinkedList();
	}

	private int computeHash(String s)
	{
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
		    hash += s.charAt(i);
		}
		return hash % SIZE;
	}

	/**
	 Returns true if the target is in the hash table,
	 false if it is not.
	*/
	public boolean containsString(String target)
	{
		int hash = computeHash(target);
		LinkedList list = hashArray[hash];

		if (list.contains(target)) return true;

		return false;
	}

	/**
	 Stores string s into the hash table
	*/
	public void put(String s)
	{
		int hash = computeHash(s);	// Get hash value

		LinkedList list = hashArray[hash];
		if (!list.contains(s))
		{
			// Only add the target if it's not already on the list.
			hashArray[hash].addToHead(s);
		}
	}

	/**
	 * Print size of each table
	 */
	public void printSizeOfTable() {
		for (int i = 0; i < hashArray.length; i++) {
			System.out.println(i + " = " + hashArray[i].size());
		}
	}
}