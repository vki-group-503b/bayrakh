package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

import ru.nsu.hci.bayrakh.javalabs.lab11.data.*;

import java.util.*;

public class Serialize {
    public static String serialize(boolean value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(byte value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(short value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(int value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(long value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(float value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(double value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(String value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(JSONSerializable value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(JSONValue value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(boolean[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(byte[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(short[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(int[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(long[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(float[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(double[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(String[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(JSONSerializable[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(JSONValue[] value) {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(Object value) throws IllegalAccessException {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(Collection<Object> value) throws IllegalAccessException {
        return JSONValue.wrap(value).toJSON();
    }

    public static String serialize(Map<Object, Object> value) throws IllegalAccessException {
        return JSONValue.wrap(value).toJSON();
    }
}
