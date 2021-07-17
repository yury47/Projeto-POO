package Graduacao;

public class Disciplina {
	private String nome;
	private int creditos;
	private int periodo;
	private String situacao;
	private int ano;
	private String codigo;
	private String categoria;
	private String conceito;
	
	public Disciplina(String nome, int creditos, int periodo, String situacao, int ano, String codigo, String categoria, String conceito) {
		this.nome = nome;
		this.creditos = creditos;
		this.periodo = periodo;
		this.situacao = situacao;
		this.ano = ano;
		this.codigo = codigo;
		this.categoria = categoria;
		this.conceito = conceito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	
	
}
