package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class Args {
    private String directory;
    private List<String> ext = new ArrayList<>();
    private String output;

    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("-d".equals(args[i])) {
                this.directory = args[++i];
            } else if ("-e".equals(args[i])) {
                this.ext.add(args[++i]);
            } else if ("-o".equals(args[i])) {
                this.output = args[++i];
            }
        }
    }

    public String getDirectory() {
        return directory;
    }

    public List<String> getExt() {
        return ext;
    }

    public String getOutput() {
        return output;
    }
}
