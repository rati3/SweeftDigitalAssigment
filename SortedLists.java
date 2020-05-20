package sweeftDigital_sortedList;

import java.util.ArrayList;

public class SortedLists implements SortedList {
	
	/* Constructor */
	public SortedLists() {
		list = new ArrayList<>();
	}
	
	
	@Override
	public void add(int element) {
		int index = getIndexToAdd(element, 0, size() - 1);
		list.add(index, element);
	}


	@Override
	public int size() {
		return list.size();
	}


	@Override
	public boolean isEmpty() {
		return size() == 0;
	}


	@Override
	public boolean remove(int element) {
		int index = getIndex(element, 0, size() - 1);
		if (index == -1)
			return false;
		list.remove(index);
		return true;
	}
	
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < size(); i++) {
			int n = list.get(i);
			result = result + n + ",";
		}
		if (result.length() > 0)
			result = result.substring(0,result.length() - 1);
		return result;
	}



	/**
	 * returns index of element if it presents from start to end inclusive.
	 * otherwise return -1
	 */
	private int getIndex(int elem, int start, int end) {
		if (start > end) // Base Case : can not found the element
			return -1;

		int midIndex = (start + end) / 2;
		int mid = list.get(midIndex);

		if (elem == mid)
			return midIndex;

		if (elem < mid)
			return getIndex(elem, start, midIndex - 1);

		// if element > mid
		return getIndex(elem, midIndex + 1, end);

	}

	
	/** returns index to insert element & that keeps list sorted */
	private int getIndexToAdd(int elem, int start, int end) {
		if (start >= end) {
			if (elem > list.get(start))
				return start + 1;
			return start;
		}

		int midIndex = (start + end) / 2;
		int mid = list.get(midIndex);

		if (elem == mid)
			return midIndex;

		if (elem < mid)
			return getIndexToAdd(elem, start, midIndex - 1);

		// if element > mid
		return getIndexToAdd(elem, midIndex + 1, end);

	}

	/** list to save integers */
	private ArrayList<Integer> list;

	
	
}
