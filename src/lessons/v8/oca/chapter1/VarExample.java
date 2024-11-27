package lessons.v8.oca.chapter1;

import java.util.Scanner;

public class VarExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter num 1:");
		int num1 = scanner.nextInt();
		System.out.println("Enter num 2:");
		int num2 = scanner.nextInt();
		System.out.println(String.format("Sum:%d", num1 + num2));
		scanner.close();
	}

}
