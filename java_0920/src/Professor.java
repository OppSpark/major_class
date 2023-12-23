
public class Professor extends People implements ProfessorActivity {
	protected String	position;
	private static	String[] pos = {"조","부","정"};
	public Professor(String no, String n, String addr, String p) {
		Set(no, n, addr);
		position = p;
	}
	public static String getPosition() {
		return pos[Rand.r(0, pos.length-1)];
	}
	@Override
	public void What2Do() {
		Research2Do();
		Job2Do();
		Work2Do();
		System.out.println("-- 나는 "+position+"교수("+this+")이고 강의를 한다.");
	}

	@Override
	public void Job2Do() {
		System.out.print("프로젝트를 한다.");
	}

	@Override
	public void Research2Do() {
		System.out.print("연구를 한다.");
	}
	@Override
	public void Play2Do() {
		System.out.print("테니스를 한다.");
	}
}