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
	
	//private ArrayList<Disciplina> disciplinas;
	
	public BCH (Aluno aluno) throws FileNotFoundException, IOException, ParseException{
		super("BCT",90,43,57,150);
	}

	@Override
	public void setMaterias() {
		// TODO Auto-generated method stub
		
	}

}
