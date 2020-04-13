package impl;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collection;
import java.util.Iterator;

public class ArrayList<T> extends List<T> {

	private static final int DEFAULT_LEN = 50;
	private static final int EXPAND_LEN = 100;

	private T[] ar;

	public ArrayList() {
		clear();
	}

	@Override
	public void clear() {
		ar = (T[]) new Object[DEFAULT_LEN];
		size = 0;
	}

	@Override
	protected void expand() {
		int newSize = size + EXPAND_LEN;
		T[] temp = (T[]) new Object[newSize];
		for (int i = 0; i < ar.length; i++) {
			temp[i] = ar[i];
		}
		ar = temp;
	}

	@Override
	public boolean add(T data) {
		if (size >= ar.length) {
			expand();
		}
		ar[size] = (T) data;
		size++;
		
		return true;
	}
	
	@Override
	public void add(int index, T data) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(String.format("Index : %d, Size : %d", index, size));
		}
		if (size >= ar.length) {
			expand();
		}
		for (int i = size; i > index; i--) {
			if (size > 0) {
				ar[i] = ar[i - 1];
			}
		}
		ar[index] = (T) data;
		size++;
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		Iterator<? extends T> iter = c.iterator();
		while (iter.hasNext()) {
			add(iter.next());
		}
		
		return true;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(String.format("Index : %d, Size : %d", index, size));
		} else if (index == size) {
			return addAll(c);
		}
		
		while (ar.length <= size + c.size()) {
			expand();
		}
		for (int i = size - 1; i >= size - c.size() - 1; i--) {
			ar[i + c.size()] = ar[i];
		}
		Iterator<? extends T> iter = c.iterator();
		int offset = 0;
		while (iter.hasNext()) {
			ar[index + offset++] = iter.next();
		}
		size += c.size();
		
		return true;
	}
	
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(String.format("Index : %d, Size : %d", index, size));
		}
		return ar[index];
	}
	
	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (ar[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		int last = -1;
		for (int i = 0; i < size; i++) {
			if (ar[i].equals(o)) {
				last = i;
			}
		}
		return last;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private int cursor = 0;
			
			@Override
			public boolean hasNext() {
				return cursor < size && ar[cursor] != null;
			}
			
			@Override
			public T next() {
				return ar[cursor++];
			}
			
			@Override
			public void remove() {
				throw new UnsupportedAddressTypeException();
			}
		};
	}
	
	@Override
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(String.format("Index : %d, Size : %d", index, size));
		}
		for (int i = index; i < size - 1; i++) {
			ar[i] = ar[i + 1];
		}
		size--;
		ar[size] = null;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		for (int i = 0; i < size; i++) {
			buf.append(ar[i]);
			if (i < size - 1) {
				buf.append(", ");
			}
		}
		buf.append("]");
		return buf.toString();
	}

}
