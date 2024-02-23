
//인터페이스와 abstract class 와 같은점  검색해서 알아볼 
// 인터페이스는 무조건 퍼블릭이다.
interface Activity {
	void Job2Do();
	default void DoIt() {
		System.out.println("do it !");
	}

}
interface StudentActivity extends Activity{
	void Study2Do();
	void Play2Do();
}

interface ProfessorActivity extends Activity{
	void Research2Do();
	void Play2Do();
}

