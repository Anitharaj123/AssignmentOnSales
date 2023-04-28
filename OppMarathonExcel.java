package marathonTestNg;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class OppMarathonExcel {
	public static String[][] readData(String fileName) throws IOException {
		
		XSSFWorkbook wbook=new XSSFWorkbook("./oppcreation/"+fileName+".xlsx");
	XSSFSheet sheetAt=wbook.getSheetAt(0);
	int NumOfRow = sheetAt.getLastRowNum();
	//System.out.println("The  No.of rows are : "+RowNum);
	int NumOfCell = sheetAt.getRow(0).getLastCellNum();
	//System.out.println("The  No.of cells are : "+CellNum);
	//XSSFCell cell=sheetAt.getRow(1).getCell(0);
	//String stringCellValue = cell.getStringCellValue();
	//System.out.println(stringCellValue);
	String[][] data=new String[NumOfRow][NumOfCell];
	for (int i = 1; i <=NumOfRow; i++) {
		XSSFRow row=sheetAt.getRow(i);
		
	for (int j = 0; j <NumOfCell; j++) {
		String fieldData=row.getCell(j).getStringCellValue();
		//System.out.println(fieldData);
		data[i-1][j]=fieldData;
	}
		
	}

	wbook.close();
	return data;


	}


}
