package principal;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Tentativa de ler arquivo JSON

public class TesteLeituraJSON {
	
	
	public static void lerJSON() throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();

		//Acessando o arquivo dentro do projeto
		Object obj = parser.parse(new FileReader("C://Users//yury4//eclipse-workspace//Projeto Final//Projeto-POO//ficha.json"));
		//Validando o acesso
		System.out.println("Conseguimos acessar o arquivo base.");

		//Tentativa de conversão objeto para JSON usando API Gson
	    Gson gson = new Gson();    
	    String json = gson.toJson(obj);
	    System.out.println(json);
	    //Conversão com sucesso
		
		//Criação do vetor, separando a String toda pelas chaves
	    String frase = json;
	    System.out.println("Convertemos pra String");
	    //implementar um arraylist de String aqui
	    ArrayList<String> materias = new ArrayList<String>();
	    //String [] separacao = new String[2];
		System.out.println("Estamos aqui");
		int cont = 0;
		
		
		for (int i = 0; i < json.length(); i++) {
			if (json.charAt(i) == '}'){
			cont++;
			}
		}
		System.out.println("Temos "+cont+" materias a processar");
		
		for (int i = 0; i < cont; i++){
		   
		    String [] separacao = frase.split("}");
			System.out.println("Dividindooooo");
			String materia = separacao[i];
			materias.add(materia);
		}
		
		for (int i = 0; i < cont - 1; i++){
			//Ao invés de usar o frase, vai ter de usar cada um dos membros do vetor Materias   
		    String [] separacao = frase.split("{");
			System.out.println("Dividindooooo");
			String materia = separacao[i];
			materias.add(materia);
		}
		
		System.out.println("Criamos o vetor.");
		
		String [] array = new String[materias.size()];
		materias.toArray(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}
	
}
