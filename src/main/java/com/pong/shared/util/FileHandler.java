package com.pong.shared.util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void CreateFile() {
        try {
            var file = new File(this.fileName);

            if (file.createNewFile()) {
                System.out.println("Created File: " + file.getName());
            } else {
                System.out.println("File " + file.getName() + " already exists.");
            }
        } catch(IOException e) {
            System.out.println("an error occurred trying to find or create the file.");
            e.printStackTrace();
        }
    }

    public void WriteFile(String writeText) {
        try {
            var file = new FileWriter(this.fileName);

            file.write(writeText);
            file.close();
            System.out.println("Write of " + fileName + " successful");
        } catch(IOException e) {
            System.out.println("an error occurred trying to write to the file");
            e.printStackTrace();
        }
    }

    public ArrayList<String> ReadFile() {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File(this.fileName);
            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextLine())
            {
                String data = fileReader.nextLine();
                lines.add(data);
            }
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred while reading the file " + this.fileName);
        }

        return lines;
    }

}
