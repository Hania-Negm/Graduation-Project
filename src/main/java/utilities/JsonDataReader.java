package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {

    private static JsonNode data;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            data = mapper.readTree(new File("src/test/resources/testData.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getData(String section, String key) {

        return data.get(section).get(key).asText();
    }
}