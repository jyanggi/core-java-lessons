package lessons.v8.oca.chapter6;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;

public class TryWithResourceExample {

    public static void main(String[] args) {

        String fileName = "resource.txt";
        // Old Way before Java 7
        MyBufferedReader reader = null;
        try {
            reader = new MyBufferedReader(
                    new FileReader(new File(TryWithResourceExample.class
                            .getResource(fileName).toURI())));
            reader.lines().forEach(out::println);
        } catch (FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    for (Throwable t : e.getSuppressed()) {
                        out.println(t.getMessage());
                    }
                }
        }
        out.println("----------------------");
        // try with resource introduced in java 7
        try (MyBufferedReader bufferedReader = new MyBufferedReader(
                new FileReader(new File(TryWithResourceExample.class
                        .getResource(fileName).toURI())))) {
            bufferedReader.lines().forEach(out::println);
            throw new IOException("Test");
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            for (Throwable t : e.getSuppressed()) {
                out.println(t.getMessage());
            }
        }

        try {
            out.println("LEGAL");
        } finally {
            out.println("FINALLY");

        }

        try {
            out.println("ALSO LEGAL");
        } catch (Exception e) {
        }

    }

    static class MyBufferedReader extends BufferedReader {

        public MyBufferedReader(Reader in) {
            super(in);
        }

        @Override
        public void close() throws IOException {
            super.close();
            throw new IOException("MyBufferedReader close");
        }

    }

}
