package ru.job4j.collections.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class ConvertMatrix - conversions array to list.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 10.12.2018.
 */

public class ConvertMatrix {

    /**
     * @param array - input array.
     * @return list.
     */

    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
    }
}
