package principal;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Aluno.Aluno;
import Graduacao.CalculosGraduacao;
import Graduacao.Disciplina;
import Graduacao.materiasObrigatorias;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Leitura_JSON {
	public static ArrayList<Disciplina> lerJSON(Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser(); 

		//Corrigir a pasta de acesso do arquivo
		Object obj = parser.parse(new FileReader("ficha.json"));
		
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
	    
	    for(int i = 0; i<aluno.getMaterias_cursadas().size(); i++) { // set booleano de maior nota
	    	if(aluno.getMaterias_cursadas().get(i).getConceito()
	    			.equals(CalculosGraduacao.confereMateria(aluno.getMaterias_cursadas().get(i).getCodigo(), aluno.getMaterias_cursadas()))) {
	    		aluno.getMaterias_cursadas().get(i).setMaiornota(true);
	    	}
	    }
		return materias;
	}
	
	public static ArrayList<materiasObrigatorias> lerJSONbct(Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("BCT.json"));
		JSONArray jarray = new JSONArray(obj.toString());
		ArrayList<materiasObrigatorias> materias = new ArrayList<materiasObrigatorias>();
		
		
		for(int i = 0; i < jarray.length(); i++) {
			
			JSONObject materia_obj = jarray.getJSONObject(i);
			String nome = materia_obj.getString("nome");
			String codigo = materia_obj.getString("codigo");
			String credito = Integer.toString(materia_obj.getInt("creditos"));
			
			JSONArray requisitos_array = materia_obj.getJSONArray("requisitos");
			ArrayList<String> requisitos = new ArrayList<String>();
			
			for (int j=0; j < requisitos_array.length(); j++) {	
				
				requisitos.add(requisitos_array.getString(j));
			}
			
			materiasObrigatorias materia = new materiasObrigatorias(nome, codigo, credito, requisitos);
			materias.add(materia);
		}
		return materias;	
	}
	
	public static ArrayList<materiasObrigatorias> lerJSONbch(Aluno aluno) throws FileNotFoundException, IOException, ParseException{
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("BCH.json"));
			JSONArray jarray = new JSONArray(obj.toString());
			ArrayList<materiasObrigatorias> materias = new ArrayList<materiasObrigatorias>();
			
			for(int i = 0; i < jarray.length(); i++) {
				
				JSONObject materia_obj = jarray.getJSONObject(i);
				String nome = materia_obj.getString("nome");
				String codigo = materia_obj.getString("codigo");
				String credito = Integer.toString(materia_obj.getInt("creditos"));
				JSONArray requisitos_array = materia_obj.getJSONArray("requisitos");
				ArrayList<String> requisitos = new ArrayList<String>();
				
				for (int j=0; j < requisitos_array.length(); j++) {	
					
					requisitos.add(requisitos_array.getString(j));
				}
				
				materiasObrigatorias materia = new materiasObrigatorias(nome, codigo, credito, requisitos);
				materias.add(materia);
			}
			return materias;	
		}
}
