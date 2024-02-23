import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Directory_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(".");
		File ff = new File(f.getParent(),"bin");
 		
		
		
		
		listDir(f);
		
	}
	
	
	public static void listDir(File f) {
		File[] files = f.listFiles();
		DateFormat df = new SimpleDateFormat("YYYY년 M월 d일 h시 m분 s초(a)");
 		
		for(File d: files) {
			System.out.printf("%s (%d bytes) [%s]\n", d.getName(),d.length(),
				(d.isDirectory() ? "DIR" : "File" ), df.format(d.lastModified()) );
			
			if(d.getName().equalsIgnoreCase("output.txt")) {
				File newF = new File(d.getParent(), "output.txt9");
				d.renameTo(newF);
			}
		}
		
	}

}
