package lessons.v8.ocp.chapter8;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;

public class ConsoleExample {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            String line = reader.readLine();
            System.out.printf("line is %s%s", line,
                    System.getProperty("line.separator"));
        } catch (Exception e) {
        }

        Console console = System.console();
        if (console != null) {
            String line = console.readLine();
            System.out.printf("line is %s%s", line,
                    System.getProperty("line.separator"));
        }

    }

}
