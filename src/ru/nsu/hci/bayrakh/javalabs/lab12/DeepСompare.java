package ru.nsu.hci.bayrakh.javalabs.lab12;

import java.lang.reflect.Field;

public class DeepСompare {
    private static boolean isSimple(Class<?> objectClass) {
        return objectClass.isPrimitive() ||
                objectClass.equals(Boolean.class) ||
                objectClass.equals(Byte.class) ||
                objectClass.equals(Character.class) ||
                objectClass.equals(Short.class) ||
                objectClass.equals(Integer.class) ||
                objectClass.equals(Long.class) ||
                objectClass.equals(Float.class) ||
                objectClass.equals(Double.class) ||
                objectClass.equals(String.class);
    }

    private static <T> boolean Compare(T left, T right, PairSet passedPairs) throws IllegalAccessException {
        if ((passedPairs.has(left, right)) || (left.equals(right))) {
            return true;
        }
        passedPairs.add(left, right);
        Class<?> leftClass = left.getClass();
        if ((!leftClass.equals(right.getClass())) || (isSimple(leftClass))) {
            return false;
        }
        for (Field f : leftClass.getFields()) {
            if (!Compare(f.get(left), f.get(right), passedPairs)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean Compare(T left, T right) throws IllegalAccessException {
        return Compare(left, right, new PairSet());
    }
}
