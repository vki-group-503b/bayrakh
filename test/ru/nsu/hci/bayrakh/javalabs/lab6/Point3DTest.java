package ru.nsu.hci.bayrakh.javalabs.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {
    @Test
    void getModule() {
        Point3D p = new Point3D(3,0, 4);
        assertEquals(Point3D.getModule(p), 5);
    }

    @Test
    void getDistance() {
        Point3D a = new Point3D(3,0, 4);
        Point3D b = new Point3D(6,0, 8);
        assertEquals(Point3D.getDistance(a, b), 5);
    }

    @Test
    void isAtSameLine() {
        Point3D a = new Point3D(3,1, 4);
        Point3D b = new Point3D(6,2, 8);
        Point3D c = new Point3D(9,3, 12);
        assert Point3D.isAtSameLine(a, b, c);
        Point3D d = new Point3D(9,3, 10);
        assert !Point3D.isAtSameLine(a, b, d);
    }

    @Test
    void isAtSamePlate() {
        Point3D a = new Point3D(3,3, 100);
        Point3D b = new Point3D(6,6, 8);
        Point3D c = new Point3D(9,9, 12);
        Point3D d = new Point3D(12,12, 10);
        assert Point3D.isAtSamePlate(a, b, c, d);
        Point3D e = new Point3D(12,13, 10);
        assert !Point3D.isAtSamePlate(a, b, c, e);
    }

    @Test
    void toPolar() {
        Point3DPolar a = Point3D.toPolar(new Point3D(1, 0, 0));
        assertEquals(a.getR(), 1);
        assertEquals(a.getLat(), 0);
        assertEquals(a.getLon(), 0);
        Point3DPolar b = Point3D.toPolar(new Point3D(0, 1, 0));
        assertEquals(b.getR(), 1);
        assertEquals(b.getLat(), Math.PI/2);
        assertEquals(b.getLon(), 0);
        Point3DPolar c = Point3D.toPolar(new Point3D(0, 0, 1));
        assertEquals(c.getR(), 1);
        assertEquals(c.getLat(), Math.PI/2);
        assertEquals(c.getLon(), Math.PI/2);
    }

}