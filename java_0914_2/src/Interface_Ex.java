
public class Interface_Ex {

	public static void main(String[] args) {
		int		c = 10, d = 4;
		InFace[]	ops = new InFace[4];
		String[]	op = {"+","/","X","-"};
		InFace add = (x,y)->{
			return x+y;
		};
		InFace minus = new InFace() {
			@Override
			public int Compute(int a, int b) throws Exception {
				if(b==0) throw new MyException("두번째 피연산자가 0임..",-10);
				return a-b;
			}
		};
		InFace multiply = (a,b)->a*b;
		InFace div = new InFace() {
			@Override
			public int Compute(int a, int b) throws Exception {
				if(b==0) throw new MyException("0으로 나누기 오류..",-20);
				return a/b;
			}
		};
		ops[0] = add; ops[1] = div;
		ops[2] = multiply; ops[3] = minus;
		for(int i=0;i < ops.length;i++ ) {
			try {
				System.out.printf("%d %s %d = %d\n", c, op[i] ,0, Computation(c, 0, ops[i]));
			} catch (MyException e) {
				if(e.errCode == -20) {
				System.out.println("Error : "+e.getMessage());
			}
		}
	}
	public static int Computation(int a, int b, InFace op) throws Exception {
		return op.Compute(a, b);
	}
}

interface InFace {
	int Compute(int a, int b) throws Exception;
}

class MyException extends Exception {
	int		errCode;
	
	public MyException(String mesg, int e) {
		super(mesg);
		errCode = e;
	}
}
}