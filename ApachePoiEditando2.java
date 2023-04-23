package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando2 {
	
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\arquivoExel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfworkbook.getSheetAt(0);
		
		Iterator<Row> linhaInterator = planilha.iterator();
		
		while (linhaInterator.hasNext()) {
			Row linha = linhaInterator.next();
			
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + " Editado");
			
		}
		
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		
		hssfworkbook.write(saida);
		saida.flush();
		saida.close();
		System.out.println("Planilha atualizada");
		
		
	}
}
