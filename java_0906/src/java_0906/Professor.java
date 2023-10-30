package java_0906;
public class Professor extends People {
	public Professor(String no, String n, String addr){
	Set(no, n, addr);
	}
	@Override
	public void What2Do() {
		Research2Do();
		System.out.println("나는 교수 (" +this+ ") 이고 강의를 한다.");
	}
	public void Research2Do(){
		System.out.println("연구를 한다.");
	}
} 