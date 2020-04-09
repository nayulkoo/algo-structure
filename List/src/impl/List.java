package impl;
public abstract class List<T extends Object> {

	protected Integer size;
	protected Integer cursor;

	public abstract void init();

	protected abstract void expand();

	public abstract void insert(T data);

	public abstract T first();

	public abstract T next();

	public abstract void remove();

	public Integer size() {
		return size;
	}

}