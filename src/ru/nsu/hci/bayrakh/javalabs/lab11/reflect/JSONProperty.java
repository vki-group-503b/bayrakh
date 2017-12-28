package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONProperty {
    String name() default "";
    boolean force() default false;
}
