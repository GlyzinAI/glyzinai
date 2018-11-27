package ru.job4j.collections.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Class Department - sorting departments.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.11.2018.
 */

public class Department {

    /**
     * Codes of departments that need to be sorted.
     */
    private final String[] departments;

    /**
     * Local List contains codes of departments.
     */
    private List<List<String>> localDepartment = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param departments - Codes of departments that need to be sorted.
     */
    public Department(String[] departments) {
        this.departments = departments;
        parseCodes();
    }

    /**
     * Converts a string with department code to an local List.
     */
    private void parseCodes() {
        for (String currentCode : departments) {
            String separator = "\\\\";
            String[] splitCodes = currentCode.split(separator);
            List<String> currentArray = new ArrayList<>();
            for (int i = 0; i < splitCodes.length; i++) {
                currentArray.add(splitCodes[i]);
                addCode(currentArray);
            }
        }
    }

    /**
     * Ascend sort department codes
     *
     * @return sorted department codes in String[]
     */
    public String[] departmentSortUp() {
        Comparator<List<String>> comparator = sortUpDownComparator(1);
        localDepartment.sort(comparator);
        return toStringArray();
    }

    /**
     * Descend sort department codes
     *
     * @return sorted department codes in String[]
     */

    public String[] departmentSortDown() {
        Comparator<List<String>> comparator = sortUpDownComparator(-1);
        localDepartment.sort(comparator);
        return toStringArray();
    }


    /**
     * Add passed array of department code in local List if not exist.
     *
     * @param codesArray new array of department code
     */
    private void addCode(List<String> codesArray) {
        List<String> newCodes = new ArrayList<>();
        newCodes.addAll(codesArray);

        if (!localDepartment.contains(newCodes)) {
            localDepartment.add(newCodes);
        }
    }

    /**
     * Convert local List to String[].
     *
     * @return - sorted department codes in String[]
     */
    private String[] toStringArray() {
        String[] result = new String[localDepartment.size()];
        for (List<String> currentCode : localDepartment) {
            StringBuilder sb = new StringBuilder();
            for (String partCode : currentCode) {
                sb.append(partCode);
                if (currentCode.indexOf(partCode) < currentCode.size() - 1) {
                    sb.append("\\");
                }
            }
            result[localDepartment.indexOf(currentCode)] = sb.toString();
        }

        return result;
    }

    /**
     * Comparator for sorting.
     *
     * @param ascend 1 - ascend sort, -1 - descend sort.
     * @return comparator
     */
    private Comparator<List<String>> sortUpDownComparator(int ascend) {
        Comparator<List<String>> comparator = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;

                Iterator<String> it1 = o1.iterator();
                Iterator<String> it2 = o2.iterator();
                while (it1.hasNext() && it2.hasNext() && result == 0) {
                    result = ascend * it1.next().compareTo(it2.next());
                }
                if (result == 0) {
                    result = Integer.valueOf(o1.size()).compareTo(Integer.valueOf(o2.size()));
                }
                return result;
            }
        };
        return comparator;
    }
}