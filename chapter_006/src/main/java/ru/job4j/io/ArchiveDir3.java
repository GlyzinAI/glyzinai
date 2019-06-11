package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveDir3 {
    private ArrayList<String> fileList;
    private final static String OUTPUT_ZIP_FILE = "C:/hero/hero.zip";
    private final static String SOURCE_FOLDER = "C:/hero";

    public ArchiveDir3() {
        fileList = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        ArchiveDir3 archiveDir3 = new ArchiveDir3();
        archiveDir3.generateFileList(new File(SOURCE_FOLDER));
        archiveDir3.zipIt(OUTPUT_ZIP_FILE);
    }

    private void zipIt(String zipFile) throws Exception {
        byte[] buffer = new byte[1024];

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            System.out.println("Output to Zip : " + zipFile);

            for (String file : fileList) {
                System.out.println("File Added : " + file);
                ZipEntry zipEntry = new ZipEntry(file);
                zos.putNextEntry(zipEntry);

                FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
            }
            zos.closeEntry();
        }

    }

    public void generateFileList(File node) {
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String fileName : subNote) {
                generateFileList(new File(node, fileName));
            }
        }
    }

    public void generateFile(File node) {
        if (!node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String fileName : subNote) {
                generateFileList(new File(node, fileName));
            }
        }
    }

    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length() + 1, file.length());
    }
}
