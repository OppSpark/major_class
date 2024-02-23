import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class binfile_Copy {

	public static void main(String[] args) throws IOException{
		
		if(args.length != 2) {
			System.out.println(" 메게 변수가 부족!");
			System.exit(0);
		}
		File orgF = new File(args[0]);
		File newF = new File(args[1]);
		
		byte[] buffer = new byte[1024];
		int size;
		
		
		
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
		FileInputStream inf = new FileInputStream(orgF);
		FileOutputStream outf = new FileOutputStream(newF);
		
		BufferedInputStream in = new BufferedInputStream(inf);
		BufferedOutputStream in = new BufferedOutputStream(outf);
		
		
		
		//BufferedReader in = new BufferedReader(inf);
		//BufferedWriter out =  new BufferedWriter(outf);
		
		while((size=inf.read(buffer)) != - 1)
			outf.write(buffer,0,size);
		inf.close();
		outf.close();
	}
	

}
