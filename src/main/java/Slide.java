public class Slide {
    String content;

    public Slide(String content) {
        this.content = content;
    }

    public boolean isEmpty() {
        return content.trim().length() < 1;
    }
}
