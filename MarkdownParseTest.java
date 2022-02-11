import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void links() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("https://something.com");
        output.add("some-page.html");
        String actual = "test-file.md";
        Path fileName = Path.of(actual);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(output, links);
    }

    @Test
    public void links2() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("https://something.com");
        output.add("https://something.com");
        String actual = "test-file2.md";
        Path fileName = Path.of(actual);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(output, links);
    }

    @Test
    public void links3() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("https://something.com");
        String actual = "test-file3.md";
        Path fileName = Path.of(actual);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(output, links);
    }

    @Test
    public void links4() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("https://helloworld.com");
        String actual = "test-file4.md";
        Path fileName = Path.of(actual);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(output, links);
    }
}