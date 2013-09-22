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
    File markdown;

    String SEPARATOR = "!SLIDE";

    public SlideParser(File markdown) {
        processor = new PegDownProcessor();
        this.markdown = markdown;
    }

    public ArrayList<Slide> getSlides() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(markdown.getPath()));
        String[] slideStrings = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(encoded)).toString().split(SEPARATOR);

        ArrayList<Slide> parsedSlides = new ArrayList<>();
        for(String slide : slideStrings) {
            parsedSlides.add(new Slide(processor.markdownToHtml(slide)));
        }

        if (parsedSlides.get(0).isEmpty()) {
            parsedSlides.remove(0);
        }

        return parsedSlides;
    }
}
