package xyz.veiasai.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigInteger;

public class MyIdSerializer extends JsonSerializer<BigInteger>{
    public void serialize(BigInteger bigInteger, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String out = bigInteger.toString();
        jsonGenerator.writeString(out);
    }
}
