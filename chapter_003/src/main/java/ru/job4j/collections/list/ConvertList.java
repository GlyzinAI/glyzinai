package ru.job4j.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ConvertList - conversion ArrayList in array[][]
 *
 * @author Artur Glyzin
 * @version 4.0.
 * @since 11.12.2018
 */

public class ConvertList {

    /**
     * method toArray
     *
     * @param list - input list
     * @param rows - number of rows
     * @return - array[][]
     */

    public static int[][] toArray(List<Integer> list, int rows) {
        int cell = (int) (Math.ceil((double) list.size() / rows));
        int[][] array = new int[rows][cell];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cell; j++) {
                if (count < list.size()) {
                    array[i][j] = list.get(count++);
                }
            }
        }
        return array;
    }

    /**
     * @param list - list int[]
     * @return - list
     */

    public List<Integer> convert(List<int[]> list) {
        return list.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
    }
}
