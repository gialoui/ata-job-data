package com.ata.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ObjectUtils {
    /**
     * Takes an object and a list of field names to keep as parameters. The method returns the object with all the other fields set to null.
     *
     * @param object
     * @param fieldsToKeep
     * @param <T>
     * @return
     */
    public static <T> T keepOnlySelectedFields(T object, String... fieldsToKeep) {
        Set<String> fieldsToKeepSet = new HashSet<>(Arrays.asList(fieldsToKeep));
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (!fieldsToKeepSet.contains(field.getName())) {
                field.setAccessible(true);
                try {
                    field.set(object, null);
                } catch(IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return object;
    }
}
