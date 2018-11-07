package ru.job4j.collections.sort;

import java.util.Comparator;

/**
 * Class StringsCompareTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 07.11.2018.
 */

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        int ln1 = str1.length();
        int ln2 = str2.length();
        int index = 0;

        int len = Math.min(ln1, ln2);

        while (index < len) {
            char c1 = str1.charAt(index);
            char c2 = str2.charAt(index);
            if (c1 != c2) {
                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 != c2) {
                    c1 = Character.toLowerCase(c1);
                    c2 = Character.toLowerCase(c2);
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
            }
            index++;
        }
        return ln1 - ln2;
    }
}
