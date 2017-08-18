import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class PerseXMLSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        MyHandler handler = new MyHandler();
        xmlReader.setContentHandler(handler);

        xmlReader.parse("/Users/arina/Desktop/GitHub/Acmp/File.xml");
    }



    private static class MyHandler extends DefaultHandler{
        static final String CATALOG_TAG = "catalog";
        static final String BOOK_TAG = "book";
        static final String AUTHOR_TAG = "author";
        static final String TITLE_TAG = "title";
        static final String GENRE_TAG = "genre";
        static final String PRICE_TAG = "price";
        static final String DATE_TAG = "publish_date";
        static final String DESCRIPTION_TAG = "description";


        static final String BOOK_ATTRIBUTE = "id";

    }
}


