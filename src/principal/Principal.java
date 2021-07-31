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
		/*aluno.setCr(CalculosAluno.calculaCr(aluno));
		aluno.setCa(CalculosAluno.calculaCa(aluno));
		System.out.printf("CR: %.3f", aluno.getCr());
		System.out.println();
		System.out.printf("CA: %.3f", aluno.getCa());
		System.out.println();
		CalculosAluno.calculaObrigatorias(aluno);
		CalculosAluno.calculaLimitadas(aluno);
		CalculosAluno.calculaLivres(aluno);*/
		//CriaPlanilhaSaida.criarPlanilhaPersonalizada(aluno);
		//BCT.lerJSONbct(aluno);
		//BCH.lerJSONbch(aluno);
		// comparar materias feitas com as materias obrigatorias e colocar numa aba nova do excel
		
	}
		
}
