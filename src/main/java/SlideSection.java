import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SlideSection {
    File root;
    ArrayList<File> markdowns;
    HashMap<File,Exception> fileErrors;

    public SlideSection(File root) {
        this.root = root;
        markdowns = new ArrayList<>();
        fileErrors = new HashMap<File,Exception>();
    }

    public void add(File markdown) {
        markdowns.add(markdown);
    }

    public ArrayList<Slide> getSlides() {
        ArrayList<Slide> slides = new ArrayList<>();
        for (File markdown : markdowns) {
            SlideParser parser = new SlideParser(markdown);
            try {
                slides.addAll(parser.getSlides());
            } catch (IOException e) {
                fileErrors.put(markdown, e);
            }
        }
        return slides;
    }
}
