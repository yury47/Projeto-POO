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
			
			JSONObject materia = jarray.getJSONObject(i);
			
			String nome = materia.getString("nome");
			String codigo = materia.getString("codigo");
			String credito = Integer.toString(materia.getInt("creditos"));
			
			JSONObject obija = new JSONObject
			JSONArray requisitos = new JSONArray(materia.getString("requisitos"));
			for(int j = 0; j < requisitos.length(); j++) {
				String juju = 
			}
			System.out.println(requisitos);
			
			//materiasObrigatorias novaMateria = new materiasObrigatorias(nome, codigo, credito, requisitos);
			//materias.add(novaMateria);
			
		}
		
	}
	
	public static void comparaBCTvsAluno(ArrayList materias) {
		
	}
	
}
