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
            File file = new File(this.fileName);

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

    /**
     * writes a single string to a file
     * @param writeText
     * the text to be written to the file
     */
    public void WriteFile(String writeText) {
        try {
            FileWriter file = new FileWriter(this.fileName);

            var trimmedText = writeText.trim();

            file.write(trimmedText);
            file.write("\n");

            file.close();
            System.out.println("Write of " + fileName + " successful");

        } catch(IOException e) {

            System.out.println("an error occurred trying to write to the file");
            e.printStackTrace();

        }
    }

    /**
     * Writes the values of an arraylist to a file
     * @param valueList
     * ArrayList of Strings to write to the file
     */
    public void WriteFile(ArrayList<String> valueList) {

        try {
            FileWriter file = new FileWriter(this.fileName);

            for(String value : valueList) {
                var trimmedText = value.trim();

                file.write(trimmedText);
                file.write("\n");
            }

            file.close();
            System.out.println("Write of " + fileName + " successful");

        } catch(IOException e) {

            System.out.println("an error occurred trying to write to the file");
            e.printStackTrace();

        }
    }

    /**
     * Reads the file and returns the lines as an ArrayList
     * @return ArrayList<String> lines
     */
    public ArrayList<String> ReadFile() {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File(this.fileName);
            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextLine())
            {
                String data = fileReader.nextLine();
                String trimmedData = data.trim();
                lines.add(trimmedData);
            }
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred while reading the file " + this.fileName);
        }

        return lines;
    }

    public boolean FileExists() {
        File file = new File(this.fileName);
        return file.exists();
    }

}
