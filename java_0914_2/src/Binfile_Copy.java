import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binfile_Copy {

	public static void main(String[] args) throws IOException {
		if(args.length != 2) {
			System.out.println("매개n변수 부족!!");
			System.exit(0);
		}
		File orgF = new File(args[0]);
		File newF = new File(args[1]);
		byte[]	buffer = new byte[4096];
		int		size;
		if(!orgF.exists()) {
			System.out.println(args[0]+" 파일 없음..");
			System.exit(0);
		}
		if(!newF.exists()) {
			newF.createNewFile();
		}
		FileInputStream inf = new FileInputStream(orgF);
		FileOutputStream outf = new FileOutputStream(newF);
		BufferedInputStream in = new BufferedInputStream(inf);
		BufferedOutputStream out = new BufferedOutputStream(outf);
		while((size=in.read(buffer)) != -1) 
			out.write(buffer, 0, size);
		in.close();
		out.close();
	}
}
