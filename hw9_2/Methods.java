package hw9_2;

public class Methods{

	private static int a;
	private static int b;
	public Methods(int a1, int b1) {
		a = a1;
		b = b1;
	}
	public int plus() throws MyException, IllegalAccessException{
		Methods.examine();
		return a + b;
	}
	
	public int minus() throws MyException, IllegalAccessException {
		Methods.examine();
		return a - b;
	}
	public int multiply() throws MyException, IllegalAccessException {
		Methods.examine();
		return a * b;
	}
	public double devide() throws MyException, IllegalAccessException {
		Methods.examine();
		return a / b;
	}
	
	static void answer(double answer) {
		System.out.println("The result of this mathematical action:  " + answer);
	}

	static void examine() throws MyException, IllegalAccessException {
		if ((a < 0) && (b < 0)) {
			throw new IllegalArgumentException();
		}
		if (((a == 0) && (b != 0)) | ((a != 0) && (b == 0))) {
			throw new ArithmeticException();
		}
		if ((a == 0) && (b == 0)) {
			throw new IllegalAccessException();
		}
		if ((a > 0) && (b > 0)) {
			throw new MyException();
		}
	}
}
