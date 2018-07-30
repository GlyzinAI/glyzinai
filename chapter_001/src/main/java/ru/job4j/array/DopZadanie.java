package ru.job4j.array;

/**
 * Merge array1 && array2(sorted).
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 30.07.2018.
 */

public class DopZadanie {
    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            c[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }
}
