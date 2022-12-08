import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMExample {
    static List<SiteMap> allMap = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src\\file.xml"));
        NodeList elem = doc.getElementsByTagName("url");
        for (int i = 0; i < elem.getLength(); i++) {
            if (elem.item(i) instanceof Element) {
                NodeList list = elem.item(i).getChildNodes();
                List<String> stringList = new ArrayList<>();
                for (int j = 0; j < list.getLength(); j++) {
                    if(!(list.item(j) instanceof Element)){
                        continue;
                    }
                    stringList.add(list.item(j).getTextContent());
                    //System.out.println("\t" + list.item(j).getTextContent());
                }
                allMap.add(new SiteMap(stringList.get(0), stringList.get(1), Double.parseDouble(stringList.get(2))));
            }
        }
        for(SiteMap map : allMap){
            System.out.println(map.toString());
        }
    }
}
