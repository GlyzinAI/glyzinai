package ru.job4j.collections.list;

import java.util.List;

/**
 * ConvertList2ArrayVer1 - conversion ArrayList in array[][]
 *
 * @author Artur Glyzin
 * @since 07.10.2018
 * @version 1.0.
 */

public class ConvertList2ArrayVer1 {

    /**
     * method toArray
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
                if (count >= list.size()) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = list.get(count++);
                }
            }
        }

        return array;

    }
}
