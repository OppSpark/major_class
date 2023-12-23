
interface Activity {
	void Job2Do();
	default void DoIt() {
		System.out.println("DoIt");
	}
}

interface StudentActivity extends Activity {
	void Study2Do() ;
	void Play2Do();
	default void Work2Do() {
		System.out.println("카페 알바를 한다.");
	}
}

interface ProfessorActivity extends Activity {
	void Research2Do();
	void Play2Do();
	default void Work2Do() {
		System.out.println("학과 업무를 한다.");
	}
}