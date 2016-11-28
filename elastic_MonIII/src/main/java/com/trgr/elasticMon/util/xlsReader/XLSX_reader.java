package com.trgr.elasticMon.util.xlsReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.trgr.elasticMon.util.fileLoad.FileReader;
import com.trgr.elasticMon.util.fileLoad.FileReaderBase;
import com.trgr.elasticMon.util.property.Property;

public class XLSX_reader implements XLReaderImpl{
	private FileInputStream fis=null;
	private XSSFWorkbook xsWorkBook;
	private XSSFSheet xsSheet;
	private XSSFRow xsRow;
	private XSSFCell xsCell;
	
	private FileReaderBase fBase;
	
	public XLSX_reader(String fileName){
		fBase=new FileReader();
		File xlFile=fBase.extractFilePath(this, fileName);
		try {
			fis=new FileInputStream(xlFile);
			xsWorkBook=new XSSFWorkbook(fis);
			xsSheet=xsWorkBook.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public boolean isSheetExist(String sheetName){
		int index=xsWorkBook.getSheetIndex(xsSheet);
		if(index==-1){
			index=xsWorkBook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}			
		else
			return true;
	}
	
	public int getRowCount(String sheetName){
		int index=xsWorkBook.getSheetIndex(xsSheet);
		int rowCount=0;
		if(index==-1)
			return 0;
		else{
			xsSheet=xsWorkBook.getSheetAt(index);
			rowCount=xsSheet.getLastRowNum()+1;
		}
		return rowCount;
	}
	
	public int getRowCount(int sheetIndex){
		try{
			if(sheetIndex>xsWorkBook.getNumberOfSheets()-1 || sheetIndex<0)
				return -1;
			else{
				xsSheet=xsWorkBook.getSheetAt(sheetIndex);
				return xsSheet.getLastRowNum()+1;
			}
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getColumnCount(String sheetName){
		int index;
		try{
			if(!isSheetExist(sheetName)){
				return -1;
			}
			index=xsWorkBook.getSheetIndex(sheetName);
			if(index==-1)
				return -1;
			
			xsSheet=xsWorkBook.getSheetAt(index);
			xsRow=xsSheet.getRow(1);
			
			if(xsRow.getLastCellNum()==-1)
				return -1;
			int i;
			for(i=0;i<xsRow.getLastCellNum();i++){
				xsCell=xsRow.getCell(i);
				if(xsCell==null)
					return -1;
			}
			
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public Map<String, Integer> getCelldata(String sheetName, String columnName){
		int col_num=-1;
		Map<String, Integer> colVals=new HashMap<String, Integer>();
		try{
			if(isSheetExist(sheetName)){
				xsSheet=xsWorkBook.getSheet(sheetName);
				xsRow=xsSheet.getRow(0);
			}		
			for(int i=0; i<xsRow.getLastCellNum();i++){
				if(xsRow.getCell(i).getStringCellValue().equals(columnName)){
					col_num=i;
					break;
				}
			}
			
			for(int i=1;i<xsSheet.getLastRowNum();i++){
				xsRow=xsSheet.getRow(i);
				xsCell=xsRow.getCell(col_num);
				colVals.put(xsCell.getStringCellValue(), i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return colVals;	
	}
	
	public boolean getSkipMode(Object obj){
		Map<String, String> colVals=new HashMap<String, String>();
		try{
			xsSheet=xsWorkBook.getSheetAt(0);
			
			for(int i=1;i<xsSheet.getLastRowNum();i++){
				xsRow=xsSheet.getRow(i);
				for(int j=0;j<xsRow.getLastCellNum();j++){
					colVals.put(xsRow.getCell(0).getStringCellValue(), xsRow.getCell(2).getStringCellValue());
				}
			}
			
			if(colVals.containsKey(obj.getClass().getName()))
				return colVals.get(obj.getClass().getName())=="Y";
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Map<Integer, List<Integer>> getTestCaseRows(String testCaseName){
		Map<Integer, List<Integer>> sheetList=new HashMap<Integer, List<Integer>>();
        xsWorkBook.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
        int sheets=xsWorkBook.getNumberOfSheets();
        for(int i=1; i<sheets;i++){
             List<Integer> rowList=new ArrayList<Integer>();
            xsSheet=xsWorkBook.getSheetAt(i);
            for(int j=xsSheet.getFirstRowNum();j<=xsSheet.getLastRowNum();j++){
                xsRow=xsSheet.getRow(j);
                if(xsRow==null){
                    xsSheet.shiftRows(j+1, xsSheet.getLastRowNum(), -1);
                    j--;
                    continue;
                }
                if(xsRow.getCell(0).getStringCellValue().equals(testCaseName)){
                    rowList.add(j);
                }
            }
            if(rowList.size()>0)
            sheetList.put(i, rowList);
            //rowList.clear();
        }
        return sheetList;
	}
	
	public Object[][] getTestData(String testCaseName){
        Map<Integer, List<Integer>> sheetList=getTestCaseRows(testCaseName);
        String val=null;
        int countX=0;
        int countY=0;
        for(Integer i: sheetList.keySet()){
        	countX=countX+sheetList.get(i).size();
        }
        Object[][] data=new Object[countX][];
        for(Integer i: sheetList.keySet()){
               xsSheet=xsWorkBook.getSheetAt(i);
               for(Integer j:sheetList.get(i)){
            	   List<String> cellVal=new ArrayList<String>();
                   xsRow=xsSheet.getRow(j);
                   for(int k=xsRow.getFirstCellNum()+2;k<xsRow.getLastCellNum();k++){
                	   val=xsRow.getCell(k, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
                	   if(!(val.equals("")))
                		   cellVal.add(val);
                   }
                   data[countY]=new Object[cellVal.size()];
                   cellVal.toArray(data[countY]);                   
                   countY++;
               }
        }
        return data;
	}	
}
