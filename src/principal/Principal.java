package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import Aluno.Aluno;
import Aluno.CalculosAluno;
import Graduacao.BI;


public class Principal {

	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		
		Aluno aluno = LeituraTextDocument.lerTexto("infoAluno.txt");
		BI bi = new BI(aluno, "n/a", 0, 0, 0, 0);
		
		if(aluno.getGraduacao().equals("BCT")) {
			bi = new BI(aluno, "BCT", 90, 40, 72, 150);
		} else if (aluno.getGraduacao().equals("BCH")) {
			bi = new BI(aluno, "BCH", 72, 43, 68, 200);
		}
		
		Leitura_JSON.lerJSON(aluno);
		CalculosAluno.calculaCoeficientes(aluno, bi);
		CriaPlanilhaSaida.criarPlanilha(aluno, bi);
	}
		
}
