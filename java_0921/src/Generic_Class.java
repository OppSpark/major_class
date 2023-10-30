
public class Generic_Class {

	public static void main(String[] args) {
		Sorted_Obj<Integer> sortedInt = new Sorted_Obj();
		Sorted_Obj<People> sortedPeople = new Sorted_Obj();

		System.out.println(sortedInt.Add(10));
		System.out.println(sortedInt.Add(20));
		System.out.println(sortedInt.Add(30));
		System.out.println(sortedInt);
		
		
		System.out.println(sortedPeople.Add(People.getInstance("990951-12345667", "라마바" ,"울산시 남구")));
		System.out.println(sortedPeople.Add(People.getInstance("020921-12345667", "가나다", "부산시 남구")));
		System.out.println(sortedPeople.Add(People.getInstance("020921-12345667", "가나다", "부산시 남구")));
		System.out.println(sortedPeople);
		
	}

}

class Sorted_Obj <T extends Comparable<T>>{
	T a, b;
	
	public Sorted_Obj() {
		a = b = null;
	}
	
	public boolean Add(T e) {
		if(a==null) a = e;
		else {
			if(b==null) {
				if(a.compareTo(e) > 0) {
					b = a;
					a = e;
				}
				else {
					b = e;
				}
			}
			else return false;
				
		}
		return true;
	}
	
	public String toString() {
		String tmp = "";
		tmp += a +", "+ b;
		return tmp;
		
		
	}
	
}
