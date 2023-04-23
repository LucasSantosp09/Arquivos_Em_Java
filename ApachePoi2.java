package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\arquivoExel.xls");
		
		if (file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Lucas");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(40);
		pessoa2.setNome("Luiz");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setNome("João");
		pessoa3.setIdade(70);
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("erick@gmail.com");
		pessoa4.setNome("Erick");
		pessoa4.setIdade(20);
		
List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		HSSFWorkbook hssfworkbook = new HSSFWorkbook();/* Vai ser usado para escrever na planilha */
		HSSFSheet linhasPessoa = hssfworkbook.createSheet("Planilha de pessoas JDEV Treinamento");/* Criar a planilha*/
		
		
		int numeroLinha = 0;
		
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++); /*Criando linha da planilha*/
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++);
			celIdade.setCellValue(p.getIdade());
			
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfworkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
		
	}
}
