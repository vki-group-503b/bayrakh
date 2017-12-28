package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

import ru.nsu.hci.bayrakh.javalabs.lab11.data.*;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

public class Deserialize {
    private static boolean isNumberClass(Class<?> c) {
        return c.equals(Byte.class)
                || c.equals(Byte.TYPE)
                || c.equals(Short.class)
                || c.equals(Short.TYPE)
                || c.equals(Integer.class)
                || c.equals(Integer.TYPE)
                || c.equals(Long.class)
                || c.equals(Long.TYPE)
                || c.equals(Float.class)
                || c.equals(Float.TYPE)
                || c.equals(Double.class)
                || c.equals(Double.TYPE);
    }

    public static <T> T deserialize(Class<T> resultClass, JSONValue parseResult)
            throws WrongStructureException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if ((parseResult == null) || (parseResult instanceof JSONNull)) {
            return null;
        }
        if (resultClass.equals(Boolean.class) || resultClass.equals(Boolean.TYPE)) {
            if (!(parseResult instanceof JSONBoolean)) {
                throw new WrongStructureException();
            }
            return (T) ((JSONBoolean) parseResult).getValue();
        }
        if (isNumberClass(resultClass)) {
            if (!(parseResult instanceof JSONNumber)) {
                throw new WrongStructureException();
            }
            Double value = ((JSONNumber) parseResult).getValue();
            if (resultClass.equals(Byte.class) || resultClass.equals(Byte.TYPE)) {
                return (T) (Byte) value.byteValue();
            }
            if (resultClass.equals(Short.class) || resultClass.equals(Short.TYPE)) {
                return (T) (Short) value.shortValue();
            }
            if (resultClass.equals(Integer.class) || resultClass.equals(Integer.TYPE)) {
                return (T) (Integer) value.intValue();
            }
            if (resultClass.equals(Long.class) || resultClass.equals(Long.TYPE)) {
                return (T) (Long) value.longValue();
            }
            if (resultClass.equals(Float.class) || resultClass.equals(Float.TYPE)) {
                return (T) (Float) value.floatValue();
            }
            return (T) value;
        }
        if (resultClass.equals(String.class)) {
            if (!(parseResult instanceof JSONString)) {
                throw new WrongStructureException();
            }
            return (T) ((JSONString) parseResult).getValue();
        }
        if (resultClass.isArray()) {
            if (!(parseResult instanceof JSONArray)) {
                throw new WrongStructureException();
            }
            Collection<JSONValue> elements = ((JSONArray) parseResult).getValue();
            Class<?> componentClass = resultClass.getComponentType();
            Object result = Array.newInstance(componentClass, elements.size());
            int i = 0;
            for (JSONValue element : elements) {
                Array.set(result, i++, deserialize(componentClass, element));
            }
            return (T) result;
        }
        try {
            return resultClass.getConstructor(JSONValue.class).newInstance(parseResult);
        } catch (NoSuchMethodException e) {
        }
        if (!(parseResult instanceof JSONObject)) {
            throw new WrongStructureException();
        }
        Map<JSONValue, JSONValue> map = ((JSONObject) parseResult).getValue();
        T result = resultClass.newInstance();
        for (Field field : resultClass.getFields()) {
            JSONProperty property = field.getAnnotation(JSONProperty.class);
            JSONString name;
            boolean force;
            if (property == null) {
                name = new JSONString(field.getName());
                force = false;
            } else {
                if (property.name().length() == 0) {
                    name = new JSONString(field.getName());
                } else {
                    name = new JSONString(property.name());
                }
                force = property.force();
            }
            if (map.containsKey(name)) {
                field.set(result, map.get(name).getValue());
            } else {
                if (force) {
                    throw new WrongStructureException();
                }
            }
        }
        return result;
    }

    public static <T> T deserialize(Class<T> resultClass, JSONScanner scanner)
            throws UnexpectedInputException, WrongStructureException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return deserialize(resultClass, JSONValue.parse(scanner));
    }

    public static <T> T deserialize(Class<T> resultClass, String input)
            throws UnexpectedInputException, WrongStructureException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return deserialize(resultClass, new JSONScanner(input));
    }
}
