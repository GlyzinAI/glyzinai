package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Search - scanning the file system
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 01.05.2019.
 */

public class Search {
    public List<File> files(String source, List<String> exts) {
        List<File> list = new ArrayList<>();
        File directory = new File(source);
        File[] allFiles = directory.listFiles();
        if (allFiles != null) {
            for (String ext : exts) {
                list.addAll(Arrays.stream(allFiles).filter(f -> f.isFile() && f.getName().endsWith(ext)).collect(Collectors.toList()));
            }
        }
        return list;
    }
}
