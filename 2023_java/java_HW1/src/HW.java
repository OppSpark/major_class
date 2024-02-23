import java.util.Vector;
public class HW {
	public static void main(String[] args) {
		Vector<Vehicle> listVector = new Vector<>();
	
		
		String Brand [] = {"현대자동차", "볼보", "메르세데스", "포드", "페라리"};
		String Color [] = {"화이트", "레드", "블랙", "그린", "그레이"};
		String a1 ,b1;
		int j ,k;

		
		int i = 0;
		while(i < 50){
			
			j = Rand.r(0, 4);
			k = Rand.r(0, 4);
			
			a1 = Brand[j];
			b1 = Color[k];
			
			listVector.add(Vehicle.PrintInfo(a1,b1));
			i++;
		}
		
		for(Vehicle loof:listVector) {
			loof.Cinfo1();
			
		}
		for(Vehicle loof:listVector) {
			loof.Cinfo2();
			
		}
		
	}

}