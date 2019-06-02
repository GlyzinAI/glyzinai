package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private List<File> fileList = new ArrayList<>();

    public void pack(File source, File target, List<String> exts) {
        byte[] buffer = new byte[1024];

        try (FileOutputStream fos = new FileOutputStream(target);
             ZipOutputStream zip = new ZipOutputStream(fos)) {
        /*try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {*/
            for (String ext : exts) {
                fileList.addAll(seekBy(source.getAbsolutePath(), ext));
            }

            for (File file : fileList) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zip.putNextEntry(zipEntry);
                FileInputStream in = new FileInputStream(source + File.separator + file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zip.write(buffer, 0, len);
                }
                in.close();
            }
            zip.closeEntry();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<File> seekBy(String root, String ext) {
        File file = new File(root);
        if (file.isFile()/* && file.getAbsolutePath().endsWith(ext)*/) {
            fileList.add(generateZipEntry(root, file));
        } else if (file.isDirectory()) {
            String[] files = file.list();
            for (String f : files) {
                seekBy(generateZipEntry(root, new File(f)).getAbsolutePath(), ext);
            }
        }
        return fileList;
    }

    private File generateZipEntry(String root, File file) {
        return new File(file.getAbsolutePath().substring(root.length() + 1, file.getName().length()));

    }


    public static void main(String[] args) {
        Args param = new Args(args);
        Zip zip = new Zip();
        File source = new File(param.getDirectory());
        File target = new File(param.getOutput());
        zip.pack(source, target, param.getExt());
    }
}