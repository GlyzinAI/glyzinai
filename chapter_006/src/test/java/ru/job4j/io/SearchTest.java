package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * SearchTest - test for Search.class
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 01.05.2019.
 */

public class SearchTest {

    private final static String PATH = String.format("%s/%s", System.getProperty("java.io.tmpdir"), "TEST_PATH");
    private static final List<File> FILE_LIST = List.of(
            new File(PATH),
            new File(PATH),
            new File(PATH),
            new File(PATH),
            new File(PATH)
    );

    private static File file1;
    private static File file2;
    private static File file3;
    private static File file4;
    private static File file5;

    private Search search;

    @Before
    public void setUp() {
        makeDirs();
        search = new Search();
        file1 = new File(FILE_LIST.get(0), "1.java");
        file2 = new File(FILE_LIST.get(1), "2.xml");
        file3 = new File(FILE_LIST.get(2), "3.txt");
        file4 = new File(FILE_LIST.get(3), "4.avi");
        file5 = new File(FILE_LIST.get(4), "5.bpm");
        createFile(file1, file2, file3, file4, file5);

    }

    @Test
    public void whenSearchTxt() {
        assertEquals(List.of(file3), search.files(PATH, List.of("txt")));
    }

    @Test
    public void whenSearchJavaAndXml() {
        assertEquals(List.of(file1, file2), search.files(PATH, List.of("java", "xml")));
    }

    @Test
    public void whenSearchBmpAndAviAndTxt() {
        assertEquals(List.of(file5, file4, file3), search.files(PATH, List.of("bpm", "avi", "txt")));
    }

    @Test
    public void whenSearchBpm() {
        assertEquals(List.of(file5), search.files(PATH, List.of("bpm")));
    }

    @Test
    public void whenCheckEmptyList() {
        assertEquals(Collections.EMPTY_LIST, search.files(PATH, List.of(".jpeg")));
    }

    private void createFile(File... files) {
        try {
            for (File file : files) {
                if (!file.createNewFile()) {
                    continue;
                }
                file.deleteOnExit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makeDirs() {
        for (File dir : FILE_LIST) {
            if (!dir.mkdir()) {
                continue;
            }
            dir.deleteOnExit();
        }
    }
}