package serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.User;
import model.UserCollection;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XmlUserSerializer implements UserSerializer{
    public void serialize(UserCollection userCollection, String fileName) {
        ObjectMapper objectMapper = new XmlMapper();
        File out = new File(fileName);
        try {
            objectMapper.writerFor(UserCollection.class).writeValue(out, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
