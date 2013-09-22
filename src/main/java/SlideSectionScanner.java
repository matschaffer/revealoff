import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;

public class SlideSectionScanner extends SimpleFileVisitor<Path> {
    File scanPath;
    ArrayList<SlideSection> subsections;
    SlideSection section;

    SlideSectionScanner(File scanPath) {
        this.scanPath = scanPath;
        this.subsections = new ArrayList<>();
        this.section = new SlideSection(scanPath);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (FilenameUtils.getExtension(file.toString()).equals("md")) {
            section.add(file.toFile());
        }
        return FileVisitResult.CONTINUE;
    }

    public void load() throws IOException {
        Files.walkFileTree(Paths.get(scanPath.toURI()), EnumSet.noneOf(FileVisitOption.class), 1, this);
    }

    public ArrayList<SlideSection> getSections() {
        ArrayList<SlideSection> sections = new ArrayList<>();
        sections.add(this.section);
        return sections;
    }

    public static ArrayList<SlideSection> scan(String path) throws IOException {
        File scanPath = new File(path);

        if (scanPath.exists()) {
            SlideSectionScanner scanner = new SlideSectionScanner(scanPath);
            scanner.load();
            return scanner.getSections();
        } else {
            throw new RuntimeException(String.format("Given path %s could not be found.", path));
        }
    }
}
