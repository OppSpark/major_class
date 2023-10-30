public abstract class People {
	private String ssNo, name, address;
	
	public void Set(String no, String n, String addr) {
		ssNo = no; name = n; address = addr;
	}
	public abstract void What2Do();
	public String toString() {
		return String.format("[%s] 주민등록번호:%s 주소:%s", name,ssNo,address);
	}
	public static People getInstance(String no, String n, String addr) {
		switch (Rand.r(1, 100)%3) {
		case 0:
			return new Professor(no, n, addr, Professor.getPosition());
		case 1:
			return new Student(no, n, addr, Student.getDepartment());	
		case 2:
			return new Assistant(no, n, addr, Assistant.getPosition());
		default:
			return null;
			
		}
	}
}