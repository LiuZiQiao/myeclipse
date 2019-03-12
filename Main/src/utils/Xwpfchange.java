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
	 * ��һ��docx�ĵ���Ϊģ�壬Ȼ���滻���е����ݣ���д��Ŀ���ĵ��С�
	 * 
	 * @throws Exception
	 */
	public XWPFDocument testTemplateWrite(String filepath, Map<String, Object> params) throws Exception {
		
		InputStream is = new FileInputStream(filepath);
		XWPFDocument doc = new XWPFDocument(is);
		// �滻��������ı���
		this.replaceInPara(doc, params);
		// �滻�������ı���
		this.replaceInTable(doc, params);

		this.close(is);

		return doc;// .concat("_��ͷ");
	}

	/**
	 * �滻��������ı���
	 * 
	 * @param doc
	 *            Ҫ�滻���ĵ�
	 * @param params
	 *            ����
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
	 * �滻��������ı���
	 * 
	 * @param para
	 *            Ҫ�滻�Ķ���
	 * @param params
	 *            ����
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
				//��${�ֶ�}
				String group = matcher.group();
				System.out.println(group+"*********************************");
				String field = group.substring(2, group.length() - 1);

				field.equals("oad");
				//������ʽ"\\$\\{�ֶ�\\}"
				String regex =  "\\$\\{"+field+"\\}";
				//�ֶ�����Ӧ��ֵ
				String value = (String) params.get(field);
				System.out.println(group+"+++++++++++++++"+value);
				if (value == null)
					value = "δ��д";
				runText = runText.replaceFirst(regex,value);
				
				//�����»���
				
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
			// ֱ�ӵ���XWPFRun��setText()���������ı�ʱ���ڵײ�����´���һ��XWPFRun�����ı������ڵ�ǰ�ı����棬
			// �������ǲ���ֱ����ֵ����Ҫ��ɾ����ǰrun,Ȼ�����Լ��ֶ�����һ���µ�run��
			if(flag){
				para.removeRun(i);
				para.insertNewRun(i).setText(runText);
			}
		}
	}

	/**
	 * �滻�������ı���
	 * 
	 * @param doc
	 *            Ҫ�滻���ĵ�
	 * @param params
	 *            ����
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
	 * ����ƥ���ַ���
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
	 * �ر�������
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
	 * �ر������
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
	// System.out.println("�����������");
	// name = sc.nextLine();
	// System.out.println("ѡ������Ա� a.�� b.Ů");
	// sex = sc.nextLine();
	// if(sex.equals("a"))
	// {
	// sex="������ ��У����";
	// }else{
	// sex="������ ��У����";
	// }
	// System.out.println(sex);
	// System.out.println("����������֤��");
	// id = sc.nextLine();
	// birth=id.substring(6, 14);
	// System.out.println("ѡ��������� a.���� b.����");
	// aaa =sc.nextLine();
	// if(aaa.equals("a"))
	// {
	// aaa="��";
	// }else{
	// aaa="��";
	// }
	// System.out.println(aaa);
}