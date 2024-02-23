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
		// 반지름, 색상 순으로 비교
		return 0;
	}
}
