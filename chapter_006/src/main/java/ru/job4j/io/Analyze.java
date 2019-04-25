package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Analyze - server operation analysis
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 25.04.2019.
 */

public class Analyze {
    public void unavailable(String source, String target) {
        String startTime = "";
        String endTime = "";
        boolean flag = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            List<String> list = Files.readAllLines(Paths.get(source)).stream().filter(str -> str.length() > 0).collect(Collectors.toList());
            for (String s : list) {
                if ((s.startsWith("400") || s.startsWith("500"))) {
                    String[] split = s.split(" ");
                    if (startTime.isEmpty()) {
                        startTime = s.split(" ")[1];
                        flag = true;
                    }
                } else if (flag) {
                    endTime = s.split(" ")[1];
                    flag = false;
                }
                if (!startTime.isEmpty() && !endTime.isEmpty()) {
                    writer.write(startTime + ";" + endTime + "\n");
                    startTime = "";
                    endTime = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
