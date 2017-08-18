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

public class ParseXMLPath2 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("File2.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        for (int k = 0; k < 5; k++) {

            Element root = (Element) document.getElementsByTagName("food").item(k);

            List<Food> listOfFood = new ArrayList<>();

            NodeList foodList = root.getChildNodes();


            NodeList childFoodList = root.getChildNodes();

            Food food = new Food();

            for (int i = 0; i < childFoodList.getLength(); i++) {
                if (childFoodList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element childFoodElement = (Element) childFoodList.item(i);

                    switch (childFoodElement.getNodeName()) {
                        case ("name"):
                            food.setName(childFoodElement.getTextContent());
                            break;
                        case ("price"):
                            food.setPrice(childFoodElement.getTextContent());
                            break;
                        case ("description"):
                            food.setDescription(childFoodElement.getTextContent());
                            break;
                        case ("alories"):
                            food.setCalories(Integer.valueOf(childFoodElement.getTextContent()));
                            break;
                    }
                }
            }
            listOfFood.add(food);
            listOfFood.forEach(a -> System.out.println(a));
        }
    }
}


class Food {
    private String name;
    private String price;
    private String description;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    private int calories;

    @Override
    public String toString() {
        return "Name - " + getName() + "  price - " + getPrice() + "  Description -  " + getDescription() + "  Calories - " + getCalories();
    }
}
