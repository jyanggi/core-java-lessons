package lessons.v8.oca.chapter1;

public class ArgsExample {

	public static void main(String[] args) {

		if (args != null && args.length > 0) {
			for (String s : args) {
				System.out.println(s);
			}
		} else {
			System.out.println("No args");
		}

	}

}
