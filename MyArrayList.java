import java.util.Arrays;

/**
 * 
 * This class provides custom implementation of ArrayList(without using java api's) 
 * Insertion order of objects is maintained.
 * Implementation allows you to store null as well.
 * Implementation allows you to store duplicate value as well.
 * 
 */
public class MyArrayList {
	// Define INITIAL_CAPACITY, size of elements of custom ArrayList
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] object;
	private int currentSize = 0;

	/**
	 *
	 * constructor of MyArrayList
	 */
	public MyArrayList() {
		object = new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Ensure capacity of MyArrayList.
	 *
	 * Method increases capacity of list by oldSize + (oldSize >> 1).
	 */
	private void increaseListSize() {
		int oldSize = object.length;
		int newSize = oldSize + (oldSize >> 1);
		object = Arrays.copyOf(object, newSize);
	}

	/**
	 * add elements in MyArrayList Method adds elements in ArrayListCustom.
	 */
	public void add(Object value) {
		if ((object.length - currentSize) <= 0) {
			increaseListSize();
		}
		object[currentSize++] = value;
	}

	/**
	 * method returns element on specific index.
	 */
	public Object get(int index) {
		if (currentSize > index)
			return object[index];
		else
			throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * method returns current size of the CustomArraylist.
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * remove elements from customArrayList method returns
	 *
	 * removedElement on specific index. else it throws IndexOutOfBoundException if
	 * index is negative or greater than size of size.
	 */
	public Object remove(int index) {
		if (index < currentSize) {
			Object obj = object[index];
			object[index] = null;
			int tmp = index;
			while (tmp < currentSize) {
				object[tmp] = object[tmp + 1];
				object[tmp + 1] = null;
				tmp++;
			}
			currentSize--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	public static void main(String args[]) {
		MyArrayList arrayList = new MyArrayList();
		arrayList.add(new Integer(10));
		arrayList.add(new Integer(20));
		arrayList.add(new Integer(30));
		arrayList.add(new Integer(40));
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		arrayList.add(new Integer(50));
		System.out.println("\nAfter adding the value of 50 ");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println("\nElement at Index 3 = " + arrayList.get(3));
		System.out.println("Removing element at index 2 =  " + arrayList.remove(2));
		System.out.println("After removing the element at index 2 ");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
	}

}
