package Aluno;

public class Aluno {
	
	private String nome;
	private String ra;
	private String graduacao;
	
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
	
	
	
}
