package ru.nsu.hci.bayrakh.javalabs.lab6;

public class Point2D extends Point3D {
    Point2D(double x, double y) {
        super(x, y, 0);
    }

    public static Point2DPolar toPolar(Point2D a) {
        return new Point2DPolar(a);
    }

    @Override
    public String toString() {
        return String.format("(x: %.3f, y: %.3f)", getX(), getY());
    }
}
