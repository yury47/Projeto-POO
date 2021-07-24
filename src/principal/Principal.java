package principal;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import Aluno.Aluno;
import Aluno.CalculosAluno;


public class Principal {

	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		
		Aluno aluno = new Aluno("Yury", "11201720122", "Ciência da computação");
		Leitura_JSON.lerJSON(aluno);
		aluno.setCr(CalculosAluno.calculaCr(aluno));
		aluno.setCa(CalculosAluno.calculaCa(aluno));
		System.out.println("CR: " + aluno.getCr());
		System.out.println("CA: " + aluno.getCa());
		CalculosAluno.calculaObrigatorias(aluno);
		CalculosAluno.calculaLimitadas(aluno);
		CalculosAluno.calculaLivres(aluno);
		//CriaPlanilhaSaida.criarPlanilhaPersonalizada(aluno);
		
	}
		
}
