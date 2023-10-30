package com.org.ttp.utils;

import com.org.ttp.pojo.TTFormTestData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ReadTestData {

    public static final Logger logger = LogManager.getLogger(ReadTestData.class);

    public TTFormTestData readAndSetTestDataInPOJO(){
        logger.info("Class:ReadTestData--Method:readAndSetTestDataInPOJO()--called");
        Row headerRow = null,testDataRow = null;
        try{
            Workbook workbook = new XSSFWorkbook(new FileInputStream(AllConstants.SYSTEM_PATH.getValue()+AllConstants.TESTDATA_FILEPATH.getValue()+AllConstants.TESTDATA_FILENAME.getValue()));
            Sheet sheet = workbook.getSheetAt(0);
             headerRow = sheet.getRow(0);
             testDataRow = sheet.getRow(getTestDataRowID(sheet));

        }catch(Exception e){
            logger.error(e.getMessage());
        }
        logger.info("Class:ReadTestData--Method:readAndSetTestDataInPOJO()--ended");
        assert testDataRow != null;
        return setTestData(headerRow,testDataRow);
    }

    public int getTestDataRowID(Sheet sheet){
        String testCaseId;
        for (int i=0; i<=sheet.getLastRowNum(); i++){
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
                    testData.setFirstname(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "lastName":
                    testData.setLastName(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "email":
                    testData.setEmail(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "gender":
                    testData.setGender(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "mobileNumber":
                    testData.setMobileNum(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "dob":
                    testData.setDob(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "hobbies":
                    testData.setHobbies(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "location":
                    testData.setLocation(setFormattedValues(testDataRow.getCell(j)));
                    break;
                case "address":
                    testData.setAddress(setFormattedValues(testDataRow.getCell(j)));
                    break;
            }
        }
        return testData;
    }

    private String setValues(Cell value){
        if(value != null)
           return value.getStringCellValue();
        else return  "";
    }

    private String setFormattedValues(Cell value){
        DataFormatter dataFormatter = new DataFormatter();
        if(value != null)
            return dataFormatter.formatCellValue(value);
        else return  "";
    }
}
