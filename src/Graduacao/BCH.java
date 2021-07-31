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

public class BCH extends Graduacao{
	
	private ArrayList<materiasObrigatorias> materias = new ArrayList<materiasObrigatorias>();
	
	public BCH (Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		super("BCH", 72, 43, 68, 150);
		this.materias = Leitura_JSON.lerJSONbct(aluno);
	}
	
	
	public ArrayList<materiasObrigatorias> getMaterias(){
		return this.materias;
	}


}
