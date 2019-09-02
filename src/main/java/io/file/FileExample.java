package io.file;

import java.io.File;
import java.io.IOException;

public class FileExample {
    private static final String OUTPUT_FILE_PATH = "./src/main/resources/text-files/File-Example.txt";
    private static final String UNKNOWN_FOLDER_PATH = "./src/main/resources/text-file";
    private static final String KNOWN_FOLDER_PATH = "./src/main/resources/text-files";

    /**
     * Function to learn about File class. Following steps are taken:
     * 1. Check wheather a file exist or not.
     * 2. Check a unknown folder exist or not.
     * 3. Rename/Move a file.
     * 4. Try to delete the file with previous object.
     * 5. Delete the same file with the new object.
     * 6. List all the files under a folder.
     *
     * @param args - CLI input.
     * @throws IOException
     */
    public static void main(String [] args) throws IOException {

        // Creating a file constructor.
        File file = new File(OUTPUT_FILE_PATH);
        if (!file.exists()) {
            System.out.println(OUTPUT_FILE_PATH + " file doesn't exist, therefore making one.");
            file.createNewFile();
        }

        System.out.println("Current size of file is :: " + file.length());

        // Create a folder.
        File folder = new File(UNKNOWN_FOLDER_PATH);
        if (!folder.mkdir()) {
            System.out.println("Not able to create a folder.");
        }

        // Rename/Move a file. This doesn't create a new folder which is already not there.
        File newFile = new File("./src/main/resources/text-file/FileExample.txt");
        boolean isRenamed = file.renameTo(newFile);
        if (!isRenamed) {
            System.out.println("File was not successfully renamed.");
        }

        boolean deleted = file.delete();
        if (!deleted) {
            System.out.println("Not able to delete " + OUTPUT_FILE_PATH);
        }

        deleted = newFile.delete();
        if (deleted) {
            System.out.println("But, I was able to delete the new file.");
        }

        File knownFolder = new File(KNOWN_FOLDER_PATH);
        String [] files = knownFolder.list();
        File   [] filesObjects = knownFolder.listFiles();
        for(int i=0; i<files.length; i++) {
            System.out.println(files[i]);
        }

        for(int i=0; i<filesObjects.length; i++) {
            if(!filesObjects[i].isDirectory()) {
                System.out.print("This file " + filesObjects[i].getName() + " size is ");
            } else {
                System.out.print("This folder " + filesObjects[i].getName() + " size is ");
            }
            System.out.println(filesObjects[i].length());
        }
    }
}
