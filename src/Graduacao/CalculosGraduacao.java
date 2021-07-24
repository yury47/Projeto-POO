package Graduacao;

import java.util.ArrayList;

public class CalculosGraduacao {
	
	public static String confereMateria(String codigo, ArrayList<Disciplina> disciplinas) { //confere a maior nota tirada na materia
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
		
		return null;
		
	}
	
}
