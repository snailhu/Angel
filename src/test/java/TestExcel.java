import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class TestExcel {

	
	public static void main(String args[]){
		
		Workbook book = null;
		try {
			book = WorkbookFactory.create(new File("F:/myeclipse2015/project/Angel/src/test/java/1.xls"));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet sheet = book.getSheetAt(0);
		Row row1 = sheet.getRow(1);
		int j = row1.getFirstCellNum();
		int m = row1.getLastCellNum();
		int n = sheet.getLastRowNum();
		
		System.out.println(j);
		System.out.println(m);
		System.out.println(sheet.getLastRowNum());
		for(int i=0 ;i<=n;i++){
			Row row = sheet.getRow(i);
			for(int l=0;l<=row.getLastCellNum();l++){
				if (sheet.getRow(i).getCell(l) != null) {
					String ColumnValue = getCellValue(sheet.getRow(i).getCell(l));
					System.out.println(ColumnValue);
				} else {
					System.out.println("没有值");
				}
			}
			
		}

	}
	
	private static String getCellValue(Cell cell) {
		String o = null;
		if (cell.getHyperlink() != null) {
			o = String.valueOf(cell.getHyperlink());
		} else {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				o = "";
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				o = String.valueOf(cell.getBooleanCellValue());
				break;
			// 数值
			case Cell.CELL_TYPE_NUMERIC:
				o = String.valueOf(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				o = String.valueOf(cell.getRichStringCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				o = String.valueOf(cell.getCellFormula());
				break;
			default:
				o = null;
				break;
			}
		}
		return o;
	}
	
}
