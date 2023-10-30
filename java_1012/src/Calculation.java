
public class Calculation {
	public static String compute(String AS, String oper, String BS) {
		int		A, B;
		float	result=0;
		A = Integer.parseInt(AS);
		B = Integer.parseInt(BS);
		
		switch (oper) {
		case "+":
			result = A + B;
			break;
		case "-":
			result = A - B;
			break;
		case "/":
			result = (float)A / B;
			break;
		case "x":
			result = A * B;
			break;
		default:
			break;
		}
		
		return (""+result);
	}
}
