package hlicp.ext.tele.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.List;



public final class JsonUtils {

    public static <T> T readValue(Reader reader, Class<T> clazz) throws IOException {
//    Assert.notNull(reader, "Argument 'reader' must not be null.");
        return (T) JacksonObjectMapperUtils.getInstance().readValue(reader, clazz);
    }

    public static <T> T readValue(byte[] bytes, Class<T> clazz) {
//    Assert.notNull(clazz, "Argument 'clazz' must not be null.");
        try {
            return (T) JacksonObjectMapperUtils.getInstance().readValue(bytes, clazz);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T readValue(String jsonString, Class<T> clazz) {
//    Assert.notNull(clazz, "Argument 'clazz' must not be null.");
        try {
            return (T) JacksonObjectMapperUtils.getInstance().readValue(jsonString,
                    clazz);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T readValue(String jsonString, JavaType javaType) {
//    Assert.notNull(javaType, "Argument 'javaType' must not be null.");
        try {
            return (T) JacksonObjectMapperUtils.getInstance().readValue(jsonString, javaType);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T convertValue(Object src, Class<T> type) {
//    Assert.notNull(type, "Argument 'type' must not be null.");

        return (T) JacksonObjectMapperUtils.getInstance().convertValue(src, type);
    }

    public static <T> T convertValueList(Object src, Class<?> clazz) {
//    Assert.notNull(clazz, "Argument 'clazz' must not be null.");
        JavaType javatype = JacksonObjectMapperUtils.getInstance().getTypeFactory()
                .constructParametricType(List.class, new Class[]{clazz});
        return (T) JacksonObjectMapperUtils.getInstance().convertValue(src, javatype);
    }

    public static void writeValue(OutputStream outputStream, Charset charset,
                                  Object value) throws IOException {
//    Assert.notNull(outputStream, "Argument 'outputStream' must not be null.");
//    Assert.notNull(charset, "Argument 'charset' must not be null.");

        writeValue(new OutputStreamWriter(outputStream, charset), value);
    }

    public static void writeValue(Writer writer, Object value) throws IOException {
//    Assert.notNull(writer, "Argument 'writer' must not be null.");

        JacksonObjectMapperUtils.getInstance().writeValue(writer, value);
    }

    public static String toJson(Object value) {
        try {
            return JacksonObjectMapperUtils.getInstance().writeValueAsString(value);
        }
        catch (JsonProcessingException e) {
        }
        return "";
    }

    public static byte[] toJsonBytes(Object value) {
        try {
            return JacksonObjectMapperUtils.getInstance().writeValueAsBytes(value);
        }
        catch (JsonProcessingException e) {
        }
        return null;
    }
}