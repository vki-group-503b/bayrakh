package ru.nsu.hci.bayrakh.javalabs.lab6;

public class Point {
    public static void main(String[] args) {
        final Point2D a = new Point2D(-1, -2);
        final Point2DPolar b = new Point2DPolar(a);
        final Point2D c = Point2DPolar.toDescartes(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
