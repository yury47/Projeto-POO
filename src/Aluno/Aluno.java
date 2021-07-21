package Aluno;
import java.util.ArrayList;

import Graduacao.Disciplina;

public class Aluno {
	
	private String nome;
	private String ra;
	private String graduacao;
	private String ano_ingresso;  // format DD-MM-YYYY
	private int periodo_ingresso; // quadrimestre 1,2 ou 3
	private ArrayList<Disciplina> materias_cursadas;  // recebe a materia como parametro no set
	//private ArrayList<String> materias_reprovadas;  // recebe a materia como parametro no set
	private double ca;
	private double cr;
	private double cp;
	
	
	public Aluno(String nome, String ra, String graduacao) {
		this.nome = nome;
		this.ra = ra;
		this.graduacao = graduacao;
	}
		
	
	public String getNome() {
		return this.nome;
	}
	
	
	public String getRa() {
		return this.ra;
	}
	
	
	public String getGraduacao() {
		return this.graduacao;
	}

	
	public String getAno_ingresso() {
		return ano_ingresso;
	}

	public void setAno_intresso(String ano) {
		this.ano_ingresso = ano;
	}

	
	public int getPeriodo_ingresso() {
		return periodo_ingresso;
	}
	
	public void setPeriodo_intresso(int quad) {
		this.periodo_ingresso = quad;
	}
	
	
	public ArrayList<Disciplina> getMaterias_cursadas() {
		return materias_cursadas;
	}

	public void setMaterias_aprovadas(Disciplina materia) {
		this.materias_cursadas.add(materia);
	}
	
	
	
	
	
	public double getCa() {
		return ca;
	}

	public void setCa(double ca) {
		this.ca = ca;
	}
	

	public double getCr() {
		return cr;
	}

	public void setCr(double cr) {
		this.cr = cr;
	}
	
	
	public double getCp() {
		return cp;
	}
	
	public void setCp(double cp) {
		this.cp = cp;
	}


	

	
}
