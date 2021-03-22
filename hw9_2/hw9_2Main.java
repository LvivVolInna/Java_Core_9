package hw9_2;
import java.util.Scanner;
public class hw9_2Main {


	public static void main(String[] args) throws MyException, IllegalAccessException  {
		Scanner scanner = new Scanner(System.in);
		int a;
		int b;

		
		System.out.println("Enter the first integer: ");

		if (scanner.hasNextInt()) {
			a = scanner.nextInt();

			
			System.out.println("Enter the second integer: ");

			if (scanner.hasNextInt()) {
				b = scanner.nextInt();
				Methods calculate = new Methods(a, b);
				Methods.answer(calculate.plus());
				Methods.answer(calculate.minus());
				Methods.answer(calculate.multiply());
				Methods.answer(calculate.devide());
			}

			else
				
				System.out.println("Error! You had to enter an integer");
		}

		else
			System.out.println("Error! You had to enter an integer");

	}
}