package com.ysvg2tafy.studentdatabase;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtils {

    FileUtils instance = null;

    public FileUtils getInstance() {
        instance = new FileUtils();
        return instance;
    }

    public static Boolean copyFile(File sourceFile, File destFile)
            throws IOException {
        //        if (!destFile.exists()) {
        destFile.createNewFile();

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null)
                source.close();
            if (destination != null)
                destination.close();
        }
        return true;
        //        }
        //        return false;
    }

    /**
     * Read a text file into a String.
     *
     * @param file
     *            File to read (will not seek, so things like /proc files are
     *            OK).
     * @return The contents of the file as a String.
     * @throws IOException
     */
    public static String readTextFile(File file) throws IOException {
        byte[] buffer = new byte[(int) file.length()];
        BufferedInputStream stream = new BufferedInputStream(
                new FileInputStream(file));
        stream.read(buffer);
        stream.close();

        return new String(buffer);
    }

}
