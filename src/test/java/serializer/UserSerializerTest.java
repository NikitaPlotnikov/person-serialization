package serializer;

import deserializer.JsonUserDeserializer;
import deserializer.XmlUserDeserializer;
import model.User;
import model.UserCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UserSerializerTest {

    @Test
    void serializeJson() {
        UserCollection userCollection = prepareTestData();
        JsonUserSerializer jsonUserSerializer = new JsonUserSerializer();
        jsonUserSerializer.serialize(userCollection, "users.json");
        Assertions.assertTrue(new File("users.json").exists());

    }
    @Test
    void serializeXml() {
        UserCollection userCollection = prepareTestData();
        XmlUserSerializer xmlUserSerializer = new XmlUserSerializer();
        xmlUserSerializer.serialize(userCollection, "users.xml");
        Assertions.assertTrue(new File("users.xml").exists());
    }

    @Test
    void serializeDeserializeTestJson(){
        UserCollection userCollection = prepareTestData();
        JsonUserSerializer jsonUserSerializer = new JsonUserSerializer();
        jsonUserSerializer.serialize(userCollection, "users.json");
        JsonUserDeserializer jsonUserDeserializer = new JsonUserDeserializer();
        UserCollection collection = jsonUserDeserializer.deserialize("users.json");
        Assertions.assertEquals(userCollection,collection);
    }
    @Test
    void serializeDeserializeTestXml(){
        UserCollection userCollection = prepareTestData();
        XmlUserSerializer xmlUserSerializer = new XmlUserSerializer();
        xmlUserSerializer.serialize(userCollection, "users.xml");
        XmlUserDeserializer xmlUserDeserializer = new XmlUserDeserializer();
        UserCollection collection = xmlUserDeserializer.deserialize("users.xml");
        Assertions.assertEquals(userCollection,collection);
    }

    private UserCollection prepareTestData() {
        User ivan = new User();
        ivan.setName("ivan");
        ivan.setId(1);
        ivan.setEmail("ivan@email.com");
        User oleg = new User();
        oleg.setName("Oleg");
        oleg.setId(2);
        oleg.setEmail("oleg@email.com");
        User misha = new User();
        misha.setName("misha");
        misha.setId(3);
        misha.setEmail("misha@email.com");
        User nikita = new User();
        nikita.setName("nikita");
        nikita.setId(4);
        nikita.setEmail("nikita@email.com");
        User max = new User();
        max.setName("max");
        max.setId(5);
        max.setEmail("max@email.com");
        User sam = new User();
        sam.setName("sam");
        sam.setId(6);
        sam.setEmail("sam@email.com");
        User katya = new User();
        katya.setName("katya");
        katya.setId(7);
        katya.setEmail("katya@email.com");
        User masha = new User();
        masha.setName("masha");
        masha.setId(8);
        masha.setEmail("masha@email.com");
        User sasha = new User();
        sasha.setName("sasha");
        sasha.setId(9);
        sasha.setEmail("sasha@email.com");
        User tom = new User();
        tom.setName("tom");
        tom.setId(10);
        tom.setEmail("tom@email.com");
        UserCollection userCollection = new UserCollection();
        userCollection.setUsers(new ArrayList<User>());
        userCollection.getUsers().add(ivan);
        userCollection.getUsers().add(oleg);
        userCollection.getUsers().add(misha);
        userCollection.getUsers().add(nikita);
        userCollection.getUsers().add(max);
        userCollection.getUsers().add(sam);
        userCollection.getUsers().add(katya);
        userCollection.getUsers().add(masha);
        userCollection.getUsers().add(sasha);
        userCollection.getUsers().add(tom);

        return userCollection;
    }
}