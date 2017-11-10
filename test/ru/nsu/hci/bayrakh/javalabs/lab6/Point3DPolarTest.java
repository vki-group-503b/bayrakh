package ru.nsu.hci.bayrakh.javalabs.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DPolarTest {
    @Test
    void toDescartes() {
        Point3D p = new Point3D(10, 15, -20);
        Point3DPolar pp = Point3D.toPolar(p);
        Point3D q = Point3DPolar.toDescartes(pp);
        assert Double.compare(Point3D.getDistance(p, q), 1e-12) <= 0;
    }

}