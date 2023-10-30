package java_0906;
public abstract class People { 
	private String ssNo, name, address;

	public void Set(String no, String n, String addr) {
		ssNo = no; name = n; address = addr;
	}

	public abstract void What2Do();
	public String toString() {
		return String.format("[%s] 주민등록번호 : %s , 주소 : %s", name, ssNo, address);
	}
}