package Graduacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import principal.Leitura_JSON;
import Aluno.Aluno;

public class BI extends Graduacao{
	
	private ArrayList<materiasObrigatorias> materias = new ArrayList<materiasObrigatorias>();
	
	public BI (Aluno aluno, String nome, int creditos_obrigatorios, int creditos_limitados, int creditos_livres, int creditos_reserva) throws FileNotFoundException, IOException, ParseException{
		super(nome, creditos_obrigatorios, creditos_livres, creditos_limitados, creditos_reserva);
		System.out.println(nome);
		if(nome.equals("BCT")) {
			this.materias = Leitura_JSON.lerJSONbct(aluno);
		} else if (nome.equals("BCH")) {
			this.materias = Leitura_JSON.lerJSONbch(aluno);
		}
		
	}
	
	
	public ArrayList<materiasObrigatorias> getMaterias(){
		return this.materias;
	}


}
