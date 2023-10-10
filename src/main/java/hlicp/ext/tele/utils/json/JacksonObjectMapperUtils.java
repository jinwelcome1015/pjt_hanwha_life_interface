package hlicp.ext.tele.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;



public class JacksonObjectMapperUtils {

    private static ObjectMapper objectMapper = null;
    public static String DATE_FORMAT_STRING = "yyyyMMdd";
    public static String TIMESTAMP_FORMAT_STRING = "yyyyMMddHHmmssSSS";

    public static ObjectMapper getInstance() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            // objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,
            // true);
            // objectMapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN,
            // true);
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            // objectMapper.registerModule(new JaxbAnnotationModule(new
            // FieldBaseJaxbAnnotationIntrospector()));
            SimpleModule module = new SimpleModule();
            // module.addSerializer(Date.class, new DateJsonSerializer(null));
            // module.addDeserializer(Date.class, new DateJsonDeserializer(null));
            // module.addSerializer(Calendar.class, new CalendarJsonSerializer(null));
            // module.addDeserializer(Calendar.class, new
            // CalendarJsonDeserializer(null));
            // module.addSerializer(Timestamp.class, new
            // TimestampJsonSerializer(null));
            // module.addDeserializer(Timestamp.class, new
            // TimestampJsonDeserializer(null));
            objectMapper.registerModule(module);
        }

        return objectMapper;
    }

    public static Map<String, Object> convertObjectToMap(Object vo) {
        Map<String, Object> params = (Map) objectMapper.convertValue(vo, Map.class);
        return params;
    }

    private static class DateJsonSerializer extends JsonSerializer<Date> {
        public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(JacksonObjectMapperUtils.writeToString(value));
        }
    }

    private static class DateJsonDeserializer extends JsonDeserializer<Date> {
        public Date deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return JacksonObjectMapperUtils.readDate(jp.getText());
        }
    }

    private static class CalendarJsonSerializer extends JsonSerializer<Calendar> {
        public void serialize(Calendar value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(JacksonObjectMapperUtils.writeToString(value));
        }
    }

    private static class TimestampJsonSerializer extends JsonSerializer<Timestamp> {
        public void serialize(Timestamp value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(JacksonObjectMapperUtils.writeToString(value));
        }
    }

    private static class TimestampJsonDeserializer extends JsonDeserializer<Timestamp> {
        public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return JacksonObjectMapperUtils.readTimestamp(jp.getText());
        }
    }

    private static class CalendarJsonDeserializer extends JsonDeserializer<Calendar> {
        public Calendar deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return JacksonObjectMapperUtils.readCalendar(jp.getText());
        }
    }

    private static String writeToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
        return sdf.format(date);
    }

    private static String writeToString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
        sdf.setCalendar(calendar);
        return sdf.format(calendar.getTime());
    }

    private static String writeToString(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT_STRING);
        return sdf.format(new Date(timestamp.getTime()));
    }

    private static Date readDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
            return sdf.parse(dateString);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Calendar readCalendar(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
            Date date = sdf.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Timestamp readTimestamp(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT_STRING);
            Date date = sdf.parse(dateString);
            return new Timestamp(date.getTime());
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}