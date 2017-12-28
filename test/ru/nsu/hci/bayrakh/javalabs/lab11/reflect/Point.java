package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

public class Point {
    @JSONProperty(name = "x", force = true)
    public double coordinateX;
    @JSONProperty(name = "y")
    public double coordinateY;

    Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    Point() {
        this(0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        final Point rhs = (Point) obj;
        return (coordinateX == rhs.coordinateX) && (coordinateY == rhs.coordinateY);
    }
}
