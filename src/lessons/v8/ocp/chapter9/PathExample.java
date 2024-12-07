package lessons.v8.ocp.chapter9;

import static java.lang.System.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;

public class PathExample {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path sample = Paths.get("D:", "Downloads");
        out.println(sample.toUri());
        out.println(Files.exists(sample));
        sample.getFileSystem().getFileStores().forEach(out::println);
        out.println("\t" + sample.getParent());
        Path uriPath = Paths.get(new URI("file://D:/Downloads"));
        uriPath.getFileSystem().getFileStores().forEach(out::println);
        final String site = "https://yanguasminds.com/";
        URL siteUrl = new URL(site);
        ReadableByteChannel rbc = Channels.newChannel(siteUrl.openStream());
        String htmlOutputPath = "./resources/nio2/information.html";
        FileOutputStream fos = new FileOutputStream(htmlOutputPath);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);


        Path path = Paths.get(htmlOutputPath);
        Files.copy(path, Paths.get("./resources/nio2/information-copy.html"),StandardCopyOption.REPLACE_EXISTING);

        Files.readAllLines(path).forEach(out::println);
        out.println(Files.getOwner(path));
        out.println(Files.getLastModifiedTime(path));

        Path walkPath = Paths.get("./resources/");

        Files.walk(walkPath).map(Path::toAbsolutePath).map(Path::normalize).forEach(out::println);
        Files.list(walkPath).filter(Files::isDirectory).forEach(out::println);
    }


}
