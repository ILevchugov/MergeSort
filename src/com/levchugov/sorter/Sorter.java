package com.levchugov.sorter;
import com.levchugov.reader.FileReader;



import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
    private FileReader[] fileReader;

    public Sorter(String[] inputFileNames) throws Exception {
        fileReader = new FileReader[inputFileNames.length];
        for (int i = 0; i < inputFileNames.length; i++) {
            fileReader[i] = new FileReader(inputFileNames[i]);
        }
    }
    private void removeFileReader(int index){ //сдвиг
        for (int i = index; i < fileReader.length-1; i++ )
            fileReader[i] = fileReader[i+1];

    }

    private ArrayList<Integer> getNumList() {
        ArrayList<Integer> elementList = new ArrayList<>();
        for (int i = 0; i < fileReader.length; i++) {
            if (fileReader[i].hasNums()) {
                elementList.add(fileReader[i].getNumFromFile());
            }
        }
        return elementList;
    }

    private void getNextNum(ArrayList<Integer> nums, int i) {
        if (fileReader[i].hasNums()){
            nums.set(i, fileReader[i].getNumFromFile());
        }
    }

    private ArrayList<String> getStrList(){
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < fileReader.length; i++) {
            if (fileReader[i].hasLine()) {
                strList.add(fileReader[i].getStrFromFile());
            }
        }
        return strList;
    }
    private void getNextStr(ArrayList<String> str, int i) {
        if (fileReader[i].hasLine()){
            str.set(i, fileReader[i].getStrFromFile());
        }
    }

    /*
    Считываем по элементу из каждого файла минимальный/максимальный записываем, читываем следующий элемент, пока не прочтем
    элементы из каждого файла
    размещаем либо по убыванию, либо по возрастанию
     */
    public void MergeSort(String outputFileName, boolean isDescending, boolean isIntMode) throws Exception {
        ArrayList nums;
        if (isIntMode) {
            nums = this.getNumList();
        } else {
            nums = this.getStrList();
        }
        if (!isDescending) {
            Object min;
            while (!nums.isEmpty()) {
                min = Collections.min(nums);
                int index = nums.indexOf(min);
                FileReader.writeElementToFile(min.toString(), outputFileName);
                if (isIntMode) {
                    if (fileReader[index].hasNums())
                        getNextNum(nums, index);
                    else {
                        nums.remove(index);
                        this.removeFileReader(index);
                    }
                }
                else{
                    if (fileReader[index].hasLine())
                        getNextStr(nums, index);
                    else {
                        nums.remove(index);
                        this.removeFileReader(index);
                    }
                }
            }
        } else {
            Object max;
            while (!nums.isEmpty()) {
                max = Collections.max(nums);
                int index = nums.indexOf(max);
                FileReader.writeElementToFile(max.toString(), outputFileName);
                if (isIntMode) {
                    if (fileReader[index].hasNums())
                        getNextNum(nums, index);
                    else {
                        nums.remove(index);
                        this.removeFileReader(index);
                    }
                }
                else{
                    if (fileReader[index].hasLine())
                        getNextStr(nums, index);
                    else {
                        nums.remove(index);
                        this.removeFileReader(index);
                    }
                }
            }
        }
    }



}
