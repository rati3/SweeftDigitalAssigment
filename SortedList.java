package sweeftDigital_sortedList;

public interface SortedList {
	
	/** adds element at list*/
	public void add(int element);
	
	/** returns size of list */
	public int size();
	
	/** returns if list is empty */
	public boolean isEmpty();
	
	/** removes element from list. if the element is not present return false */
	public boolean remove(int element);
	
	/** returns the string consisting of the above elements separated by a comma */
	public String toString();
}
