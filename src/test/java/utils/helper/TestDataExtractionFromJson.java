package utils.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestDataExtractionFromJson {


    public static void main(String[] args) throws IOException {

        String jsonInput = """
                {
                  "category1": {
                    "key1": "value1",
                    "key2": "value2"
                  },
                  "category2": {
                    "key1": "value1",
                    "key2": "value2"
                  }
                }""";

        // Here we have  creating a Map of String = category1, "category2", Inside JSON as Again Key value
        // readValues can take which could be a File, String, URL, or InputStream to convert the JSON Object to Java Object
        // and vice versa

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<String,String>> values =  mapper.readValue(jsonInput, new TypeReference<>() {});
        for( Map.Entry<String, Map<String,String>> entry : values.entrySet())
        {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
