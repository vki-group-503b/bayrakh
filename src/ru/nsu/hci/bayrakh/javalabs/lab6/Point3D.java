package ru.nsu.hci.bayrakh.javalabs.lab6;

public class Point3D {
    private double x;
    private double y;
    private double z;

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    static private Point3D getDifference(Point3D a, Point3D b) {
        return new Point3D(b.x - a.x, b.y - a.y, b.z - a.z);
    }

    static public double getModule(Point3D a) {
        return Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
    }

    static public double getDistance(Point3D a, Point3D b) {
        return getModule(getDifference(a, b));
    }

    static private boolean isDoubleSame(double a, double b) {
        return Double.compare(a, b) == 0;
    }

    static public boolean isAtSameLine(Point3D a, Point3D b, Point3D c) {
        final Point3D ab = getDifference(a, b);
        final Point3D ac = getDifference(a, c);
        final double t = ab.x / ac.x;
        return isDoubleSame(ab.y / ac.y, t) && isDoubleSame(ab.z / ac.z, t);
    }

    static public boolean isAtSamePlate(Point3D a, Point3D b, Point3D c, Point3D d) {
        if (isAtSameLine(a, b, c)
                || isAtSameLine(a, b, d)
                || isAtSameLine(a, c, d)
                || isAtSameLine(b, c, d)
                ) {
            return true;
        }
        final double
                a0 = b.x - a.x,
                a1 = b.y - a.y,
                a2 = b.z - a.z,
                a3 = c.x - a.x,
                a4 = c.y - a.y,
                a5 = c.z - a.z;
        final double
                b0 = (a1 * a5) - (a2 * a4),
                b1 = (a0 * a5) - (a2 * a3),
                b2 = (a0 * a4) - (a1 * a3);
        final double
                c0 = (a.x * b0) - (a.y * b1) + (a.z * b2),
                c1 = (d.x * b0) - (d.y * b1) + (d.z * b2);
        return isDoubleSame(c0, c1);
    }

    public static Point3DPolar toPolar(Point3D a) {
        return new Point3DPolar(a);
    }

    public String toString() {
        return String.format("(x: %.3f, y: %.3f, z: %.3f)", x, y, z);
    }
}
