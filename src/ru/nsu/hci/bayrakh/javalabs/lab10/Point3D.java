package ru.nsu.hci.bayrakh.javalabs.lab10;

public class Point3D {
    public double x;
    public double y;
    public double z;

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("Point3D(%.3f, %.3f, %.3f)", x, y, z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
