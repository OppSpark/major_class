public abstract class People {  //abstract 라서 People 클래스에서는 타 클래스 생성 불가
	private String ssNo, name, address;
	// private를 사용함 private는 People class에서만 업급을 가능
	public void Set(String no, String n, String addr) {
		ssNo = no; name = n; address = addr;
	}
	public abstract void What2Do();  //바디 없기에 다른곳에서 바디 코딩을 해줘야함.  그래서Professor, Student 
	
	public String toString() {  // 스트링을 toString 으로 변환해서 출력해주는 
		return String.format("[%s] 주민등록번호:%s 주소:%s", name,ssNo,address);
		//format 를 이 
	}
	public static People getInstance(String no, String n, String addr) {

		switch (Rand.r(1, 100)%3) {
		case 0:
			return new Student(no, n, addr, Student.getposition());
		case 1: 
			return new Professor(no, n, addr, Professor.getposition());
		case 2:
			return new Assistant(no, n, addr, Assistant.getposition());
		default:
			return null;
		}
	}
}