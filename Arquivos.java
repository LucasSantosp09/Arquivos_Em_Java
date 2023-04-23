package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
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
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		//Arquivo TXT
		//File arquivo = new File("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\arquivo.txt");
		
		//ARQUIVO CSV
		File arquivo = new File("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\arquivo2.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		//escrever_no_arquivo.write("Meu Texto do arquivo");
		//escrever_no_arquivo.write("\n");
		//escrever_no_arquivo.write("Minha segunda linha");
		
		
		/*for (int i = 1; i <= 10; i++) {
			escrever_no_arquivo.write("Texto da linha "+ i + "\n");
			
		}*/
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n") ;
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
		
		System.out.println("Funcinou");

	}

}
