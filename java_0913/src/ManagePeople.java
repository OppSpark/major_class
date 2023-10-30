import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class ManagePeople {
	public static void main(String[] args) throws FileNotFoundException {
		List<People> pList = new ArrayList<>();
		String	no, name, address;
		File	inf = new File("p_10.txt");
		Scanner	in = new Scanner(inf);
		in.useDelimiter("\\|");
		
		Activity act = new Activity() {
			String name = "Kyungsung";
			
			@Override
			public void Job2Do() {
				System.out.println("Job2Do() : " +name);
				
			}
		};
		
		Activity act2 = () -> {  // 람다식을 이용해 익명 객체 만들 때는 인터페이스에 추상 메소드가 하나만 있어야
			System.out.print("====");
			System.out.println("Job2Do()2");
		};
		act.DoIt();
		act.Job2Do();
		act2.Job2Do();
		
		
		
		
		
		
		
		/*
		 while(in.hasNext()) {
			no = in.next();
			name = in.next();
			in.next();in.next();in.next();
			address = in.next();
			in.nextLine();
			pList.add(People.getInstance(no, name, address));
		}
		in.close();
		
		 */
		
		
		
		
		
		
		
		
		
		/*
		 	pList.forEach(People::What2Do);  // 클래스명 :: 메소드 이름    :: 을 이용하는 방식
		 	List.forEach(m -> m.What2Do());   ///람다식을 이용
			pList.forEach(m -> {System.out.println("***");m.What2Do();});  //대괄호를 으면  문장이 들어가야함
		  	for(People p:pList)   //forEach를 이용
			p.What2Do();
			
		for(int i = 0; i < pList.size(); i++) { //전통적인 스타일
			pList.get(i).What2Do();
		}
		*/
	}
}
