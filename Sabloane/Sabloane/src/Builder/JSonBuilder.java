package Builder;

import Elements.Book;
import Elements.Element;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSonBuilder implements Builder{

    private String filePath;
    private Element elementFromJson;

    JSonBuilder(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void build() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;
            elementFromJson = (Element) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Element getResult() {
        return elementFromJson;
    }
}
