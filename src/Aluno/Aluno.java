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
	private double ca;
	private double cr;
	private int obrigatorios_concluidos;
	private int limitados_concluidos;
	private int livres_concluidos;
	
	
	
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
	

	public void setMaterias_cursadas(ArrayList<Disciplina> materias_cursadas) {
		this.materias_cursadas = materias_cursadas;
	}
	
	public ArrayList<Disciplina> getMaterias_cursadas() {
		return materias_cursadas;
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
	

	public int getObrigatorias() {
		return this.obrigatorios_concluidos;
	}
	
	public void setObrigatorias(int obrigatorias) {
		this.obrigatorios_concluidos = obrigatorias;
	}
	
	
	public int getLimitadas() {
		return this.limitados_concluidos;
	}
	
	public void setLimitadass(int limitadas) {
		this.limitados_concluidos = limitadas;
	}
	
	
	public int getLivres() {
		return this.livres_concluidos;
	}
	
	public void setLivres(int livres) {
		this.livres_concluidos = livres;
	}
	
	
}
