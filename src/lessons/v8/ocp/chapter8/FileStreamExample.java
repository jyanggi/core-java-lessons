package lessons.v8.ocp.chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.lang.System.out;

public class FileStreamExample {

    private static final String SOURCE = "./resources/io/source.txt";
    private static final String DESTINATION = "./resources/io/destination.txt";

    public static void main(String[] args) {
        copyFile(new File(SOURCE), new File(DESTINATION));

    }

    public static void copyFile(File source, File destination) {
        int sentinel = -1;
        int val = 0;
        byte[] bytes = new byte[1024];
        try (InputStream is = new BufferedInputStream(
                new FileInputStream(source));
                OutputStream os = new BufferedOutputStream(
                        new FileOutputStream(destination))) {
            while ((val = is.read(bytes)) != sentinel) {
                os.write(bytes, 0, val);
                os.flush();
                for (int i = 0; i < val; i++) {
                    out.print((char) bytes[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
