package principal;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Leitura_JSON {
	
	
	public static void lerJSON() throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();

		//Acessando o arquivo dentro do projeto
		Object obj = parser.parse(new FileReader("C://Users//yury4//eclipse-workspace//Projeto Final//Projeto-POO//ficha.json"));
		//System.out.println(obj);
		
		//Validando o acesso
		System.out.println("Conseguimos acessar o arquivo base.");
		
		JSONArray jarray = new JSONArray(obj.toString());
		//Object jacare = jarray.get(0);
		Object jacare;
		//System.out.println(jacare.getClass());
		//System.out.println(jacare);
		//jacare é um JSONObject!!
		//JSONObject jacare2 = new JSONObject(jacare.toString());
		//System.out.println(jacare2.getString("conceito"));

	    //implementar um arraylist de String aqui
	    ArrayList<Object> materias = new ArrayList<Object>();
		
				
		for (int i = 0; i < jarray.length(); i++) {
			jacare = jarray.get(i);
			materias.add(jacare);
		}
		System.out.println("Criamos o vetor");
		
		for (int i = 0; i < jarray.length(); i++) {
			System.out.println(materias.get(i));
		}

	}
	
}
