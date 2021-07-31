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


	private ArrayList<materiasObrigatorias> materias = new ArrayList<materiasObrigatorias>();
	
	public BCT (Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		super("BCT", 90, 40, 72, 200);
		this.materias = Leitura_JSON.lerJSONbch(aluno);
	}
	
	
	public ArrayList<materiasObrigatorias> getMaterias(){
		return this.materias;
	}
	
}
