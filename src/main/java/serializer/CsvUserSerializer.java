package serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.User;
import model.UserCollection;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CsvUserSerializer implements UserSerializer {
    public void serialize(UserCollection userCollection, String fileName) {

        CsvSchema schema = CsvSchema.builder()
                .addColumn("id",CsvSchema.ColumnType.NUMBER)
                .addColumn("name")
                .addColumn("email")
                .build();
    }
}
