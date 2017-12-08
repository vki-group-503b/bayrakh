package ru.nsu.hci.bayrakh.javalabs.lab10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionTest {
    @Test
    void mapper_maps_point_to_inherited_vector() throws Exception {
        Point3D point = new Point3D(1, 5, -2);
        Mapper<Point3D, Vector3D> mapper = new Mapper<>(Point3D.class, Vector3D.class);
        Vector3D vector = mapper.Map(point);
        assertEquals(vector.getX(), point.getX());
        assertEquals(vector.getY(), point.getY());
        assertEquals(vector.getZ(), point.getZ());
    }
}
