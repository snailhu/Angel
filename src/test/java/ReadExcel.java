import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * ����poi��ȡexcel�ļ�����
 * @author lihui
 *
 */
public class ReadExcel {

        /**
         * @param args
         */
        public static void main(String[] args){

                HSSFWorkbook wb = null;
                POIFSFileSystem fs = null;
                try {
                        //����Ҫ��ȡ���ļ�·��
                        fs = new POIFSFileSystem(new FileInputStream("F:/myeclipse2015/project/Angel/src/test/java/1.xls"));
                        //HSSFWorkbook�൱��һ��excel�ļ���HSSFWorkbook�ǽ���excel2007֮ǰ�İ汾��xls��
                        //֮��汾ʹ��XSSFWorkbook��xlsx��
                        wb = new HSSFWorkbook(fs);
                        //���sheet������
                        HSSFSheet sheet = wb.getSheetAt(0);
                        //�����
                        HSSFRow row = sheet.getRow(3);
                        //������е��У�����Ԫ��
                        HSSFCell cell = row.getCell(0);
                        //��õ�Ԫ���е�ֵ������õ�Ԫ���ֵΪ���֣�����ʹ��getNumericCellValue����Ϊ�ַ�����ᱨ��
                        //���ȡ���ֵ����print2����
                        double msg = cell.getNumericCellValue();
                        System.out.println(msg);
                        print1();
                        print2();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public static void print1() throws Exception {
                InputStream is = new FileInputStream("F:/myeclipse2015/project/Angel/src/test/java/1.xls");
                HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(is));
                //A text extractor for Excel files.
                //Returns the textual content of the file, suitable for indexing by something like Lucene,
                //but not really intended for display to the user.
                //�����������excel�ļ������ݣ���ʾΪ�ַ���
                ExcelExtractor extractor = new ExcelExtractor(wb);
                //�ַ��������������ͣ����api
                extractor.setIncludeSheetNames(true);
                extractor.setFormulasNotResults(false);
                extractor.setIncludeCellComments(true);
                //����ַ�����ʽ
                String text = extractor.getText();
                System.out.println(text);
        }

        public static void print2() throws Exception {
                HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(
                                "F:/myeclipse2015/project/Angel/src/test/java/1.xls"));
                HSSFSheet sheet = wb.getSheetAt(0);
                //������
                for (Iterator<Row> iter = (Iterator<Row>) sheet.rowIterator(); iter
                                .hasNext();) {
                        Row row = iter.next();
                        //������
                        for (Iterator<Cell> iter2 = (Iterator<Cell>) row.cellIterator(); iter2
                                        .hasNext();) {
                                Cell cell = iter2.next();
                                //���ڲ��Ե��ļ���2�У���һ��Ϊ���֣��ڶ���Ϊ�ַ���
                                //��������cell.getCellType��ֵΪHSSFCell.CELL_TYPE_NUMERIC��Ϊ0
                                //�����ַ���cell.getCellType��ֵΪHSSFCell.CELL_TYPE_STRING��Ϊ1
                                //�����������б���鿴api
                                String content = cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC?cell.getNumericCellValue()+"":cell.getStringCellValue();
                                System.out.println(content);
                        }
                }
        }

}
