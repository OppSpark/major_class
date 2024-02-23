
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagePeople {
	public static void main(String[] args) throws FileNotFoundException {
		List<People> pList = new ArrayList<>();
		String	no, name, address;
		File	inf = new File("p_1000.txt");
		Scanner	in = new Scanner(inf);
		in.useDelimiter("\\|");
		
		while(in.hasNext()) {
			no = in.next();
			name = in.next();
			in.next();in.next();in.next();
			address = in.next();
			in.nextLine();
			pList.add(People.getInstance(no, name, address));
		}
		in.close();
		
		pList.forEach(m->{System.out.print("\u272a ");m.What2Do();});
	}
}