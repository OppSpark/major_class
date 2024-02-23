import java.io.File;

public class MKdir {

	public static void main(String[] args) {
		String	name = "_FILE_";
		File	curDir = new File(".");
		
		for(int i=0;i<10;i++) {
			File f = new File(curDir, name+i);
			f.mkdir();
			curDir = f;
		}
	}

}
