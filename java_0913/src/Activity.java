interface Activity {
	void Job2Do();
	default void DoIt() {  //default 
		System.out.println("DoIt");
	}
}

interface StudentActivity extends Activity {
	void Study2Do();
	void Play2Do();
	default void Work2Do() {
		System.out.println("카페에서 알바를 한다.");
	}
}

interface ProfessorActivity extends Activity {  //인터페이스는 extends를 이용해서 상속을 받을 수 있다.
	void Research2Do();
	void Play2Do();
	default void Work2Do() {
		System.out.println("학과 업무를 한다.");
	}
}