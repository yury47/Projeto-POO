package principal;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Aluno.Aluno;
import Graduacao.Disciplina;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Leitura_JSON {
	
	
	public static void lerJSON(Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser(); 

		//Corrigir a pasta de acesso do arquivo
		Object obj = parser.parse(new FileReader("C://Users//yury4//eclipse-workspace//Projeto Final//Projeto-POO//ficha.json"));
		
		JSONArray jarray = new JSONArray(obj.toString());
	    
		ArrayList<Disciplina> materias = new ArrayList<Disciplina>();
		
	    for (int i = 0; i < jarray.length(); i++) {
	    	
	    	JSONObject materia = jarray.getJSONObject(i);
	    	
	    	String disciplina = materia.getString("disciplina");
	    	String creditos = Integer.toString(materia.getInt("creditos"));
	    	String periodo = materia.getString("periodo");
	    	String situacao = materia.getString("situacao");
	    	String ano = Integer.toString(materia.getInt("ano"));
	    	String codigo = materia.getString("codigo");
	    	String categoria = materia.getString("categoria");
	    	String conceito = materia.getString("conceito");
	    		    	
	    	Disciplina novaMateria = new Disciplina(disciplina, creditos, periodo, situacao, ano, codigo, categoria, conceito);
	    	materias.add(novaMateria);
	    	
	    }
	    aluno.setMaterias_cursadas(materias);
	    
	}
	
}
