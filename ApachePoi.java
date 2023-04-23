package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws IOException {
		
		
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\arquivoExel.xls"));
		
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(entrada);/*Para a entrada do arquivo em Excel para ler*/
		HSSFSheet planilha = hssfworkbook.getSheetAt(0); /*Pega a primeira planilha do arquivo*/
		
		Iterator<Row> linhaInterator = planilha.iterator();
		
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while (linhaInterator.hasNext()) { /*Enquanto tiver linha no arquivo excel*/
			Row linha = linhaInterator.next();/*Dados da linha*/
			Iterator<Cell> celulas = linha.iterator();
			Pessoa pessoa = new Pessoa();
			
			while(celulas.hasNext()) { /*Percorrer as celular*/
				Cell cell = celulas.next();
				switch (cell.getColumnIndex()) {
				 case 0:
					 pessoa.setNome(cell.getStringCellValue());
					 break;
				 case 1:
					 pessoa.setEmail(cell.getStringCellValue());
					 break;
				 case 2:
					 pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					 break;
				}/*Fim das celular da linha*/
								
			}
			pessoas.add(pessoa);
		}
		
		entrada.close();/*Terminou de ler o arquivo em Excel*/
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}
