public class Circle implements Comparable<Circle> {
	int radius;
	String color;
	
	public Circle(int r, String color) {
		radius = r;
		this.color = color;
	}
	
	public String toString() {
		return "Circle("+radius+",\""+color+"\")";
	}

	@Override
	public int compareTo(Circle o) {

		
		int radi1 = radius;
		int radi2 = o.radius;
		
	
		if(radi1 == radi2) {
		return color.compareTo(o.color)* -1;  // 반지름이 같다면 색상 스트링으로 비교  
		}else {  
			return radi1 - radi2 ;
		}
	
		
		// 반지름, 색상 순으로 비교
	}
}
