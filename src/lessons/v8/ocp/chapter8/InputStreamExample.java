package lessons.v8.ocp.chapter8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static java.lang.System.out;

public class InputStreamExample {

    public static void main(String[] args) {

        String fileName = "./resources/io/input.txt";

        try (InputStream inputStream = new BufferedInputStream(
                new FileInputStream(fileName))) {
            int val;
            int count = 0;
            int markCount = 7;
            while ((val = inputStream.read()) != -1) {
                out.print((char) val);
                if (++count == markCount && inputStream.markSupported()) {
                    inputStream.skip(2);
                    inputStream.mark(5);
                }
            }
            out.println();
            if (inputStream.markSupported()) {
                inputStream.reset();
                out.print((char) inputStream.read());
                out.print((char) inputStream.read());
                out.print((char) inputStream.read());
                out.print((char) inputStream.read());
                out.print((char) inputStream.read());
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        }

    }

}
