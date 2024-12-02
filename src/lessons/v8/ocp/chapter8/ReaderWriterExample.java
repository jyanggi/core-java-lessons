package lessons.v8.ocp.chapter8;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterExample {

    private static final String SOURCE = "./resources/io/source.txt";
    private static final String DESTINATION = "./resources/io/destination.txt";

    public static void main(String[] args) {
        copyFile(new File(SOURCE), new File(DESTINATION));

    }

    public static void copyFile(File source, File destination) {
        String val = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(destination))) {
            while ((val = reader.readLine()) != null) {
                writer.write(val);
                writer.newLine();
                out.println(val);
            } 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
