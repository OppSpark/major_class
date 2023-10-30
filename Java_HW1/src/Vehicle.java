public abstract class Vehicle{
	
	private String a, b;
	public void Set(String a1, String b1)
	{
		a = a1;
		b = b1;
	}
	
	public abstract void Cinfo1();
	public abstract void Cinfo2();
	
	
	public String toString() {
		return String.format(" 브랜드는 %s 이고 색상은 %s 입니다.",a ,b);
	}
	
	public static Vehicle PrintInfo(String a1,String b1) {
		switch(Rand.r(1, 100)%6) {
		case 0:
			return new Notchback(a1, b1, Notchback.PrintInfo());
		case 1:
			return new Hatchback(a1, b1, Hatchback.PrintInfo());
		case 2:
			return new Truck(a1, b1, Truck.PrintInfo());
		case 3:
			return new CrossOver(a1, b1, CrossOver.PrintInfo());
		case 4:
			return new Sedan(a1, b1, Sedan.PrintInfo());
		case 5:
			return new SUV(a1, b1, SUV.PrintInfo());
		default:
			return null;
		}
		
}

}

class Sedan extends Vehicle implements PowerSource, MovingPower{
	
	protected String position;
	private static String[] sepo = {"아반떼", "520i"};
	
	public Sedan(String a1, String b1, String c1) {
		Set(a1, b1);
		position = c1;
	}
	
	public static String PrintInfo() {
		return sepo[Rand.r(0,sepo.length - 1)];
	}

	@Override
	public void Cinfo1() {
		
		System.out.print("Sedan 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Fuel();
		System.out.println();
	}

	@Override
	public void Cinfo2() {
		System.out.print("Sedan 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Fuel();
		System.out.println();
	}

	@Override
	public void Wheel() {
		System.out.print(" 구동력은 FWD 이고");
		
	}

	@Override
	public void Fuel() {
		System.out.print(" 연료는 전기 입니다.");
		
	}
	
}




class Notchback extends Sedan implements Feature{
	

	private static String[] sepo = {"G70", "제타"};
	
	public Notchback(String a1, String b1, String c1) {
		super(a1, b1, c1);
		
	}
	
	public static String PrintInfo() {
		return sepo[Rand.r(0,sepo.length - 1)];
	}

	@Override
	public void Cinfo1() {
		
		
		System.out.print("Notchback 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
	}

	@Override
	public void Cinfo2() {
		
		System.out.print("Notchback 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
		
	}
	

	@Override
	public void Device() {
		System.out.print(" 탑승 인원은 4인승 입니다.");
		
	}
	
}




class Hatchback extends Sedan implements Feature{
	
	private static String[] sepo = {"i30", "메간 RS"};
	
	public Hatchback(String a1, String b1, String c1) {
		super(a1, b1, c1);
		
	}
	
	public static String PrintInfo() {
		return sepo[Rand.r(0,sepo.length - 1)];
	}

	@Override
	public void Cinfo1() {
		
		System.out.print("Hatchback 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
	}

	@Override
	public void Cinfo2() {
		System.out.print("Hatchback 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
		
	}
	
	@Override
	public void Device() {
		System.out.print(" 탑승 인원은 5인승 입니다.");
	}
	
}





class SUV extends Vehicle implements Feature, MovingPower{
	
	protected String position;
	private static String[] sepo = {"이보크", "QM6"};
	
	public SUV(String a1, String b1, String c1) {
		Set(a1, b1);
		position = c1;
	}
	
	public static String PrintInfo() {
		return sepo[Rand.r(0,sepo.length - 1)];
	}

	@Override
	public void Cinfo1() {
		System.out.print("SUV 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		System.out.println();
	}

	@Override
	public void Cinfo2() {
		System.out.print("SUV 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		System.out.println();
	}

	@Override
	public void Wheel() {
		System.out.print(" 구동력은 AWD 이고");
		
	}

	@Override
	public void Device() {
		System.out.print(" 탑승 인원은 7인승 입니다.");
		
	}
	
}




class Truck extends SUV implements PowerSource{
	
	private static String[] sepo = {"포터", "라보"};
	
	public Truck(String a1, String b1, String c1) {
		super(a1, b1, c1);
		
	}
	
	public static String PrintInfo() {
		return sepo[Rand.r(0,sepo.length - 1)];
	}

	@Override
	public void Cinfo1() {
		
	
		System.out.print("Truck 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
	}

	@Override
	public void Cinfo2() {
		System.out.print("Truck 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
		
	}
	

	@Override
	public void Fuel() {
		System.out.print(" 연료는 디젤 입니다.");
		
	}
	
}




class CrossOver extends SUV implements PowerSource{
	

	private static String[] sepo = {"트렉스", "V60"};
	
	public CrossOver(String a1, String b1, String c1) {
		super(a1, b1, c1);
		
	}
	
	public static String PrintInfo() {
		return sepo[Rand.r(0,sepo.length - 1)];
	}

	@Override
	public void Cinfo1() {
		
		System.out.print("CrossOver 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
	}

	@Override
	public void Cinfo2() {
		System.out.print("CrossOver 형태를 가진 "+position+"은(는)"+this);
		Wheel();
		Device();
		Fuel();
		System.out.println();
		
	}
	
	@Override
	public void Fuel() {
		System.out.print(" 연료는 가솔린 입니다.");
		
	}
	
}

