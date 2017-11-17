package ru.nsu.hci.bayrakh.javalabs.lab10;

import javafx.util.Pair;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Vector;

public class Mapper<TSource, TDestination> {
    private Class<TDestination> destinationClass;
    private Vector<Pair<Field, Field>> fields;
    Mapper(Class<TSource> sourceClass, Class<TDestination> destinationClass) throws NoSuchFieldException, IllegalArgumentException {
        HashMap<String, Field> sourceFields = getFields(sourceClass);
        fields = new Vector<>();
        this.destinationClass = destinationClass;
        HashMap<String, Field> destinationFields = getFields(destinationClass);
        for (HashMap.Entry<String, Field> e : sourceFields.entrySet()) {
            if (!destinationFields.containsKey(e.getKey())) {
                throw new NoSuchFieldException(String.format(
                        "Класс %s не содержит поля %s",
                        sourceClass.getName(), e.getKey()
                ));
            }
            final Field f = e.getValue();
            final Field g = destinationFields.get(e.getKey());
            final Pair<Field, Field> p = new Pair<>(f, g);
            fields.add(p);
        }
    }
    private static HashMap<String, Field> getFields(Class<?> c) throws IllegalArgumentException {
        HashMap<String, Field> result = new HashMap<>();
        Class<?> currentClass = c;
        while (currentClass != null) {
            for (Field f : currentClass.getDeclaredFields()) {
                final String name = f.getName();
                if (result.containsKey(name)) {
                    throw new IllegalArgumentException(String.format(
                            "Класс %s содержит больше, чем одно поле %s",
                            c.getName(), name
                    ));
                }
                result.put(name, f);
            }
            currentClass = currentClass.getSuperclass();
        }
        return result;
    }
    public TDestination Map(TSource obj) throws IllegalAccessException, InstantiationException {
        TDestination result = destinationClass.newInstance();
        for (Pair<Field, Field> p : fields) {
            Field f = p.getKey();
            Field g = p.getValue();
            Object value = f.get(obj);
            g.set(result, value);
        }
        return result;
    }
}
