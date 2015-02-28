package util;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ESI.ESIOperator;


public class ExcelOperator extends ESIOperator{
	//处理XLSX文件
	private static DataFormatter FORMATTER = new DataFormatter();
	public static Workbook load(String path) 
	{
		Workbook workbook = null;
		try {
			InputStream inputstream = new FileInputStream(path);
			if(path.endsWith(".xls"))
			{
				workbook = new HSSFWorkbook(inputstream);
			} else if(path.endsWith(".xlsx"))
			{
				workbook = new XSSFWorkbook(inputstream);
			} else{
				printInfo("不支持的文件格式");
				inputstream.close();
				return null;
			}
			return workbook;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	
	public static Cell SearchValueInSheet(Sheet sheet, String value)
	{
		for (Row row : sheet)
		{
			for (Cell cell : row)
			{
				if (getCellValue(cell).equals(value))
				{
					return cell;
				}
			}
		}
		return null;
	}
	//从开始搜索到指定行与列
	
	public static Cell SearchValueInSheet(Sheet sheet, List<String> list, int RowEnd, int ColEnd)
	{
		//返回搜索到的第一个关键词
		Cell cell = null;
		for (int i = 0; i < list.size();i++)
		{
			cell = SearchValueInSheet(sheet,list.get(i),RowEnd,ColEnd);
			if (cell != null) return cell;
		}
		return null;
	}
	
	public static Cell SearchValueInSheet(Sheet sheet, String value, int RowEnd, int ColEnd)
	{
		for (Row row : sheet)
		{
			
			for (Cell cell : row)
			{
				if (getCellValue(cell).equals(value))
				{
					return cell;
				}
				if (cell.getColumnIndex()>=(ColEnd-1)) break;
			}
			if (row.getRowNum() >= (RowEnd -1))
			{
				return null;
			}
		}
		return null;
	}
	public static String getCellValue(Cell cell) 
	{ 
		return FORMATTER.formatCellValue(cell);
	}
	/* public static Cell SearchValueInSheet(Sheet sheet, String value, int RowEnd, int ColEnd, int RowStart,int ColStart)
	{
		try{
			Row row = null;
			Cell cell = null;
			
			for (int x = RowStart;x < RowEnd  ;x++)
			{
				row = sheet.getRow(x);
				for (int y = ColStart;y < ColEnd  ;y++)
				{
					cell = row.getCell(y);
					if (getCellValue(cell).equals(value))
					{
						return cell;
					}
				}
			}
			return null;
	
		}catch (Exception e)
		{
			printInfo("出现错误：" + e);
			return null;
		}
			
	}*/
}
