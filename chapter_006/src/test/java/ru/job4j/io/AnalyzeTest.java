package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * AnalyzeTest - test for Analyze.class
 *
 * @author Artur Glyzin.
 * @version 4.0.
 * @since 28.04.2019.
 */

public class AnalyzeTest {

    private Analyze analyze;

    @Before
    public void setUp() {
        analyze = new Analyze();
    }

    @Test
    public void whenUnavailableServer1() throws IOException, URISyntaxException {
        String path = System.getProperty("java.io.tmpdir") + File.separator + "test1.txt";
        URL url = AnalyzeTest.class.getClassLoader().getResource("server1.info");
        String source = Paths.get(url.toURI()).toString();
        analyze.unavailable(source, path);
        List<String> expected = Arrays.asList("10:57:01;10:59:01", "11:01:02;11:02:02");
        assertTrue(checkDataFile(path, expected));
    }

    @Test
    public void whenUnavailableServer2() throws IOException, URISyntaxException {
        String path = System.getProperty("java.io.tmpdir") + File.separator + "test2.txt";
        URL url = AnalyzeTest.class.getClassLoader().getResource("server2.info");
        String source = Paths.get(url.toURI()).toString();
        analyze.unavailable(source, path);
        List<String> expected = Arrays.asList("10:58:01;10:59:01", "11:01:02;11:02:02");
        assertTrue(checkDataFile(path, expected));
    }

    @Test
    public void whenUnavailableServer3() throws IOException, URISyntaxException {
        String path = System.getProperty("java.io.tmpdir") + File.separator + "test3.txt";
        URL url = AnalyzeTest.class.getClassLoader().getResource("server3.info");
        String source = Paths.get(url.toURI()).toString();
        analyze.unavailable(source, path);
        List<String> expected = Arrays.asList("10:56:01;10:59:01", "11:01:02;11:02:02", "11:05:02;11:06:02");
        assertTrue(checkDataFile(path, expected));
    }

    @Test
    public void whenUnavailableServer4() throws IOException, URISyntaxException {
        String path = System.getProperty("java.io.tmpdir") + File.separator + "test4.txt";
        URL url = AnalyzeTest.class.getClassLoader().getResource("server4.info");
        String source = Paths.get(url.toURI()).toString();
        analyze.unavailable(source, path);
        List<String> expected = new ArrayList<>();
        assertTrue(checkDataFile(path, expected));
    }

    @Test
    public void whenUnavailableServer5() throws IOException, URISyntaxException {
        String path = System.getProperty("java.io.tmpdir") + File.separator + "test5.txt";
        URL url = AnalyzeTest.class.getClassLoader().getResource("server5.info");
        String source = Paths.get(url.toURI()).toString();
        analyze.unavailable(source, path);
        List<String> expected = Arrays.asList("10:56:01;11:06:02");
        assertTrue(checkDataFile(path, expected));
    }

    @Test
    public void whenUnavailableServer6() throws IOException, URISyntaxException {
        String path = System.getProperty("java.io.tmpdir") + File.separator + "test6.txt";
        URL url = AnalyzeTest.class.getClassLoader().getResource("server6.info");
        String source = Paths.get(url.toURI()).toString();
        analyze.unavailable(source, path);
        List<String> expected = Arrays.asList("10:56:01;10:57:01", "10:58:01;10:59:01", "11:01:02;11:02:02", "11:05:02;11:06:02");
        assertTrue(checkDataFile(path, expected));
    }

    private boolean checkDataFile(String path, List<String> content) throws IOException {
        List<String> listLines = Files.readAllLines(Paths.get(path));
        return listLines.containsAll(content);
    }
}