package ru.job4j.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertMatrix - conversions array to list.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 14.10.2018.
 */

public class ConvertMatrix {

    /**
     * @param array - input array.
     * @return list.
     */

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
