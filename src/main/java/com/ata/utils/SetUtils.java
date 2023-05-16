package com.ata.utils;

import java.util.Set;

public class SetUtils {
    /**
     * To transform a Set<String> to a String[] array
     *
     * @param set
     * @return
     */
    public static String[] toArray(Set<String> set) {
        String[] array = new String[set.size()];
        set.toArray(array);
        return array;
    }
}
