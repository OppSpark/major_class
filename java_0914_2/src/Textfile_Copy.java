import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Textfile_Copy {

	public static void main(String[] args) throws IOException {
		if(args.length != 2) {
			System.out.println("매개변수 부족!!");
			System.exit(0);
		}
		File orgF = new File(args[0]);
		File newF = new File(args[1]);
		int		ch;
		if(!orgF.exists()) {
			System.out.println(args[0]+" 파일 없음..");
			System.exit(0);
		}
		if(!newF.exists()) {
			newF.createNewFile();
		}
		FileReader inf = new FileReader(orgF);
		FileWriter outf = new FileWriter(newF);
		BufferedReader in = new BufferedReader(inf);
		BufferedWriter out = new BufferedWriter(outf);
		while((ch=in.read()) != -1) 
			out.write(ch);
		in.close();
		out.close();
	}
}
