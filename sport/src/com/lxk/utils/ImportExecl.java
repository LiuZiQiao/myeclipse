package com.lxk.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExecl
{
  private int totalRows = 0;
  private int totalCells = 0;
  private String errorInfo;
  
  public int getTotalRows()
  {
    return this.totalRows;
  }
  
  public int getTotalCells()
  {
    return this.totalCells;
  }
  
  public String getErrorInfo()
  {
    return this.errorInfo;
  }
  
  public boolean validateExcel(String filePath, String fileName)
  {
    if ((fileName == null) || ((!WDWUtil.isExcel2003(fileName)) && (!WDWUtil.isExcel2007(fileName))))
    {
      this.errorInfo = "文件名不是excel格式";
      
      return false;
    }
    File file = new File(filePath);
    if ((file == null) || (!file.exists()))
    {
      this.errorInfo = "����������";
      
      return false;
    }
    return true;
  }
  
  /* Error */
  public void read(String filePath, String fileName)
  {
    // Byte code:
    //   0: new 63	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 65	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 66	com/ljj/utils/ImportExecl:validateExcel	(Ljava/lang/String;Ljava/lang/String;)Z
    //   17: ifne +38 -> 55
    //   20: getstatic 68	java/lang/System:out	Ljava/io/PrintStream;
    //   23: aload_0
    //   24: getfield 28	com/ljj/utils/ImportExecl:errorInfo	Ljava/lang/String;
    //   27: invokevirtual 74	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   30: aload 4
    //   32: ifnull +21 -> 53
    //   35: aload 4
    //   37: invokevirtual 79	java/io/InputStream:close	()V
    //   40: goto +13 -> 53
    //   43: astore 8
    //   45: aconst_null
    //   46: astore 4
    //   48: aload 8
    //   50: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   53: aconst_null
    //   54: areturn
    //   55: iconst_1
    //   56: istore 5
    //   58: aload_2
    //   59: invokestatic 38	com/ljj/utils/WDWUtil:isExcel2007	(Ljava/lang/String;)Z
    //   62: ifeq +6 -> 68
    //   65: iconst_0
    //   66: istore 5
    //   68: new 43	java/io/File
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 6
    //   78: new 89	java/io/FileInputStream
    //   81: dup
    //   82: aload 6
    //   84: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: astore 4
    //   89: aload_0
    //   90: aload 4
    //   92: iload 5
    //   94: invokevirtual 94	com/ljj/utils/ImportExecl:read	(Ljava/io/InputStream;Z)Ljava/util/List;
    //   97: astore_3
    //   98: aload 4
    //   100: invokevirtual 79	java/io/InputStream:close	()V
    //   103: goto +64 -> 167
    //   106: astore 5
    //   108: aload 5
    //   110: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   113: aload 4
    //   115: ifnull +75 -> 190
    //   118: aload 4
    //   120: invokevirtual 79	java/io/InputStream:close	()V
    //   123: goto +67 -> 190
    //   126: astore 8
    //   128: aconst_null
    //   129: astore 4
    //   131: aload 8
    //   133: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   136: goto +54 -> 190
    //   139: astore 7
    //   141: aload 4
    //   143: ifnull +21 -> 164
    //   146: aload 4
    //   148: invokevirtual 79	java/io/InputStream:close	()V
    //   151: goto +13 -> 164
    //   154: astore 8
    //   156: aconst_null
    //   157: astore 4
    //   159: aload 8
    //   161: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   164: aload 7
    //   166: athrow
    //   167: aload 4
    //   169: ifnull +21 -> 190
    //   172: aload 4
    //   174: invokevirtual 79	java/io/InputStream:close	()V
    //   177: goto +13 -> 190
    //   180: astore 8
    //   182: aconst_null
    //   183: astore 4
    //   185: aload 8
    //   187: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   190: aload_3
    //   191: areturn
    // Line number table:
    //   Java source line #185	-> byte code offset #0
    //   Java source line #187	-> byte code offset #8
    //   Java source line #194	-> byte code offset #11
    //   Java source line #197	-> byte code offset #20
    //   Java source line #234	-> byte code offset #30
    //   Java source line #240	-> byte code offset #35
    //   Java source line #242	-> byte code offset #40
    //   Java source line #243	-> byte code offset #43
    //   Java source line #246	-> byte code offset #45
    //   Java source line #248	-> byte code offset #48
    //   Java source line #199	-> byte code offset #53
    //   Java source line #205	-> byte code offset #55
    //   Java source line #207	-> byte code offset #58
    //   Java source line #210	-> byte code offset #65
    //   Java source line #216	-> byte code offset #68
    //   Java source line #218	-> byte code offset #78
    //   Java source line #220	-> byte code offset #89
    //   Java source line #222	-> byte code offset #98
    //   Java source line #224	-> byte code offset #103
    //   Java source line #225	-> byte code offset #106
    //   Java source line #228	-> byte code offset #108
    //   Java source line #234	-> byte code offset #113
    //   Java source line #240	-> byte code offset #118
    //   Java source line #242	-> byte code offset #123
    //   Java source line #243	-> byte code offset #126
    //   Java source line #246	-> byte code offset #128
    //   Java source line #248	-> byte code offset #131
    //   Java source line #232	-> byte code offset #139
    //   Java source line #234	-> byte code offset #141
    //   Java source line #240	-> byte code offset #146
    //   Java source line #242	-> byte code offset #151
    //   Java source line #243	-> byte code offset #154
    //   Java source line #246	-> byte code offset #156
    //   Java source line #248	-> byte code offset #159
    //   Java source line #254	-> byte code offset #164
    //   Java source line #234	-> byte code offset #167
    //   Java source line #240	-> byte code offset #172
    //   Java source line #242	-> byte code offset #177
    //   Java source line #243	-> byte code offset #180
    //   Java source line #246	-> byte code offset #182
    //   Java source line #248	-> byte code offset #185
    //   Java source line #258	-> byte code offset #190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	ImportExecl
    //   0	192	1	filePath	String
    //   0	192	2	fileName	String
    //   7	184	3	dataLst	List<List<String>>
    //   9	175	4	is	InputStream
    //   56	37	5	isExcel2003	boolean
    //   106	3	5	ex	Exception
    //   76	7	6	file	File
    //   139	26	7	localObject	Object
    //   43	6	8	e	IOException
    //   126	6	8	e	IOException
    //   154	6	8	e	IOException
    //   180	6	8	e	IOException
    // Exception table:
    //   from	to	target	type
    //   35	40	43	java/io/IOException
    //   11	30	106	java/lang/Exception
    //   55	103	106	java/lang/Exception
    //   118	123	126	java/io/IOException
    //   11	30	139	finally
    //   55	113	139	finally
    //   146	151	154	java/io/IOException
    //   172	177	180	java/io/IOException
  }
  
  public List<List<String>> read(InputStream inputStream, boolean isExcel2003)
  {
    List<List<String>> dataLst = null;
    try
    {
      Workbook wb = null;
      if (isExcel2003) {
        wb = new HSSFWorkbook(inputStream);
      } else {
        wb = new XSSFWorkbook(inputStream);
      }
      dataLst = read(wb);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return dataLst;
  }
  
  private List<List<String>> read(Workbook wb)
  {
    List<List<String>> dataLst = new ArrayList();
    
    Sheet sheet = wb.getSheetAt(0);
    
    this.totalRows = sheet.getPhysicalNumberOfRows();
    if ((this.totalRows >= 1) && (sheet.getRow(0) != null))
    {
      int cols = sheet.getRow(0).getPhysicalNumberOfCells();
      while ("" == sheet.getRow(0).getCell(cols - 1).getStringCellValue()) {
        cols--;
      }
      this.totalCells = cols;
    }
    for (int r = 0; r < this.totalRows; r++)
    {
      Row row = sheet.getRow(r);
      if (row != null)
      {
        List<String> rowLst = new ArrayList();
        for (int c = 0; c < getTotalCells(); c++)
        {
          Cell cell = row.getCell(c);
          
          String cellValue = "";
          if (cell != null) {
            switch (cell.getCellType())
            {
//            case 0: 
//              cellValue = cell.getNumericCellValue();
//              break;
            case 1: 
              cellValue = cell.getStringCellValue();
              break;
//            case 4: 
//              cellValue = cell.getBooleanCellValue();
//              break;
            case 2: 
              cellValue = cell.getCellFormula();
              break;
            case 3: 
              cellValue = "";
              break;
            case 5: 
              cellValue = "非法字符";
              break;
            default: 
              cellValue = "未知字型";
            }
          }
          rowLst.add(cellValue);
        }
        dataLst.add(rowLst);
      }
    }
    return dataLst;
  }
}
