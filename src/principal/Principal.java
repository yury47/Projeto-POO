package principal;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import Aluno.Aluno;
import Aluno.CalculosAluno;
import Graduacao.BCH;
import Graduacao.BCT;


public class Principal {

	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		
		Aluno aluno = new Aluno("Yury", "11201720122", "Ciência da computação");
		Leitura_JSON.lerJSON(aluno);
		BCT bct = new BCT(aluno);
		CalculosAluno.calculaCoeficientes(aluno, bct);
		CriaPlanilhaSaida.criarPlanilha(aluno, bct);
	}
		
}
