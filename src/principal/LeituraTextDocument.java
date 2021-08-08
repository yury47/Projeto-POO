package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Aluno.Aluno;

public class LeituraTextDocument {
	
	public static Aluno lerTexto(String path) throws IOException{
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha;
		ArrayList<String> info = new ArrayList<String>();
		while(true){
			linha = buffRead.readLine();
			info.add(linha);
			if(linha == null) {
				break;
			}			
		}
		buffRead.close();
				
		String nome = info.get(0);
		String ra = info.get(1);
		String graduacao = info.get(2);
		
		Aluno aluno = new Aluno(nome, ra, graduacao);
		return aluno;
	}
	
}
