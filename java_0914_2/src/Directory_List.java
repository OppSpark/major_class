import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Directory_List {
	public static void main(String[] args) {
		File f = new File(".");
		File ff = new File(f.getParent(), "bin");
		
		listDir(f);
	}
	
	public static void listDir(File f) {
		File[] files = f.listFiles();
		DateFormat df = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 s초 (a)");
		for(File d: files) {
			System.out.printf("%s (%d bytes) [%s] [수정된 시간: %s]\n", d.getName(), d.length(),
					(d.isDirectory() ? "DIR":"FILE"), df.format(d.lastModified()) );
			if(d.getName().equalsIgnoreCase("output.txt")) {
				File newF = new File(d.getParent(), "output.txt19");
				d.renameTo(newF);
			}
		}
	}
}
