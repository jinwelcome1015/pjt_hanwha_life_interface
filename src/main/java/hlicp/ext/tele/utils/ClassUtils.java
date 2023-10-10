package hlicp.ext.tele.utils;

import hlicp.ext.tele.exception.TeleException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public final class ClassUtils {

    private ClassUtils() {
    }

    public static List<Field> getFields(Class<?> cls) {
        List<Field> fields = new ArrayList<Field>();
        Field[] fieldArr = cls.getDeclaredFields();

        for (Field field : fieldArr) {
            int modifier = field.getModifiers();
            if ((modifier & 8) != 8 && (modifier & 16) != 16) {
                fields.add(field);
            }
        }

        Class<?> superclass = cls.getSuperclass();

        if (superclass != null) {
            if (superclass == Object.class) {
                return fields;
            }

            List<Field> superFields = getFields(cls.getSuperclass());
            if (superFields != null) {
                fields.addAll(superFields);
            }
        }

        return fields;
    }

    public static <T> T createInstance(String clsName) {
        return createInstance((String) clsName, (Object[]) null);
    }

    public static <T> T createInstance(Class<?> voCls) {
        return createInstance((Class) voCls, (Object[]) null);
    }

    public static <T> T createInstance(String clsName, Object[] objects) {
        return createInstance(forName(clsName), objects);
    }

    public static <T> T createInstance(Class<?> cls, Object[] objects) {
        Class<?>[] classes = getParameterTypes(objects);
        return createInstance(cls, objects, classes);
    }

    public static Class<?>[] getParameterTypes(Object[] objects) {
        Class<?>[] classes = null;
        if (objects != null) {
            classes = new Class[objects.length];
            int i = 0;
            Object[] arr$ = objects;
            int len$ = objects.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                Object obj = arr$[i$];
                classes[i++] = obj.getClass();
            }
        }

        return classes;
    }

    public static <T> T createInstance(Class cls, Object[] objects, Class<?>[] classes) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(classes);
            return (T) declaredConstructor.newInstance(objects);
        }
        catch (Exception var4) {
            throw new TeleException(var4);
        }
    }

    public static Class<?> getParameterizedType(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return getParameterizedType(field);
        }
        catch (Exception var3) {
            throw new TeleException(var3);
        }
    }

    public static Class<?> getParameterizedType(List<Object> list) {
        if (list != null && list.size() != 0) {
            Object object = list.get(0);
            return object.getClass();
        }
        else {
            return null;
        }
    }

    public static Class<?> getParameterizedType(Field field) {
        if (field == null) {
            return null;
        }
        else {
            Type genericType = field.getGenericType();
            if (genericType == null) {
                return null;
            }
            else if (genericType instanceof ParameterizedType) {
                ParameterizedType wrappedType = (ParameterizedType) genericType;
                return (Class) wrappedType.getActualTypeArguments()[0];
            }
            else {
                return null;
            }
        }
    }

    public static Class<?> forName(String classname) {
        try {
            return Class.forName(classname);
        }
        catch (ClassNotFoundException var2) {
            throw new TeleException(var2);
        }
    }
}