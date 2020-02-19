package com.levchugov.main;

import com.levchugov.parser.CommandLineParser;
import com.levchugov.sorter.Sorter;

import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        try {
            CommandLineParser parser = new CommandLineParser(args);
            ArrayList<String> inputFiles = parser.getInputFiles();
            String[] inputFilesArray = inputFiles.toArray(new String[inputFiles.size()]);
            Sorter sorter = new Sorter(inputFilesArray);
            FileWriter fileWriter = new FileWriter(parser.getOutputFile());
            fileWriter.flush();
            sorter.MergeSort(parser.getOutputFile(), parser.isDescending(), parser.isIntMode());
            System.out.println("Слияние сортированных файлов выполненно");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }}
