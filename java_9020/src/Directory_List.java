
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directory_List {
	public static void main(String[] args) {
		File f = new File(".");
		File ff = new File(f.getParent(), "bin");
		
		listDir(f, 0);
	}
	
	public static void listDir(File f, int level) {
		File[] files = f.listFiles();
		String[] names = f.list();   //알파벳 순서로 정렬 방
		
		
		String blanks = String.format("%s"+(level*3)+"s"," ");
		
		DateFormat df = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 s초 (a)");
		
		List<String> f_list = new  ArrayList<>(Arrays.asList(names));
		Collections.sort(null);
		
		for(String s: f_list) {
			File d = new File(f,s);
		
		
			System.out.printf("%s %s (%d bytes) [%s] [수정된 시간: %s] ~ %s \n", blanks ,d.getName(), d.length(),
					(d.isDirectory() ? "DIR":"FILE"), df.format(d.lastModified()), d.getAbsolutePath() );
		}
		if(d.isDirectory()) {
			listDir(d, level +1);
		}
			
			if(d.getName().equalsIgnoreCase("p_10.txt")) {
				File newF = new File(d.getParent(), "X");
				d.renameTo(newF);
				
			}
			
		}
	}

