package ru.nsu.hci.bayrakh.javalabs.lab12;

import org.junit.jupiter.api.Test;


class DeepСompareTest {
    @Test
    void comparing_objects_of_the_same_primitive_type() throws IllegalAccessException {
        // boolean
        assert DeepСompare.Compare(true, true);
        assert !DeepСompare.Compare(true, false);
        // byte
        assert DeepСompare.Compare((byte) 5, (byte) 5);
        assert !DeepСompare.Compare((byte) 2, (byte) 5);
        // Character
        assert DeepСompare.Compare('l', 'l');
        assert !DeepСompare.Compare('l', 'k');
        // Short
        assert DeepСompare.Compare((short) 3, (short) 3);
        assert !DeepСompare.Compare((short) 3, (short) 0);
        // integer
        assert DeepСompare.Compare((int) 1, (int) 1);
        assert !DeepСompare.Compare((int) 1, (int) 2);
        // long
        assert DeepСompare.Compare((long) 8, (long) 8);
        assert !DeepСompare.Compare((long) 8, (long) 9);
        // float
        assert DeepСompare.Compare((float) 1.5, (float) 1.5);
        assert !DeepСompare.Compare((float) 1.5, (float) 1.4);
        // double
        assert DeepСompare.Compare((double) 2.5, (double) 2.5);
        assert !DeepСompare.Compare((double) 3.4, (double) 3.3);
        // string
        assert DeepСompare.Compare("true", "true");
        assert !DeepСompare.Compare("true", "false");
    }

    @Test
    void comparing_objects_of_the_same_simple_object_type() throws IllegalAccessException {
        Point3D a = new Point3D(1, 2, 3);
        Point3D b = new Point3D(1, 2, 3);
        Point3D c = new Point3D(4, 2, 3);
        assert DeepСompare.Compare(a, a);
        assert DeepСompare.Compare(a, b);
        assert !DeepСompare.Compare(a, c);
    }

    @Test
    void comparing_objects_of_the_same_complex_object_type() throws IllegalAccessException {
        Segment a = new Segment(new Point3D(1, 2, 3), new Point3D(3, 2, 1));
        Segment b = new Segment(new Point3D(1, 2, 3), new Point3D(3, 2, 1));
        Segment c = new Segment(new Point3D(1, 2, 4), new Point3D(3, 2, 1));
        assert DeepСompare.Compare(a, a);
        assert DeepСompare.Compare(a, b);
        assert !DeepСompare.Compare(a, c);
    }

    @Test
    void comparing_objects_of_the_same_recursive_object_type() throws IllegalAccessException {
        RecursiveObject<Integer> a = new RecursiveObject<>(1, null);
        RecursiveObject<Integer> b = new RecursiveObject<>(2, a);
        a.ref = b;
        RecursiveObject<Integer> c = new RecursiveObject<>(1, null);
        RecursiveObject<Integer> d = new RecursiveObject<>(2, c);
        c.ref = d;
        assert DeepСompare.Compare(a, c);
        assert DeepСompare.Compare(b, d);
        assert !DeepСompare.Compare(a, b);
        assert !DeepСompare.Compare(a, d);
        assert !DeepСompare.Compare(b, c);
        assert !DeepСompare.Compare(c, d);


    }


}