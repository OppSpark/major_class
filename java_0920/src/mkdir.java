import java.io.File;

public class mkdir {

	public static void main(String[] args) {
		String name = "_file_";
		File curDir = new File(".");
		
		for(int i = 0; i < 20; i++) {
			File f = new File(curDir, name + i);
			
			f.mkdir();
			
		}
		
	}

}
