package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONBoolean;
import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONNumber;
import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONValue;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SerializeTest {
    @Test
    void serialize_null() throws IllegalAccessException {
        assertEquals(Serialize.serialize((Object) null), "null");
    }

    @Test
    void serialize_bool() {
        assertEquals(Serialize.serialize(true), "true");
        assertEquals(Serialize.serialize(false), "false");
    }

    @Test
    void serialize_byte() {
        assertEquals(Serialize.serialize((byte) 17), "17");
    }

    @Test
    void serialize_short() {
        assertEquals(Serialize.serialize((short) 1021), "1021");
    }

    @Test
    void serialize_int() {
        assertEquals(Serialize.serialize((int) -16221), "-16221");
    }

    @Test
    void serialize_long() {
        assertEquals(Serialize.serialize((long) -1210590113), "-1.210590113e9");
    }

    @Test
    void serialize_float() {
        assertEquals(Serialize.serialize((float) -16.25), "-16.25");
    }

    @Test
    void serialize_double() {
        assertEquals(Serialize.serialize((double) 1.62e30), "1.62e30");
    }

    @Test
    void serialize_string() {
        assertEquals(Serialize.serialize("Hello, world!"), "\"Hello, world!\"");
    }

    @Test
    void serialize_class_object() throws IllegalAccessException {
        assertEquals(Serialize.serialize(new Point(1, -3)), "{\"x\":1,\"y\":-3}");
    }

    @Test
    void serialize_serializable_class_object() throws IllegalAccessException {
        assertEquals(Serialize.serialize(new SerializablePoint(1, -3)), "[1,-3]");
    }

    @Test
    void serialize_json_value() {
        assertEquals(Serialize.serialize(new JSONBoolean(true)), "true");
    }


    @Test
    void serialize_bool_array() {
        assertEquals(
                Serialize.serialize(new boolean[]{true, false, true}),
                "[true,false,true]"
        );
    }

    @Test
    void serialize_byte_array() {
        assertEquals(
                Serialize.serialize(new byte[]{1, 2, -100}),
                "[1,2,-100]"
        );
    }

    @Test
    void serialize_short_array() {
        assertEquals(
                Serialize.serialize(new short[]{1024, 2048, -100}),
                "[1024,2048,-100]"
        );
    }

    @Test
    void serialize_int_array() {
        assertEquals(
                Serialize.serialize(new int[]{10100100, 210100100, -100}),
                "[1.01001e7,2.101001e8,-100]"
        );
    }

    @Test
    void serialize_long_array() {
        assertEquals(
                Serialize.serialize(new long[]{1010010012, 210100100, -100}),
                "[1.010010012e9,2.101001e8,-100]"
        );
    }

    @Test
    void serialize_float_array() {
        assertEquals(
                Serialize.serialize(new float[]{(float)2.5, (float)-1.25}),
                "[2.5,-1.25]"
        );
    }

    @Test
    void serialize_double_array() {
        assertEquals(
                Serialize.serialize(new double[]{2.5e15, -1.25e7}),
                "[2.5e15,-1.25e7]"
        );
    }

    @Test
    void serialize_string_array() {
        assertEquals(
                Serialize.serialize(new String[]{
                        "Hello, world!",
                        "Hello, kitty!"
                }),
                "[\"Hello, world!\",\"Hello, kitty!\"]"
        );
    }

    @Test
    void serialize_class_object_array() throws IllegalAccessException {
        assertEquals(
                Serialize.serialize(new Point[]{
                        new Point(1,-3),
                        new Point(2,-10)
                }),
                "[{\"x\":1,\"y\":-3},{\"x\":2,\"y\":-10}]"
        );
    }

    @Test
    void serialize_serializable_class_object_array() throws IllegalAccessException {
        assertEquals(
                Serialize.serialize(new SerializablePoint[]{
                        new SerializablePoint(1,-3),
                        new SerializablePoint(2,-10)
                }),
                "[[1,-3],[2,-10]]"
        );
    }

    @Test
    void serialize_json_value_array() {
        assertEquals(
                Serialize.serialize(new JSONValue[]{
                        new JSONBoolean(true),
                        new JSONNumber(42.0)
                }),
                "[true,42]"
        );
    }

    @Test
    void serialize_list() throws IllegalAccessException {
        assertEquals(
                Serialize.serialize(Arrays.asList(1,2.5,false)),
                "[1,2.5,false]"
        );
    }

    @Test
    void serialize_map() throws IllegalAccessException{
        final HashMap<Object, Object> map = new HashMap<>();
        map.put("x", 1);
        map.put("2","y");
        assertEquals(
                Serialize.serialize(map),
                "{\"2\":\"y\",\"x\":1}"
        );
    }
}