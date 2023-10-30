public class Student extends People implements StudentActivity{
	private String department;
	private static String[] depts = {"소프트웨어학과","전자공학과", "자동차공학과", "산업공학과"};
	
	public static String getposition() {
		return depts[Rand.r(0,depts.length -1)];
	}
	
	public Student(String no, String n, String addr, String dept) {
		Set(no, n, addr);
		department = dept;
	}
	@Override
	public void What2Do() {
		Study2Do();
		Job2Do();
		System.out.println("나는 "+department+"학생 ("+this+")이고 공부를 한다.");
	}
	
	
	@Override
	public void Job2Do() {
		// TODO Auto-generated method stub'
		System.out.print("동아리 활동을 한다.");
		
	}
	@Override
	public void Study2Do() {
			System.out.print("시험공부를 한다.");
		// TODO Auto-generated method stub
		
	}
	public void DoIt() {
		System.out.println("do it!(학생)");
	}
	@Override
	public void Play2Do() {
		// TODO Auto-generated method stub
		System.out.print("게임을 한다.");
		
	}
}