import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ManagePeople {
	public static void main(String[] args) throws FileNotFoundException {
		Vector<People> vlist = new Vector<>();
		String no, name, addr;
		File f = new File("p_10.txt");
		//People p;
		if(!f.exists()) {
			System.out.println("file not fount ");
			System.exit(0);
		}
		
		Scanner in = new Scanner(f);
		in.useDelimiter("\\|");
		while(in.hasNext()) {
			no = in.next();
			name = in.next();
			in.next(); in.next(); in.next();
			addr = in.next();
			in.nextLine();
			vlist.add(People.getInstance(no, name, addr));
		}
		
		in.close();
		for(People pp:vlist) {
			pp.What2Do();
		}
				
	}

}
