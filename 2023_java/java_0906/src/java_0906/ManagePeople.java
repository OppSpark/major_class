package java_0906;
public class ManagePeople {
	
	public static void main(String[] args) {
		People stud1 = new Student("1234-1234", "준규", "busan");
		People prof1 = new Professor("5678-5678", "준규2", "daegu");
		
		stud1.What2Do();
		prof1.What2Do();	
		
		System.out.println(stud1);
	    System.out.print(prof1);

	}
}