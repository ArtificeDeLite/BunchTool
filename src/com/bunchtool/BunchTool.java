package com.bunchtool;

import java.io.File;

public class BunchTool {
    private static final String NEW_ENDING = ".2019";

    public static void main(String[] args) {

        if (args.length == 0 || args[0] == null) {
            System.out.println("Directory is not defined!");
            System.out.println("Please define directory as program argument.");
            return;
        }

        String folderPath = args[0];
        File folder = new File(folderPath);

        if(!folder.isDirectory()) {
            System.out.println("Defined directory is incorrect!");
            return;
        }
        renameFiles(folder);
    }

    private static void renameFiles(File folder) {
        File[] folders = folder.listFiles();

        for (File currentFile: folders) {

            if (currentFile.isDirectory()){
                renameFiles(currentFile);
                continue;
            }

            if(currentFile.getName().toLowerCase().endsWith(".java") || currentFile.getName().toLowerCase().endsWith(".kt")){
                File newFile = new File(currentFile.getPath() + NEW_ENDING);

                if (currentFile.canWrite()) {
                    if (currentFile.renameTo(newFile)) {
                        System.out.println(newFile);
                    }
                }
            }
        }
    }

}