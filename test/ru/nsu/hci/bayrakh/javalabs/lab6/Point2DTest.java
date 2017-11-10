package ru.nsu.hci.bayrakh.javalabs.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {
    @Test
    void toPolar() {
        Point2DPolar a = Point2D.toPolar(new Point2D(1, 0));
        assertEquals(a.getR(), 1);
        assertEquals(a.getAngle(), 0);
        Point2DPolar b = Point2D.toPolar(new Point2D(0, 1));
        assertEquals(b.getR(), 1);
        assertEquals(b.getAngle(), Math.PI / 2);
    }

}