package ru.nsu.hci.bayrakh.javalabs.lab6;

public class Point2DPolar extends Point3DPolar {
    Point2DPolar(Point2D s) {
        super(s);
    }

    public static Point2D toDescartes(Point2DPolar a) {
        final double
                x = a.getR() * Math.cos(a.getLat()),
                y = a.getR() * Math.sin(a.getLat());
        return new Point2D(x, y);
    }

    public double getAngle() {
        return getLat();
    }

    @Override
    public String toString() {
        return String.format("(r: %.3f, ang: %.3f)", getR(), getLat());
    }
}
