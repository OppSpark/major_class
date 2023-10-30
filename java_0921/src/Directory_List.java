
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directory_List {
	public static void main(String[] args) throws IOException {
		File f = new File(".");
		File ff = new File(f.getParent(), "bin");
		
		listDir(f,0);
	}
	
	public static void listDir(File f, int level) throws IOException {
		File[] files = f.listFiles();
		String[]	names = f.list();
		String blanks = (level==0) ? "" : String.format("%"+(level*4)+"s", " ");
		DateFormat df = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 s초 (a)");
		List<String> f_list = new ArrayList<>(Arrays.asList(names));
		Collections.sort(f_list);
		
		for(String s: f_list) {
			File	d = new File(f, s);
			System.out.printf("%s%s %s (%d bytes) [%s] [수정된 시간: %s]\n",blanks, 
					d.isDirectory()?"\u21F0":"\u220E",
					d.getName(), d.length(),
					(d.isDirectory() ? "DIR":"FILE"), df.format(d.lastModified()));
			if(d.isDirectory()) {
				listDir(d, level+1);
			}
			
			if(d.getName().contains("FILE")) {
				//File newF = new File(d.getParent(), "__SOFTWARE__");
				d.delete();
			}
		}
	}
}
