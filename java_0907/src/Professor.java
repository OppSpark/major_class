import java.nio.file.attribute.PosixFilePermission;

public class Professor extends People implements ProfessorActivity{
	// implements  >> 이것인터페이스 Activity 메소드를 이용허갰더.
	protected String position;
	private static  String[] pos = {"조","부","정"};
	public Professor(String no, String n, String addr, String p){
		Set(no, n, addr);
		position = p;
	}
	
	public static String getposition() {
		return pos[Rand.r(0,pos.length -1)];
	}
	
	@Override
	public void What2Do() {
		Research2Do();
		Job2Do();
		Play2Do();
		System.out.println("나는 " +position+ "교수 ("+this+")이고 강의를 한다.");
	}
	@Override
	public void Job2Do() {
		// TODO Auto-generated method stub
		System.out.print("프로젝트를 한다. ");
	}
	@Override
	public void Research2Do(){
		System.out.print("연구를 한다. ");
	}
	@Override
	public void Play2Do() {
		// StudnetActivity.super.Play2Do();
		System.out.print("테니스를 한다. ");
		
	}
}
	