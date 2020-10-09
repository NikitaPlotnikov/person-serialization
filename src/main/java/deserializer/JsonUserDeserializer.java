package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import model.UserCollection;

import java.io.File;
import java.io.IOException;

public class JsonUserDeserializer implements UserDeserializer{
    public UserCollection deserialize(String filename){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerFor(UserCollection.class);
        UserCollection users = null;
        try {
            users = objectReader.readValue(new File(filename),UserCollection.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
