public class CQueue<T extends Comparable<T>> {
	private Object[] v;
	private int	f, r, limit;
	
	public CQueue(int s) {
		v = new Object[s];
		
		limit = s;
	}
	
	public int size() {
		return -1;
	}
	
	public boolean add(T item) {
		
		return true;
	}
	
	public T get() {
		return null;
	}
	
	public T remove() {
		
		return null;
	}
	
	public String toString() {
		String tmp = "";
		
		return tmp;
	}
	
	public void Sorting(boolean ascending) {
		
	}
}
