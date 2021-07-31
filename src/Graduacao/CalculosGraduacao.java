package Graduacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import Aluno.Aluno;

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
	
	
	public static ArrayList<materiasObrigatorias> materiasRestantesBCT(Aluno aluno, BCT bct) throws FileNotFoundException, IOException, ParseException {		
		ArrayList <Disciplina> materiasFeitas;
		ArrayList<materiasObrigatorias> materias_bct;
		
		materiasFeitas = aluno.getMaterias_cursadas();
		materias_bct = bct.getMaterias();
		
		for(int i = 0; i < materiasFeitas.size(); i ++) {
			
			String codigo_materias_aluno = materiasFeitas.get(i).getCodigo();
			String situacao = materiasFeitas.get(i).getSituacao();
			
			for(int j = 0; j < bct.getMaterias().size(); j++) {
				String codigo_materias_bct = materias_bct.get(j).getCodigo();	
				
				if(codigo_materias_aluno.equals(codigo_materias_bct)) {
					if(situacao.equals("Aprovado")||situacao.equals("Disc.Equiv")){
						System.out.println(materiasFeitas.get(i).getNome());
						System.out.println(materiasFeitas.get(i).getCodigo());
						System.out.println(materiasFeitas.get(i).getSituacao());
						
						materias_bct.remove(j);
					}
				}
			}
		}
		System.out.println("Populamos o vetor de obrigatórias aprovadas");
		return materias_bct;
	}
	
	
	public static ArrayList<materiasObrigatorias> materiasRestantesBCH(Aluno aluno, BCH bch) throws FileNotFoundException, IOException, ParseException {		
		ArrayList <Disciplina> materiasFeitas;
		ArrayList<materiasObrigatorias> materias_bct;
		
		materiasFeitas = aluno.getMaterias_cursadas();
		materias_bct = bch.getMaterias();
		
		for(int i = 0; i < materiasFeitas.size(); i ++) {
			
			String codigo_materias_aluno = materiasFeitas.get(i).getCodigo();
			String situacao = materiasFeitas.get(i).getSituacao();
			
			for(int j = 0; j < bch.getMaterias().size(); j++) {
				String codigo_materias_bct = materias_bct.get(j).getCodigo();	
				
				if(codigo_materias_aluno.equals(codigo_materias_bct)) {
					if(situacao.equals("Aprovado")||situacao.equals("Disc.Equiv")){
						System.out.println(materiasFeitas.get(i).getNome());
						System.out.println(materiasFeitas.get(i).getCodigo());
						System.out.println(materiasFeitas.get(i).getSituacao());
						
						materias_bct.remove(j);
					}
				}
			}
		}
		System.out.println("Populamos o vetor de obrigatórias aprovadas");
		return materias_bct;
	}
	
}
