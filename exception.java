package exception;

import java.util.Scanner;

//Step 1: Define a Custom Exception
@SuppressWarnings("serial")
class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class ExceptionHandlingDemo {

	// Step 2: Write a Method to Validate Age
	public static void validateAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above to proceed.");
		}
	}

	// Step 3: Write a Method to Perform Division
	public static int divideNumbers(int dividend, int divisor) throws ArithmeticException {
		if (divisor == 0) {
			throw new ArithmeticException("Cannot divide by zero.");
		}
		return dividend / divisor;
	}

	// Step 4: Main Method to Handle Input and Exceptions
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			// Taking age input
		 	System.out.print("Enter your age: ");
			int age = scanner.nextInt();
			validateAge(age);
			System.out.println("Age validation successful!");

			// Taking input for division
			System.out.print("Enter dividend: ");
			int dividend = scanner.nextInt();
			System.out.print("Enter divisor: ");
			int divisor = scanner.nextInt();

			int result = divideNumbers(dividend, divisor);
			System.out.println("Division result: " + result);

		} catch (InvalidAgeException e) {
			System.out.println("Custom Exception: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Predefined Exception: " + e.getMessage());
		} finally {
			scanner.close();
			System.out.println("Program execution completed.");
		}
	}
}
