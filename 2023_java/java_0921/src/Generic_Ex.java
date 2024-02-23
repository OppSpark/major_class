
public class Generic_Ex {
	public static void main(String[] args) {
		
		People p1 = People.getInstance("020921-12345667", "가나다", "부산시 남구");
		People p2 = People.getInstance("990951-12345667", "라마바" ,"울산시 남구");
		
		Integer i1 = 10, i2 = 20;
		
		//printSUM(p1, p2);
	
		for(Integer integer[] :)  printSUM(i1, i2)
			System.out.pruntln("("+i+")");
		System.out.println(getMax(i1, i2));
		System.out.println(getMax(p1, p2));
		
	}
	
	public static <T extends Comparable<T>> T getMax(T a, T b) {
		
		T max;
		
		if(a.compareTo(b)> 0) max = a;
		else max =b;
		
		
		return max;
		
		
	}
	
	

	public static <T> Object[] printSUM(T a, T b) {
		
		Object[]  tmp = new Object()[2];
		
		
		tmp[0] = a;
		tmp[1] = b;
		return (T[]) tmp;   // 중요함 개중요함
		
		
	}
}
