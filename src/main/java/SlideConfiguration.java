import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Author: Mat Schaffer <matschaffer@netflix.com>
 * Created: 8/20/13 10:17 PM
 */
public class SlideConfiguration {
    String title;
    String description;
    String author;
    String theme;
    String json;

    public SlideConfiguration() {
        this.title = "Revealoff";
        this.theme = "default";
        this.json = "{}";
    }

    public static SlideConfiguration parse(File config) throws IOException {
        if (config.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            SlideConfiguration configuration = mapper.readValue(config, SlideConfiguration.class);
            configuration.readJson(config);
            return configuration;
        } else {
            return new SlideConfiguration();
        }
    }

    public void readJson(File config) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(config.toURI()));
        json = Charset.defaultCharset().decode(ByteBuffer.wrap(encoded)).toString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTheme() {
        return theme;
    }

    public String getJson() {
        return json;
    }
}
