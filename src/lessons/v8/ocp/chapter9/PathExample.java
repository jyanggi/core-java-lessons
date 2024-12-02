package lessons.v8.ocp.chapter9;

import static java.lang.System.getProperty;
import static java.lang.System.out;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) {
        String[] sampleArray = { "John" };
        Path sample = Paths.get("C:", "Users", "johhny", ".m2");
        out.println(sample.toUri());
        sample.getFileSystem().getFileStores().forEach(out::println);

        out.println("\t" + sample.getParent());

//        printTree(sample);

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
        // Arrays.asList(f.listFiles()).forEach(FileExample::printTree);

    }

}
