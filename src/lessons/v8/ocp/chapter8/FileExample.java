package lessons.v8.ocp.chapter8;

import static java.lang.System.out;

import java.io.File;
import java.util.Arrays;

import static java.lang.System.getProperty;

public class FileExample {

    public static void main(String[] args) {
        out.println(getProperty("file.separator"));
        out.println(File.separator);
        File file = new File("foo\bar\test.txt");

        out.println(file.exists());
        File sample = new File("D:\\Downloads");
        out.println("\t" + sample.getParent());
        printTree(sample);
        File child  = new File(sample.getParent(), "\\a\\b");
        out.println("\t" + child.getParent());
        out.println("\t" + child);

    }

    private static void printTree(File f) {
        if (f.listFiles() == null) {
            out.println("\t\t|");
            out.println("\t\t----" + f);
            if (f.isFile()) {
                out.println("\t\t");
                System.out.println("\t\t    File size: " + f.length());
                System.out.println(
                        "\t\t    File LastModified: " + f.lastModified());
            }

            return;
        }
        out.println("\t|");
        out.println("\t----" + f);
        Arrays.asList(f.listFiles()).forEach(FileExample::printTree);

    }

}
