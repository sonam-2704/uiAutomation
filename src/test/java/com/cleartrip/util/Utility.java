/**
 * 
 */
package com.cleartrip.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.Scenario;

/**
 * @author Sonam_Mittal
 *
 */
public class Utility {

	public static final String EXCELFILELOCATION = "./src/test/resources/testdata/TestData.xlsx";
	private static FileInputStream fis;
	private static XSSFSheet sheet;
	private static XSSFWorkbook workbook;
	private static XSSFRow row;
	private static XSSFCell cell;

	Properties prop = null;

	public Properties getProperties(){

		if(prop==null){

			prop = new Properties();
			FileInputStream fin = null;
			try {
				//System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
				fin = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\cleartrip\\config\\config.properties"));
				prop.load(fin);
				fin.close();
				return prop;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return prop;
	}

	public static void loadExcel(String sheetName){

		File file = new File(EXCELFILELOCATION);
		//System.out.println("EXCELFILELOCATION : "+EXCELFILELOCATION);
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheet(sheetName);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Map<String,Map<String,String>> getDataMap(String sheetName){

		if(sheet==null){

			loadExcel(sheetName);
		}

		Map<String,String> myMap = new HashMap<String,String>();
		Map<String,Map<String,String>> superMap = new HashMap<String,Map<String,String>>();


		for(int i=1;i<sheet.getLastRowNum()+1;i++){

			row = sheet.getRow(i);
			String keyCell = row.getCell(0).getStringCellValue();
			int colNum = row.getLastCellNum();

			for(int j=1;j<colNum;j++){

				XSSFCell cell =  row.getCell(j);
				
				if(cell.getCellType()== XSSFCell.CELL_TYPE_STRING){
					
					String value = row.getCell(j).getStringCellValue();
					myMap.put(keyCell, value);
				}
				
				else if(cell.getCellType()== XSSFCell.CELL_TYPE_NUMERIC){
					
					int val = (int) row.getCell(j).getNumericCellValue();
					
					myMap.put(keyCell, String.valueOf(val));
				}
			}

			superMap.put(sheetName, myMap);

		}
		return superMap;
	}

	public static String getValue(String sheetName,String key){

		Map<String,String> myVal = getDataMap(sheetName).get(sheetName);

		String retValue = myVal.get(key);

		return retValue;

	}

	public static String getValueFromExcel(Scenario scenario, String key){
		
		String value = "";
		
		if(scenario.getName().contains("One-way")){

			value = Utility.getValue("One-way",key);
			System.out.println("value from Excel : "+value);
		}
		else if(scenario.getName().contains("Round-trip")){
			
			value = Utility.getValue("Round-trip",key);
			System.out.println("value from Excel : "+value);
		}

		return value;
	}

	/*public static void main(String args[]){

		//getProperties();
		System.out.println(getValue("One-way","From"));
		System.out.println(getValue("One-way","To"));
		
	}*/
}
