package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class Args {
    private String directory;
    private String output;
    private List<String> ext = new ArrayList<>();

    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.directory = args[++i];
            } else if (args[i].equals("-o")) {
                this.output = args[++i];
            } else if (args[i].equals("-e")) {
                this.ext.add(args[++i]);
            }
        }
    }

    public String getDirectory() {
        return directory;
    }

    public String getOutput() {
        return output;
    }

    public List<String> getExt() {
        return ext;
    }
}
