package com.org.ttp.utils;

import com.org.ttp.glue.CommonBeforeStep;
import com.org.ttp.pojo.TTFormTestData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadTestData {

    public TTFormTestData readAndSetTestDataInPOJO(){
        Row headerRow = null,testDataRow = null;
        try{
            Workbook workbook = new XSSFWorkbook(new FileInputStream(AllConstants.TESTDATA_FILENAME.getValue()));
            Sheet sheet = workbook.getSheetAt(0);
             headerRow = sheet.getRow(0);
             testDataRow = sheet.getRow(getTestDataRowID(sheet));

        }catch(Exception e){
            e.printStackTrace();
        }
        return setTestData(headerRow,testDataRow);
    }

    public int getTestDataRowID(Sheet sheet){
        String testCaseId;
        for (int i=0; i<sheet.getLastRowNum(); i++){
            testCaseId = sheet.getRow(i).getCell(0).getStringCellValue();
            if(testCaseId.equalsIgnoreCase(AllConstants.TESTCASE_ID.getValue())){
                return i;
            }
        }
        return 0;
    }

    public TTFormTestData setTestData(Row header,Row testDataRow){
        TTFormTestData testData = new TTFormTestData();
        for(int j=1 ; j<testDataRow.getLastCellNum(); j++){
            switch(header.getCell(j).getStringCellValue()){
                case "firstName":
                    testData.setFirstname(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "lastName":
                    testData.setLastName(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "email":
                    testData.setEmail(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "gender":
                    testData.setGender(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "mobileNumber":
                    testData.setMobileNum(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "dob":
                    testData.setDob(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "hobbies":
                    testData.setHobbies(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "location":
                    testData.setLocation(testDataRow.getCell(j).getStringCellValue());
                    break;
                case "address":
                    testData.setAddress(testDataRow.getCell(j).getStringCellValue());
                    break;
            }
        }
        return testData;
    }
}
