import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class ManagePeople {
	public static void main(String[] args) throws FileNotFoundException {
		List<People> pList = new ArrayList<>();
		String	no, name, address;
		File	inf = new File("p_10.txt");
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
		
		Collections.sort(pList);
		pList.forEach(p->{System.out.print("*** "); p.What2Do();System.out.println("*** ");});
		
		
		
		/*
		 pList.forEach(People::What2Do);
		for(People p:pList)
			p.What2Do();
		for(int i=0;i < pList.size();i++) {
			pList.get(i).What2Do();
		}
		 */
		
		
	}
}
