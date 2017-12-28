package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeserializeTest {
    @Test
    void deserialize_null() throws Exception {
        assertEquals(
                Deserialize.deserialize(Object.class, "null"),
                null
        );
    }

    @Test
    void deserialize_bool() throws Exception {
        assertEquals(
                Deserialize.deserialize(Boolean.class, "true"),
                true
        );
        assertEquals(
                Deserialize.deserialize(Boolean.class, "false"),
                false
        );
    }

    @Test
    void deserialize_byte() throws Exception {
        assertEquals(
                Deserialize.deserialize(Byte.class, "127").byteValue(),
                127
        );
    }

    @Test
    void deserialize_short() throws Exception {
        assertEquals(
                Deserialize.deserialize(Short.class, "128").shortValue(),
                128
        );
    }

    @Test
    void deserialize_int() throws Exception {
        assertEquals(
                Deserialize.deserialize(Integer.class, "2147483646").intValue(),
                2147483646
        );
    }

    @Test
    void deserialize_long() throws Exception {
        assertEquals(
                Deserialize.deserialize(Long.class, "2147483646").longValue(),
                2147483646
        );
    }

    @Test
    void deserialize_float() throws Exception {
        assertEquals(
                Deserialize.deserialize(Float.class, "2.5").floatValue(),
                2.5
        );
    }

    @Test
    void deserialize_double() throws Exception {
        assertEquals(
                Deserialize.deserialize(Double.class, "2.5e100").doubleValue(),
                2.5e100
        );
    }

    @Test
    void deserialize_string() throws Exception {
        assertEquals(
                Deserialize.deserialize(String.class, "\"Hello, world!\""),
                "Hello, world!"
        );
    }

    @Test
    void deserialize_primitive_array() throws Exception {
        assertArrayEquals(
                new int[]{1,2,3},
                Deserialize.deserialize(int[].class, "[1,2,3.5]")
        );
    }

    @Test
    void deserialize_class_object() throws Exception {
        assertEquals(
                new Point(1,3),
                Deserialize.deserialize(Point.class, "{\"x\": 1, \"y\": 3}")
        );
    }

    @Test
    void deserialize_deserializable_class_object() throws Exception {
        assertEquals(
                new SerializablePoint(1,3),
                Deserialize.deserialize(SerializablePoint.class, "[1, 3]")
        );
    }

    // TODO More complex tests

}