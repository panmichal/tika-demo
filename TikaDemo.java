import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.exception.*;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.apache.tika.sax.BodyContentHandler;

public class TikaDemo {

    public static String parseExample() throws IOException, SAXException, TikaException {
      AutoDetectParser parser = new AutoDetectParser();
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      try (InputStream stream = TikaDemo.class.getResourceAsStream("test.pdf")) {
          parser.parse(stream, handler, metadata);
          return handler.toString();
      }
    }

    public static void main(String[] args) {
        String content;
        try {
          content = parseExample();
          System.out.println(content);
        } catch (Exception e) {
          System.out.println("Error");
        }
    }

}
