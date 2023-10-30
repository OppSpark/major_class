
public class Interface_Ex {

   public static void main(String[] args) {
      int c = 10, d = 4;
      
      InFace[] ops = new Inface[4];
      String[] op = {"+","-","*","/"};
      
      InFace add = (x,y) -> {
         return x+y;
      };
      
      
      
      InFace minus = new InFace() {

         @Override
         public int Compute(int a, int b) throw Exception {
            if(b==0) throw new MyException("두번째 피연사자가 0임");
            return a-b;
         }
         
      };
      InFace div = new InFace() {

         @Override
         public int Compute(int a, int b) throws Exception {
            if (b==0) throw new Exception("0으로 나누기 오류..", 20);
            return a/b;
         }         
      };
      
      InFace multiply = (a,b) -> a*b;
      //InFace라는 Interface 안에 구현할 method가 딱 하나만 있을 떄 람다식 사용 가능

      
      InFace div = (a,b) -> {
         if (b==0) throw new Exception("0으로 나누기 오류..");
         return a/b;
      };


      ops[0] = add; ops[1] = minus; ops[2] = multiply; ops[3] = div;
      for(int i=0; i<4; i++) {
         
      }
      for(int i = 0; i <ops.length; i++) {
      try {
    	  System.out.printf("5d %s %d = %d \n",c, op[c,0.Computation(c, o, ops[i]));
    	  catch (MyException e) {
    		  if(errCode == -20) {
    		  System.out.printf("Error");
    	      	}
      }
      }
         System.out.printf("%d + %d = %d\n", c,d,Computation(c, d, add));
         System.out.printf("%d - %d = %d\n", c,d,Computation(c, d, minus));
         System.out.printf("%d * %d = %d\n", c,d,Computation(c, d, multiply));
         System.out.printf("%d * %d = %d\n", c,0,Computation(c, d, div));
      }
    
      
   }
   
   public static int Computation(int a, int b, InFace op) throws Exception{
      return op.Compute(a, b);
   }
}

interface InFace {
   int Compute(int a, int b);
}

class MyException extends Exception{
	int errCode;
	public MyException(String mesg, int e) {
		super(mesg);
		errCode = e;
		
	}
}