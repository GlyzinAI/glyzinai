package ru.job4j.collections.list;

import java.util.List;

/**
 * ConvertList - conversion ArrayList in array[][]
 *
 * @author Artur Glyzin
 * @version 2.0.
 * @since 13.10.2018
 */

public class ConvertList {

    /**
     * method toArray
     *
     * @param list - input list
     * @param rows - number of rows
     * @return - array[][]
     */

    public int[][] toArray(List<Integer> list, int rows) {

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
}
