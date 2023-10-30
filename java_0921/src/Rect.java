public class Rect implements Comparable<Rect> {
	int width;
	int height;
	String color;
	
	public Rect(int width, int height, String color) {
		this.width = width; 
		this.height = height;
		this.color = color;
	}
	
	public String toString() {
		return "Rect("+Integer.toString(width)+","+Integer.toString(height)+",\""+color+"\")";
	}

	@Override
	public int compareTo(Rect o) {
		// Rect 객체를 비교 가로, 세로, 색상 순으로 비교
		return 0;
	}
}
