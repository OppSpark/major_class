
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ManagePeople {
	public static void main(String[] args) throws FileNotFoundException {
		List<People> pList = new ArrayList<>();
		
		HashMap<String, People> p_HM = new HashMap<>();
		
		String	no, name, address;
		File	inf = new File("p_100.txt");
		Scanner	in = new Scanner(inf);
		in.useDelimiter("\\|");
		
		
		
		while(in.hasNext()) {
			no = in.next();
			name = in.next();
			in.next();in.next();in.next();
			address = in.next();
			in.nextLine();
			//pList.add(People.getInstance(no, name, address));
			p_HM.put(no, People.getInstance(no, name, address));
		}
		in.close();
		
		/*
		
		Iterator<String> it = p_HM.keySet().iterator();
		
		while(it.hasNext()) {
			p_HM.get(it.next()).What2Do();;
		}
		
		*/
		
		List<String> keys = new ArrayList<>(p_HM.keySet());
		Collections.sort(keys);
		
		for(String K:keys)
			p_HM.get(K).What2Do();
		
		
		
		
		//Collections.sort(pList);
		//pList.forEach(m->{System.out.print("\u272a ");m.What2Do();});
	}
}