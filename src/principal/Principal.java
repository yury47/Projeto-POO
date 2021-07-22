package principal;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import Aluno.Aluno;


public class Principal {

	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		
		//CriaPlanilha.criarPlanilha();
		//Leitura_JSON.lerJSON();
		//CriacaoPlanilhaSaida.criarPlanilhaPersonalizada();
		
		Aluno aluno = new Aluno("Yury", "11201720122", "Ciência da computação");
		Leitura_JSON.lerJSON(aluno);
		CriacaoPlanilhaSaida.criarPlanilhaPersonalizada(aluno);
	}
		
}
