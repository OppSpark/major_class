package java_0906;
public class Student extends People {
	public Student(String no, String n, String addr){
		Set(no, n , addr);
}
	@Override
	public void What2Do() {
		Research2Do();
		System.out.println("나는 학생 (" +this+ ") 수업을 한다.");
	}	
	public void Research2Do(){
		System.out.println("시험공부를 한다.");
	}
}