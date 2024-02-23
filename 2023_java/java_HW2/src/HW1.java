import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class HW1 {

	public static void main(String[] args) {
		
		File pwd = new File(args[0]); //경로 
		
		if(!pwd.exists() || !pwd.isDirectory()) { //경로가 존재하지 않는다면 오류 출력
			System.out.printf(System.getProperty("user.dir") + "의 경로는 존재하지 않음!!");  
			System.exit(0);
		}
		
		System.out.println(System.getProperty("user.dir") + " 디렉토리의 내용");// 현제 디렉토리 출력
		search(pwd ,"");  //호출
	}
	
	public static void search(File Fi, String tap) {
		File[] Flist = Fi.listFiles();
		
		DateFormat date = new SimpleDateFormat("YYYY-MM-d hh:mm:s (a)");  //날짜
		
		for(File ls: Flist) {
			if(ls.isDirectory() == true) { //디렉토리 출력
				System.out.printf("%s \u27A5 %s (디렉토리) [수정일 : %s]\n",tap ,ls.getName(),date.format(ls.lastModified())); 
				search(ls ,tap+"    ");  // 하위 디렉토리 텝 !
				
			}
			else{  //파일 출력
				System.out.printf("%s \u27A5 %s <%d bytes> (파일)[수정일 : %s]\n",tap ,ls.getName(),ls.length(),date.format(ls.lastModified()));
			}
		}
	}
}
