public class interface_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InFace add = (x, y) -> {
			return x + y;
		};
		System.out.println(computation(10, 4, add));

	}
	
	public static int computation(int a, int b, InFace op) {   //computatio 은 InFace op 를 어떻게 구현하느냐에 따라 출력값이 달라진다.
		return op.Compute(a, b);
		
	}
}

interface InFace{
	int Compute(int a, int b);
	
}