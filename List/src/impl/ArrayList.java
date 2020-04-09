package impl;
public class ArrayList<T> extends List<T> {

	private static final int DEFAULT_LEN = 50;
	private static final int EXPAND_LEN = 100;

	private T[] ar;

	public ArrayList() {
		init();
	}

	@Override
	public void init() {
		ar = (T[]) new Object[DEFAULT_LEN];
		size = 0;
		cursor = 0;
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
	public void insert(T data) {
		if (size >= ar.length) {
			expand();
		}
		ar[size] = (T) data;
		size = size + 1;
	}

	@Override
	public T first() {
		if (size == 0) {
			return null;
		}
		cursor = 0;
		return ar[(int) cursor];
	}

	@Override
	public T next() {
		if (cursor >= size - 1) {
			return null;
		}
		cursor = (int) cursor + 1;
		return ar[(int) cursor];
	}

	@Override
	public void remove() {
		for (int i = cursor; i < size - 1; i++) {
			ar[i] = ar[i + 1];
		}
		size = size - 1;
		cursor = cursor - 1;
	}

}
