import org.pegdown.PegDownProcessor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Author: Mat Schaffer <matschaffer@netflix.com>
 * Created: 8/18/13 12:09 AM
 */
public class SlideParser {
    PegDownProcessor processor;

    String SEPARATOR = "!SLIDE";

    public SlideParser() {
        processor = new PegDownProcessor();
    }

    public ArrayList<String> getSlides() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("slides.md"));
        String[] slides = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(encoded)).toString().split(SEPARATOR);

        ArrayList<String> parsedSlides = new ArrayList<>();
        for(String slide : slides) {
            parsedSlides.add(processor.markdownToHtml(slide));
        }

        if (parsedSlides.get(0).trim().length() < 1) {
            parsedSlides.remove(0);
        }
        return parsedSlides;
    }
}
