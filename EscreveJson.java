package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJson {

	public static void main(String[] args) throws IOException {
		
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("00000000");
		usuario1.setLogin("joao.victor");
		usuario1.setSenha("123");
		usuario1.setNome("João Victor");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("111111111");
		usuario2.setLogin("eduardo.victor");
		usuario2.setSenha("123");
		usuario2.setNome("Eduardo Victor");
		
		
		Usuario usuario3 = new Usuario();
		usuario3.setCpf("111111111");
		usuario3.setLogin("lucas.pereira");
		usuario3.setSenha("123");
		usuario3.setNome("Lucas Santos Pereira");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWrite = new FileWriter("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\filjson.json");
		
		fileWrite.write(jsonUser);
		fileWrite.flush();
		fileWrite.close();
		
		/*Lendo o arquivo JSON*/
		
		FileReader fileReader = new FileReader("C:\\Users\\Lucas\\eclipse-workspace\\arquivos\\src\\arquivos\\filjson.json");
		
		JsonArray jsonArray =(JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listaUsuario.add(usuario);
			
		}
		System.out.println("Leitura do arquivo Json " + listaUsuario.toString());
	}

}
