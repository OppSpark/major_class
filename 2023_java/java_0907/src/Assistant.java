
public class Assistant extends Professor implements ProfessorActivity, StudentActivity{  
	// implement 인터페이스를 상속하는 것 ,extends 는 하나의 슈퍼클래스만 받을 수 지만, implements은 여러가지를 슈퍼클래스로 상속 가능함
	// implements  >> 이것인터페이스 Activity 메소드를 이용허갰더.
	private static  String[] pos = {"연구","행정","전산"};
	
	
	public Assistant(String no, String n, String addr, String p){
		super(no, n, addr, p);
	}
	
	public static String getposition() {
		return pos[Rand.r(0,pos.length -1)];
	}

	
	@Override
	public void What2Do() {
		Job2Do();
		Study2Do();
		Research2Do();
		System.out.println("나는 " +position+ "조교("+this+")이고 강의 지원을 한다. ");
	}
	@Override
	public void Job2Do() {
		// TODO Auto-generated method stub
		System.out.print("프로젝트 연구를 한다. ");
	}
	
	public void Research2Do(){
		System.out.print("논문 연구를 한다. ");
	}
	@Override
	public void Study2Do() {
		// TODO Auto-generated method stub
		System.out.print("학위 논문 준비를 한다. ");
		
	}
}