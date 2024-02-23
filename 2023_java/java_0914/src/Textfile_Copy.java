import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Textfile_Copy {

	public static void main(String[] args) throws IOException{
		
		if(args.length != 2) {
			System.out.println(" 메게 변수가 부족!");
			System.exit(0);
		}
		File orgF = new File(args[0]);
		File newF = new File(args[0]);
		
		
		//File orgF = new File("input.txt");
		//File newF = new File("output.txt");
		int ch;

		if(!orgF.exists()) {
			System.out.println("input.txt 파일 없음");
			System.exit(0);
		}
		
		if(!newF.exists()) {
			newF.createNewFile();
		}
		FileReader inf = new FileReader(orgF);File orgF = new File(args[0]);
		FileWriter outf = new FileWriter(newF);
		BufferedReader in = new BufferedReader(inf);
		BufferedWriter out =  new BufferedWriter(outf);
		
		while((ch=inf.read()) != - 1)
			outf.write(ch);
		inf.close();
		outf.close();
	}
	

}
