package Graduacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import Aluno.Aluno;

public class CalculosGraduacao {
	
	public static String confereMateria(String codigo, ArrayList<Disciplina> disciplinas) { 

		ArrayList<String> notas = new ArrayList<String>();
	
		
		for(int i = 0; i<disciplinas.size(); i++) {
			if(disciplinas.get(i).getCodigo().equals(codigo)) {
				notas.add(disciplinas.get(i).getConceito());	
			}
		}
		
		
		for (int i = 0; i<notas.size(); i++) {
			if(notas.get(i).equals("A")) {
				return "A";
			}
		}
		
		for (int i = 0; i<notas.size(); i++) {
			if(notas.get(i).equals("B")) {
				return "B";
			}
		}
		
		for (int i = 0; i<notas.size(); i++) {
			if(notas.get(i).equals("C")) {
				return "C";
			}
		}
		
		for (int i = 0; i<notas.size(); i++) {
			if(notas.get(i).equals("D")) {
				return "D";
			}
		}
		
		for (int i = 0; i<notas.size(); i++) {
			if(notas.get(i).equals("F")) {
				return "F";
			}
		}
		
		for (int i = 0; i<notas.size(); i++) {
			if(notas.get(i).equals("O")) {
				return "O";
			}
		}
		
		return null;
		
	}
		
	public static ArrayList<materiasObrigatorias> materiasRestantes(Aluno aluno, BI bi) throws FileNotFoundException, IOException, ParseException {		
		ArrayList <Disciplina> materiasFeitas;
		ArrayList<materiasObrigatorias> materias_bct;
		
		materiasFeitas = aluno.getMaterias_cursadas();
		materias_bct = bi.getMaterias();
		
		for(int i = 0; i < materiasFeitas.size(); i ++) {
			
			String codigo_materias_aluno = materiasFeitas.get(i).getCodigo();
			String situacao = materiasFeitas.get(i).getSituacao();
			
			for(int j = 0; j < bi.getMaterias().size(); j++) {
				
				String codigo_materias_bct = materias_bct.get(j).getCodigo();	
				
				if(codigo_materias_aluno.equals(codigo_materias_bct)) {
					if(situacao.equals("Aprovado")||situacao.equals("Disc.Equiv")){
						materias_bct.remove(j);
					}
				}
			}
		}
		return materias_bct;
	}
}
