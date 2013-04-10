package net.kencochrane.raven.marshaller.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class AbstractTestInterfaceBinding {
    private JsonFactory jsonFactory;
    private ObjectMapper mapper;
    private ByteArrayOutputStream jsonContentStream;

    @Before
    protected void setUp() throws Exception {
        jsonFactory = new JsonFactory();
        mapper = new ObjectMapper();
    }

    protected JsonGenerator getJsonGenerator() throws IOException {
        jsonContentStream = new ByteArrayOutputStream();
        return jsonFactory.createJsonGenerator(jsonContentStream);
    }

    protected JsonParser getJsonParser() throws IOException {
        return jsonFactory.createJsonParser(jsonContentStream.toByteArray());
    }

    protected ObjectMapper getMapper() {
        return mapper;
    }
}
