package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTUnderlineImpl;

public class Xwpfchange {

	/**
	 * 用一个docx文档作为模板，然后替换其中的内容，再写入目标文档中。
	 * 
	 * @throws Exception
	 */
	public XWPFDocument testTemplateWrite(String filepath, Map<String, Object> params) throws Exception {
		
		InputStream is = new FileInputStream(filepath);
		XWPFDocument doc = new XWPFDocument(is);
		// 替换段落里面的变量
		this.replaceInPara(doc, params);
		// 替换表格里面的变量
		this.replaceInTable(doc, params);

		this.close(is);

		return doc;// .concat("_提头");
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param doc
	 *            要替换的文档
	 * @param params
	 *            参数
	 */
	private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
		XWPFParagraph para;
		while (iterator.hasNext()) {
			para = iterator.next();
			this.replaceInPara(para, params);
		}

		this.replaceInTable(doc, params);

	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param para
	 *            要替换的段落
	 * @param params
	 *            参数
	 */
	private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
		List<XWPFRun> runs;
		runs = para.getRuns();
		for (int i = 0; i < runs.size(); i++) {
			 XWPFRun pRun = runs.get(i);
			String runText =pRun.toString();
			boolean flag = false;
			
			
			Matcher matcher = matcher(runText);
			
			
			while (matcher.find()) {
				flag = true;
				//即${字段}
				String group = matcher.group();
				System.out.println(group+"*********************************");
				String field = group.substring(2, group.length() - 1);

				field.equals("oad");
				//正则表达式"\\$\\{字段\\}"
				String regex =  "\\$\\{"+field+"\\}";
				//字段所对应的值
				String value = (String) params.get(field);
				System.out.println(group+"+++++++++++++++"+value);
				if (value == null)
					value = "未填写";
				runText = runText.replaceFirst(regex,value);
				
				//加入下划线
				
				CTRPr rPr = null;    
			        if (pRun.getCTR() != null) {    
			        	rPr = pRun.getCTR().getRPr();    
			            if (rPr == null) {    
			            	rPr = pRun.getCTR().addNewRPr();    
			            }    
			        }    
				CTUnderline u = rPr.isSetU() ? rPr.getU() : rPr.addNewU();    
		            u.setVal(STUnderline.Enum.forInt(4));  
				System.out.println(runText+"-----------------------");
			}
			// 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
			// 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
			if(flag){
				para.removeRun(i);
				para.insertNewRun(i).setText(runText);
			}
		}
	}

	/**
	 * 替换表格里面的变量
	 * 
	 * @param doc
	 *            要替换的文档
	 * @param params
	 *            参数
	 */
	private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while (iterator.hasNext()) {
			table = iterator.next();
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					paras = cell.getParagraphs();
					for (XWPFParagraph para : paras) {
						// System.out.print(para.getParagraphText()+"\n");
						this.replaceInPara(para, params);
					}
				}
			}
		}
	}

	/**
	 * 正则匹配字符串
	 * 
	 * @param str
	 * @return
	 */
	private Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		
		
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}

	/**
	 * 关闭输入流
	 * 
	 * @param is
	 */

	private void close(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭输出流
	 * 
	 * @param os
	 */
	private void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	///////////////////////////////////////////
	// System.out.println("输入你的姓名");
	// name = sc.nextLine();
	// System.out.println("选择你的性别 a.男 b.女");
	// sex = sc.nextLine();
	// if(sex.equals("a"))
	// {
	// sex="新生□ 在校生√";
	// }else{
	// sex="新生√ 在校生□";
	// }
	// System.out.println(sex);
	// System.out.println("输入你的身份证号");
	// id = sc.nextLine();
	// birth=id.substring(6, 14);
	// System.out.println("选择你的民族 a.汉族 b.回族");
	// aaa =sc.nextLine();
	// if(aaa.equals("a"))
	// {
	// aaa="汉";
	// }else{
	// aaa="回";
	// }
	// System.out.println(aaa);
}