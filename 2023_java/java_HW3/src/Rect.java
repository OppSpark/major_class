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
		
		int  wid1 = width;
		int  wid2 = o.width;
		
		int  hei1 = height;
		int  hei2 = o.height;
		
		if(wid1 == wid2) {  
			if(hei1 == hei2) {
				return color.compareTo(o.color)* -1;  //문자열 비교 
			}else {
			return hei1 - hei2; //세로 비교
			}
			
		}else {
			return wid1 - wid2;  //가로 비교  
		}
		
		// Rect 객체를 비교 가로, 세로, 색상 순으로 비교
	}
}
