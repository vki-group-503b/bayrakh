package ru.nsu.hci.bayrakh.javalabs.lab10;

public class Vector3D extends Point3D {
    Vector3D() {
        this(0, 0, 0);
    }

    Vector3D(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("Vector3D(%.3f, %.3f, %.3f)", x, y, z);
    }
}

