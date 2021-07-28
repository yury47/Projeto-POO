package Graduacao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Aluno.Aluno;

public class BCT extends Graduacao{
	
	
	private ArrayList<Disciplina> disciplinas;
	
	public BCT (Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		super("BCT",90,43,57,150);
		lerJSON(aluno);
	}

	@Override
	public void setMaterias() {
		// TODO Auto-generated method stub
		
	}
	
	public static void lerJSON(Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		
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
			
			//System.out.println(nome);
			for (int j=0; j < requisitos_array.length(); j++) {	
				//System.out.println(requisitos_array.getString(j));
				requisitos.add(requisitos_array.getString(j));
			}
			
			materiasObrigatorias materia = new materiasObrigatorias(credito, credito, credito, requisitos);
			materias.add(materia);
		}
		
	}
	
	public static void comparaBCTvsAluno() {
		
	}
	
}
