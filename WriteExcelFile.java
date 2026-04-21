package oop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
		
		Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
		dataSet.put("1", new Object[] {"Id", "Name", "Microsoft"});
		dataSet.put("2", new Object[] {"1", "Michael", "Broadcom"});
		dataSet.put("3", new Object[] {"2", "Jane", "Nvidia"});
		dataSet.put("4", new Object[] {"3", "Phil", "Apple"});
		dataSet.put("5", new Object[] {"4", "Amy", "Google"});
		dataSet.put("6", new Object[] {"5", "Anne", "Meta"});
		
		Set<String> set = dataSet.keySet();
		int rownum = 0;
		for (String key : set) {
			
			XSSFRow row = samplesheet.createRow(rownum++);
			Object[] data = dataSet.get(key);
			
			int cellNum = 0;
			
			for (Object value : data) {
				Cell cell = row.createCell(cellNum++);
				
				if (value instanceof String)
					cell.setCellValue((String) value);
				else if (value instanceof Integer)
					cell.setCellValue((Integer)value);
			}
		}
		
		try {
			FileOutputStream writeFile = new FileOutputStream("sampleTest.xlsx");
			workbook.write(writeFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
