
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerseXMLFile {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File file = new File("File.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        for (int k = 0; k < 12 ; k++) {

            Element elementBook = (Element) document.getElementsByTagName("book").item(k);

            String idBook = elementBook.getAttribute("id");

            List<Books> booksList = new ArrayList<>();

            NodeList childBook = elementBook.getChildNodes();
            Books books = new Books();

            books.setId(idBook);

            for (int i = 0; i < childBook.getLength(); i++) {
                if (childBook.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element childElement = (Element) childBook.item(i);

                    switch (childElement.getNodeName()) {
                        case "author": {
                            books.setAuthor(childElement.getTextContent());
                            break;
                        }
                        case "description": {
                            books.setDescription(childElement.getTextContent());
                            break;
                        }
                        case "price": {
                            books.setPrice(Double.valueOf(childElement.getTextContent()));
                            break;
                        }
                        case "genre": {
                            books.setGanre(childElement.getTextContent());
                        }
                    }
                }

            }

            booksList.add(books);

            booksList.forEach(a -> System.out.println(a));
        }

    }


}

class Books {
    private String id;
    private String author;
    private String title;
    private String ganre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private double price;
    private String data;
    private String description;

    @Override
    public String toString() {
        return "ID " + getId() + "  author " + getAuthor() + " Price:  " + getPrice() + " Ganre " + getGanre();
    }
}