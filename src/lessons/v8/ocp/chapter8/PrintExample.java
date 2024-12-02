package lessons.v8.ocp.chapter8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintExample {
    private static final File FILE = new File("./resources/io/print.txt");

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(FILE)))) {
            writer.print("PrintWriter");
            writer.println();
            writer.write(String.valueOf(2345.67));
            writer.print(System.getProperty("line.separator"));
            writer.format("%s, %s!", "Hello", "World");
        } catch (Exception e) {
        }
    }

}
