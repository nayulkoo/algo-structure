package impl;

import java.util.Collection;
import java.util.Iterator;

public abstract class List<T extends Object> implements Cloneable {

	protected Integer size;
	protected Integer cursor;

	public abstract void clear();
	protected abstract void expand();

	public abstract boolean add(T data);
	public abstract void add(int index, T data);
	public abstract boolean addAll(Collection<? extends T> c);
	public abstract boolean addAll(int index, Collection<? extends T> c);

	public abstract T get(int index);
	public abstract int indexOf(Object o);
	public abstract int lastIndexOf(Object o);
	
	public abstract void set(int index, T data);
	
	public abstract boolean isEmpty();
	public abstract Iterator<T> iterator();
	@Override
	public List<T> clone() throws CloneNotSupportedException {
		return (List<T>) super.clone();
	}
	
	public abstract boolean contains(T data);
	
	public abstract T[] toArray();
	public abstract T[] toArray(T[] arr);
	
	public abstract void trimToSize();

	public abstract void remove(int index);

	public Integer size() {
		return size;
	}

}