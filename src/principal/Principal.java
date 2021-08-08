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
		
		Aluno aluno = LeituraTextDocument.lerTexto("infoAluno.txt");
		//Aluno aluno = new Aluno("Yury", "11201720122", "Ciência da computação");
		
		if(aluno.getGraduacao().equals("BCT")) {
			Leitura_JSON.lerJSON(aluno);
			BCT bct = new BCT(aluno);
			CalculosAluno.calculaCoeficientes(aluno, bct);
			CriaPlanilhaSaida.criarPlanilha(aluno, bct);
		} else if (aluno.getGraduacao().equals("BCH")) {
			Leitura_JSON.lerJSON(aluno);
			BCH bch = new BCH(aluno);
			CalculosAluno.calculaCoeficientes(aluno, bch);
			CriaPlanilhaSaida.criarPlanilha(aluno, bch);
		}
		/*Leitura_JSON.lerJSON(aluno);
		BCT bct = new BCT(aluno);
		CalculosAluno.calculaCoeficientes(aluno, bct);
		CriaPlanilhaSaida.criarPlanilha(aluno, bct);*/
	}
		
}
