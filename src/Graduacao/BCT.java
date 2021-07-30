package Graduacao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import principal.Leitura_JSON;

import Aluno.Aluno;

public class BCT extends Graduacao{
	
	static Aluno aluno = new Aluno ("Caio", "1120172551","Ciência da Computação");
	
	public BCT (Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		super("BCT",90,43,57,150);
		lerJSONbct(aluno);
	}
	
	@Override
	public void setMaterias() {
		// TODO Auto-generated method stub
		
	}
	
	static ArrayList<materiasObrigatorias> materias = new ArrayList<materiasObrigatorias>();
	
	public static ArrayList<materiasObrigatorias> lerJSONbct(Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("BCT.json"));
		JSONArray jarray = new JSONArray(obj.toString());
		
		
		
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
	
	public static void comparaMaterias() throws FileNotFoundException, IOException, ParseException {
		
		ArrayList <Disciplina> materiasFeitas;
		ArrayList<materiasObrigatorias> materiasBCT;
		
		materiasFeitas = Leitura_JSON.lerJSON(aluno);
		materiasBCT = lerJSONbct(aluno);
		ArrayList<materiasObrigatorias> obrigatoriasConcluidas = new ArrayList<materiasObrigatorias>();
		
		for(int i = 0; i < materiasFeitas.size(); i ++) {
			
			String codigo1 = materiasFeitas.get(i).getCodigo();
			System.out.println(codigo1);
			String situacao = materiasFeitas.get(i).getSituacao();
			
			for(int j = 0; j < materias.size(); j++) {

				String codigo2 = materiasBCT.get(j).getCodigo();	
				
				if(codigo1.equals(codigo2)) {
					if(situacao.equals("Aprovado")||situacao.equals("Disc.Equiv")){
						System.out.println(materiasFeitas.get(i).getNome());
						System.out.println(materiasFeitas.get(i).getCodigo());
						System.out.println(materiasFeitas.get(i).getSituacao());
						
						obrigatoriasConcluidas.add(materiasBCT.get(j));
					}
				}
			}
		}
		System.out.println("Populamos o vetor de obrigatórias aprovadas");
	}
	
}
