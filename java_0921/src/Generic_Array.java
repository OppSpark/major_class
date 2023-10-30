import javax.print.attribute.Size2DSyntax;

public class Generic_Array {

	public static void main(String[] args) {
		Sorted_Array<Integer> sortedInt = new Sorted_Array<>(4);
		Sorted_Array<People> sortedPeople = new Sorted_Array<>(4);

		System.out.println(sortedInt.Add(22));
		System.out.println(sortedInt.Add(7));
		System.out.println(sortedInt.Add(30));
		System.out.println(sortedInt.Add(5));
		System.out.println(sortedInt.Add(50));
		System.out.println(sortedInt);
		
		
		System.out.println(sortedPeople.Add(People.getInstance("020921-12345667", "라마바" ,"울산시 남구")));
		System.out.println(sortedPeople.Add(People.getInstance("020921-12345667", "가나다", "부산시 남구")));
		
		System.out.println(sortedPeople);
		
	}

}

class Sorted_Array <T extends Comparable<T>>{
	
	Object[] arr;
	int idx;
	
	public Sorted_Array(int size) {
		arr = new Object[size];
		idx = 0;  //   다음에 저장될 위치
	}
	public boolean Add(T e) {
		int i;
		
		if(idx >= arr.length) return false;
		
		if(idx == 0) {
			arr[0] = e;
		}else {
		for(i = idx; i > 0; i--) {
			T tmp = (T)arr[i -1];
 			if(tmp.compareTo(e) > 0) {
 				arr[i] = arr[i -1];
 			} else {
 				break;
			}
		}
		arr[i] = e;
		}
		idx++;
		return true;
	}
	
	public String toString() {
		String tmp = "";
	//	tmp += a +", "+ b;
		tmp += arr[0] +", "+ arr[1];
		return tmp;
	}
}
