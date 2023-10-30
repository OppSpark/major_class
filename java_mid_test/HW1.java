import java.io.File;
import java.io.FileDescriptor;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.w3c.dom.ls.LSException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class HW1 {
	//public static double FileD = 0;

	public static void main(String[] args) {
		
		File pwd = new File(args[0]); //명령행 인수로 전달된 경로를 File 객체로 생성합니다. 경로를 받아오는 것
		String N1 = new String(args[1]);
		

		if(!pwd.exists() || !pwd.isDirectory()) { //경로가 존재하지 않는다면 오류 출력
			System.out.printf(System.getProperty("user.dir") + "의 경로명 없음");  
			System.exit(0);
		}
		
		
		System.out.println(System.getProperty("user.dir"));// 현제 디렉토리 출력
		search(pwd ,N1, "");  //호출 메서드를 호출하여 디렉토리를 탐색합니다. 초기에는 탭이 없으므로 빈 문자열을 전달합니다.
	}
	
	
	
	// 렉토리를 탐색하는 메서드입니다. Fi는 탐색할 디렉토리를 나타내는 File 객체이고, tap은 탭 문자열로서 디렉토리의 계층 구조를 표현합니다.
	public static void search(File Fi,String N1, String tap) {
		//디렉토리 내의 파일과 디렉토리 목록을 가져옵니다. F i는 위 객체 생성한 것의 PWD
		File[] Flist = Fi.listFiles();
		
		float FileD = 0;
		DateFormat date = new SimpleDateFormat("YYYY-MM-d hh:mm:s (a)");  //날짜
		//파일과 디렉토리를 순회하면서 처리합니다.
		
	
		for(File ls: Flist) {  //현재 요소가 디렉토리인 경우입니다. 디렉토리 이름, 수정일자 등을 출력하고, 재귀적으로 하위 디렉토리를 탐색합니다.
			if(ls.getName().equals(N1))	{
				System.out.printf("%s - %s [%d bytes] (파일)<수정일 : %s>\n",tap ,ls.getName(),ls.length(),date.format(ls.lastModified()));
				FileD += (float)(ls.length());
			}
			
			if(ls.isDirectory() == true) { //디렉토리 출력							ls.getName() 해당 디렉토리의 이름을 번환한다.
				
				search(ls ,N1, tap);  // 하위 디렉토리 텝 !
				
			}
			else{  //현재 요소가 디렉토리인 경우입니다. 디렉토리 이름, 수정일자 등을 출력하고, 재귀적으로 하위 디렉토리를 탐색합니다.
				System.out.printf("%s - %s [%d bytes] (파일)<수정일 : %s>\n",tap ,ls.getName(),ls.length(),date.format(ls.lastModified()));
				FileD += (float)(ls.length());
			}
		}
		
		System.out.println("[X] 확장자가 "+ N1 +" 인 파일의 크기는 총 "+ FileD +"KB 이다");
		
	}

}

	