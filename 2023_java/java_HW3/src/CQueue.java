import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CQueue<T extends Comparable<T>> {
	private Object[] v;
	private int	f, r, limit;
	
	public CQueue(int s) {
		v = new Object[s];  //생성
		limit = s;  //원형큐 최대값
		f = r = 0;  //초기화
	}
	
	
	public int size() {    //이게 맞나? 추후 검증 필요함!!!!  예외가 있을 수 있음
		if(r >= f) {
			return r - f;  // 리어가 프론트보다 앞에 있는 경우
		}else {
			return limit - f + r;  //프론트가 앞에 있는 경우
		}
	}

	
	public boolean add(T item) {  
		if(f == (r + 1)%limit){  // 원형 큐가 가득 찼는지 비교
			return false;
			
		}else {  //원형큐에 값 삽입
			v[r] = item;
			r = (r+1)%limit;
			return true;
		}
	}
	
	
	public T get() {  
		
		if(f == r) {  //비어있는지 검사
			return null;
		}else {
		return (T)v[f];  //프론트 값 반환
		}
	}
	
	
	public T remove() {  
		if(f == r) {  //비었는지 검사
			return null;
		}else {
			T tmp = (T)v[f];  //리턴 전 값 삭제를 위해 tmp 생성
			f = (f + 1)%limit;  // 값 삭제
			return tmp;  //출력
		}
	}
	
	
	public String toString() {
		String tmp = "";
		int fl = f;
		while(fl != r) {  //출력
			tmp += v[fl];
			fl = (fl + 1) % limit;
		}
		return tmp;
	}
	
	
	public void Sorting(boolean ascending) {
		
		List<T> list = new ArrayList<>(); // 큐 데이터 추출
		for(int i = f; i != r; i = (i + 1) % limit)
		    list.add((T)v[i]);
		
		List<T> list1 = new ArrayList<>();
		for(int i = f; i != r; i = (i + 1) % limit)
		    list1.add((T)v[i]);
		
		if(ascending) // 정렬
		    Collections.sort(list1);
		else
		    Collections.sort(list1, Collections.reverseOrder());

		
		// 원형 큐에 다시 삽입
		int index = f;
		for(T item : list1){
		    v[index] = item;
		    index = (index + 1) % limit;
		}
	}
}
