public class Assistant extends Professor implements ProfessorActivity, StudentActivity {
	private static	String[] pos = {"연구","행정","전산"};
	public Assistant(String no, String n, String addr, String p) {
		super(no, n, addr, p);
	}
	public static String getPosition() {
		return pos[Rand.r(0, pos.length-1)];
	}
	@Override
	public void What2Do() {
		Job2Do();
		Study2Do();
		Research2Do();
		Work2Do();
		System.out.println("나는 "+position+"조교("+this+")이고 강의 지원을 한다.");
	}

	@Override
	public void Job2Do() {
		System.out.print("프로젝트 연구원을 한다.");
	}

	@Override
	public void Research2Do() {
		System.out.print("논문 연구를 한다.");
	}
	@Override
	public void Study2Do() {
		System.out.print("학위 논문 준비를 한다.");
	}
	@Override
	public void Play2Do() {
		//StudentActivity.super.Play2Do();
		System.out.print("테니스를 한다.");
	}
	@Override
	public void Work2Do() {
		StudentActivity.super.Work2Do();
		ProfessorActivity.super.Work2Do();
		// System.out.println("실습 보조 업무를 한다.");
	}
}