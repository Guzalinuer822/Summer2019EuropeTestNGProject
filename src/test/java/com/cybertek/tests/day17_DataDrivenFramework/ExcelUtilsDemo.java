package com.cybertek.tests.day17_DataDrivenFramework;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        // create an object from ExcelFile
        // it accepts two parameter
        // Argument1: location of the file----path
        // Argument2: sheet that what we want to open---sheetName

        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

// how many rows in the sheet
        System.out.println("Row count: " + qa3short.rowCount());

        // how many columns in the sheet
        System.out.println("Columns count: " + qa3short.columnCount());

        // get all column names ----it will give the whole list
        System.out.println("Column names: " + qa3short.getColumnsNames());

        // if you want specific one such as-----name of first column
        System.out.println("Column names: " + qa3short.getColumnsNames().get(0));

        // getDataList() ---will return list of map
        // after choose getDataList() , Alt+Enter
        // then it will create this one line for you
        List<Map<String, String>> dataList = qa3short.getDataList();

        // map is working on key and value structure
        // key---row  ?   --- check record ^_^ ---Canvas
        // value---column  ?

        // if only print one line
        System.out.println(dataList.get(0));

        // for whole line
        for(Map<String,String> oneRow:dataList){
            System.out.println(oneRow);
        }

        String[][] dataArray=qa3short.getDataArray();

        // print each row ----from 2D array
        System.out.println(Arrays.deepToString(dataArray));

    }
}
