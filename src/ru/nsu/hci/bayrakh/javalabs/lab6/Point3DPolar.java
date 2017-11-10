package ru.nsu.hci.bayrakh.javalabs.lab6;

public class Point3DPolar {
    private double r;
    private double lat;
    private double lon;
    Point3DPolar(Point3D s) {
        r = Point3D.getModule(s);
        if (Double.compare(r, 0) == 0) {
            lat = 0;
            lon = 0;
            return;
        }
        lat = acos(s.getX() / r);
        final double rLatSin = r * Math.sin(lat);
        final double DoublePI = 2 * Math.PI;
        if (Double.compare(rLatSin, 0) == 0) {
            lon = 0;
        } else {
            lon = acos(s.getY() / rLatSin);
            if (Double.compare(s.getZ(), 0) < 0) {
                lon = DoublePI - lon;
            }
            if ((Double.compare(lon, Math.PI) >= 0) && (Double.compare(lat, Math.PI) <= 0)) {
                lat = DoublePI - lat;
                lon = acos(s.getY() / (r * Math.sin(lat)));
            }
        }
        lat = lat % DoublePI;
    }

    public static double acos(double cos) {
        if (Double.compare(cos, 1) >= 0) {
            return 0;
        }
        if (Double.compare(cos, -1) <= 0) {
            return Math.PI;
        }
        return Math.acos(cos);
    }

    public static Point3D toDescartes(Point3DPolar a) {
        final double
                x = a.r * Math.cos(a.lat),
                ty = a.r * Math.sin(a.lat);
        final double
                y = ty * Math.cos(a.lon),
                z = ty * Math.sin(a.lon);
        return new Point3D(x, y, z);
    }

    public double getR() {
        return r;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String toString() {
        return String.format("(r: %.3f, lat: %.3f, lon: %.3f)", r, lat, lon);
    }
}
