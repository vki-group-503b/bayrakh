package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;
import ru.nsu.hci.bayrakh.javalabs.lab11.reflect.JSONProperty;

import java.lang.reflect.Field;
import java.util.*;

public abstract class JSONValue implements Comparable<JSONValue>, JSONSerializable {
    Object value;

    public JSONValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    abstract public String toJSON();

    public static JSONValue parse(JSONScanner scanner) throws UnexpectedInputException {
        JSONValue result;
        result = scanner.tryParse(JSONString::parse);
        if (result != null) {
            return result;
        }
        result = scanner.tryParse(JSONNumber::parse);
        if (result != null) {
            return result;
        }
        result = scanner.tryParse(JSONObject::parse);
        if (result != null) {
            return result;
        }
        result = scanner.tryParse(JSONArray::parse);
        if (result != null) {
            return result;
        }
        result = scanner.tryParse(JSONBoolean::parse);
        if (result != null) {
            return result;
        }
        return JSONNull.parse(scanner);
    }

    public static boolean equals(JSONValue left, JSONValue right) {
        if (left == right) {
            return true;
        }
        if ((left == null) || (right == null)) {
            return false;
        }
        final Object leftValue = left.getValue();
        final Object rightValue = right.getValue();
        if (leftValue == rightValue) {
            return true;
        }
        if ((leftValue == null) || (rightValue == null)) {
            return false;
        }
        return leftValue.equals(rightValue);
    }

    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof JSONValue)) {
            return false;
        }
        return equals(this, (JSONValue) rhs);
    }

    @Override
    public int compareTo(JSONValue o) {
        return ((Comparable<Object>) getValue()).compareTo(o.getValue());
    }

    public static JSONBoolean wrap(boolean value) {
        return new JSONBoolean(value);
    }

    public static JSONNumber wrap(byte value) {
        return new JSONNumber((double) value);
    }

    public static JSONNumber wrap(short value) {
        return new JSONNumber((double) value);
    }

    public static JSONNumber wrap(int value) {
        return new JSONNumber((double) value);
    }

    public static JSONNumber wrap(long value) {
        return new JSONNumber((double) value);
    }

    public static JSONNumber wrap(float value) {
        return new JSONNumber((double) value);
    }

    public static JSONNumber wrap(double value) {
        return new JSONNumber(value);
    }

    public static JSONString wrap(String value) {
        return new JSONString(value);
    }

    public static JSONCustom wrap(JSONSerializable value) {
        return new JSONCustom(value);
    }

    public static JSONValue wrap(JSONValue value) {
        return value;
    }

    public static JSONArray wrap(boolean[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (boolean value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(byte[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (byte value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(short[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (short value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(int[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (int value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(long[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (long value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(float[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (float value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(double[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (double value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(String[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (String value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(JSONSerializable[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (JSONSerializable value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(JSONValue[] values) {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (JSONValue value : values) {
            list.add(value);
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(Object[] values) throws IllegalAccessException {
        ArrayList<JSONValue> list = new ArrayList<>(values.length);
        for (Object value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONArray wrap(Collection<Object> values) throws IllegalAccessException {
        ArrayList<JSONValue> list = new ArrayList<>(values.size());
        for (Object value : values) {
            list.add(JSONValue.wrap(value));
        }
        return new JSONArray(list);
    }

    public static JSONObject wrap(Map<Object, Object> map) throws IllegalAccessException {
        final TreeMap<JSONValue, JSONValue> resultMap = new TreeMap<>();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            resultMap.put(
                    JSONValue.wrap(entry.getKey()),
                    JSONValue.wrap(entry.getValue())
            );
        }
        return new JSONObject(resultMap);
    }

    public static JSONValue wrap(Object value) throws IllegalAccessException {
        if (value == null) {
            return new JSONNull();
        }
        if (value instanceof JSONValue) {
            return (JSONValue) value;
        }
        if (value instanceof JSONSerializable) {
            return wrap((JSONSerializable) value);
        }
        Class<?> valueClass = value.getClass();
        if (valueClass.isArray()) {
            return wrap((Object[]) value);
        }
        if (value instanceof Map) {
            return wrap((Map<Object, Object>) value);
        }
        if (valueClass.equals(Boolean.class)) {
            return wrap((boolean) value);
        }
        if (valueClass.equals(Byte.class)) {
            return wrap((byte) value);
        }
        if (valueClass.equals(Short.class)) {
            return wrap((short) value);
        }
        if (valueClass.equals(Integer.class)) {
            return wrap((int) value);
        }
        if (valueClass.equals(Long.class)) {
            return wrap((long) value);
        }
        if (valueClass.equals(Float.class)) {
            return wrap((float) value);
        }
        if (valueClass.equals(Double.class)) {
            return wrap((double) value);
        }
        if (valueClass.equals(String.class)) {
            return wrap((String) value);
        }
        final TreeMap<JSONValue, JSONValue> resultMap = new TreeMap<>();
        for (Field field : valueClass.getFields()) {
            JSONProperty property = field.getAnnotation(JSONProperty.class);
            String name;
            if ((property != null) && (property.name().length() > 0)) {
                name = property.name();
            } else {
                name = field.getName();
            }
            resultMap.put(
                    JSONValue.wrap(name),
                    JSONValue.wrap(field.get(value))
            );
        }
        return new JSONObject(resultMap);
    }
}
