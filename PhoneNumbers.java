import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.exception.*;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.PhoneExtractingContentHandler;
import java.util.Arrays;

public class PhoneNumbers {

    public static String parseExample() throws IOException, SAXException, TikaException {
      AutoDetectParser parser = new AutoDetectParser();
      Metadata metadata = new Metadata();
      PhoneExtractingContentHandler handler = new PhoneExtractingContentHandler(new BodyContentHandler(), metadata);
      try (InputStream stream = TikaDemo.class.getResourceAsStream("test.doc")) {
          parser.parse(stream, handler, metadata);
          return Arrays.toString(metadata.getValues("phonenumbers"));
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
