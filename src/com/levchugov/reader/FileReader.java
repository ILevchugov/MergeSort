package com.levchugov.reader;

import java.io.File;
import java.io.FileWriter;

import java.util.Scanner;

public class FileReader  {
    private Scanner scanner;
    private File file;

    public FileReader(String fileName) throws Exception{
        file = new File(fileName);
        scanner = new Scanner(file);
    }


    public int getNumFromFile() {
        return scanner.nextInt();
    }
    public String getStrFromFile(){
        return scanner.nextLine();
    }

    public boolean hasNums () {
        return scanner.hasNextInt();
    }
    public boolean hasLine(){
        if (scanner.hasNextInt()) return false;
        return scanner.hasNextLine();
    }


    public static void writeElementToFile(String element, String outputFile) throws Exception{

        try (FileWriter fileWriter = new FileWriter(outputFile,true)){
            fileWriter.write(element);
            fileWriter.write("\n");
            fileWriter.flush();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
