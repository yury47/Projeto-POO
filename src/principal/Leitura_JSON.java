package principal;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Leitura_JSON {
	
	
	public static ArrayList<Object> lerJSON() throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser(); 

		//Acessando o arquivo dentro do projeto
		Object obj = parser.parse(new FileReader("C://Users//yury4//eclipse-workspace//Projeto Final//Projeto-POO//ficha.json"));
		
		JSONArray jarray = new JSONArray(obj.toString());
		Object conteudo_vetor;

	    //implementar um arraylist de String aqui
	    ArrayList<Object> materias = new ArrayList<Object>();
				
		for (int i = 0; i < jarray.length(); i++) {
			conteudo_vetor = jarray.get(i);
			materias.add(conteudo_vetor);
		}
		
		for(int i = 0; i < jarray.length(); i++) {
			System.out.println(materias.get(i));
		}
		
		return materias;

	}
	
}
