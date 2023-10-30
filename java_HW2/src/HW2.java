import java.io.File;
import java.io.IOException;
public class HW2 {
	static boolean check = false; //N1 검사용
	public static void main(String[] args) throws IOException {
		
		File pwd = new File(args[0]);	  //경로 
		String N1 = new String(args[1]);  //N1
		String N2 = new String(args[2]);  //N2
		
		if(!pwd.exists() || !pwd.isDirectory()) {  //디렉토리 경로가 있는지 판별
			System.out.println(pwd.getPath() + "의 디렉토리를 찾을 수 없음!!!");
			System.exit(0);
		}
		
		ChangeDir(pwd,N1,N2); //호출
		
		if (check == false){  //N1 이 있는지 없는지 판별
	       	System.out.printf(N1+"를 검색할 수 없음");
	       	}
	}
	
	public static void ChangeDir(File pwd, String N1, String N2) {
		
		File[] pwdN1 = pwd.listFiles();
		
		if(pwdN1 != null) {
			for(File lsFile : pwdN1) {
				if(lsFile.isDirectory()){
					ChangeDir(lsFile,N1,N2);
				}
			if (lsFile.getName().equals(N1)) {
				System.out.print(lsFile.getAbsolutePath()+"를 ");
				File changeFile = new File(lsFile.getParent(), N2);
                lsFile.renameTo(changeFile);
                System.out.printf("%s 로 변경함 %s%n", changeFile.getAbsolutePath(), changeFile.isDirectory() ? "[디렉토리]" : "[파일]");
                check = true;
				}	
			}
		}
	}
}
		
		
		

