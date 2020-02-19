package com.levchugov.parser;

import java.util.ArrayList;

public class CommandLineParser {

    String[] args;

    public CommandLineParser(String [] args){
        this.args = args;
    }

    public ArrayList getFileNames(){
        ArrayList FileNames = new ArrayList();
        for (String arg : args){
            if (arg.contains(".txt"))
                FileNames.add(arg);
        }
        return FileNames;
    }

    public String getOutputFile(){
        try {
            return this.getFileNames().get(0).toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public ArrayList getInputFiles(){
        ArrayList InputFiles = new ArrayList();
        try {
            InputFiles = this.getFileNames();
            InputFiles.remove(0);
        } catch (Exception e){
            System.out.println(e);
        }
        return InputFiles;
    }

    public Boolean isStringMode(){
        for (String arg : args){
            if (arg.contains("-s"))
                return true;
        }
        return false;
    }

    public Boolean isIntMode(){
        for (String arg : args){
            if (arg.contains("-i"))
                return true;
        }
        return false;
    }

    public Boolean isDescending(){
        for (String arg : args){
            if (arg.contains(("-d")))
                return true;
        }
        return false;
    }
}
