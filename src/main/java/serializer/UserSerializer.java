package serializer;

import model.User;
import model.UserCollection;

import java.util.Collection;

public interface UserSerializer {
        void serialize(UserCollection userCollection, String fileName);
}

