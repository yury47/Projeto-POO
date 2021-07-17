package Aluno;
import java.util.ArrayList;

public class Aluno {
	
	private String nome;
	private String ra;
	private String graduacao;
	private String ano_ingresso;  // format DD-MM-YYYY
	private int periodo_ingresso; // quadrimestre 1,2 ou 3
	private ArrayList<String> materias_concluidas;
	private ArrayList<String> materias_reprovadas;
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
	
	
	public ArrayList<String> getMaterias_aprovadas() {
		return materias_concluidas;
	}

	public void setMaterias_aprovadas(ArrayList<String> materias_concluidas) {
		this.materias_concluidas = materias_concluidas;
	}
	
	
	public ArrayList<String> getMaterias_reprovadas() {
		return materias_reprovadas;
	}

	public void setMaterias_reprovadas(ArrayList<String> materias_reprovadas) {
		this.materias_reprovadas = materias_reprovadas;
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
