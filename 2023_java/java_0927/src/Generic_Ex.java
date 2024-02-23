
public class Generic_Ex {

	public static void main(String[] args) {
		Integer	i1 = 10, i2 = 20, arr[] = new Integer[2];
		getArray(i1, i2,arr);
		for(Integer i: arr)
			System.out.println("("+i+")");
		
		System.out.println(getMax(i1, i2));
	}
	
	public static <T extends Comparable<T>> T getMax(T a, T b) {
		T	max;
		
		if(a.compareTo(b) > 0) max = a;
		else max = b;
		
		return max;
	}
	
	public static <T> void getArray(T a, T b, T[] arr) {
		Object[] tmp = new Object[2];
		
		arr[0] = a;
		arr[1] = b;
	}
	
	
	
	
	
	
	
	
	
}
