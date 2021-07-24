package Graduacao;

public class Disciplina {
	private String nome;
	private String creditos;
	private String periodo;
	private String situacao;
	private String ano;
	private String codigo;
	private String categoria;
	private String conceito;
	private boolean maior_nota;
	
	public Disciplina(String nome, String creditos, String periodo, String situacao, String ano, String codigo, String categoria, String conceito) {
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

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
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
	
	public void setMaiornota(boolean bo) {
		maior_nota = bo;
	}
	
	public boolean getMaiornota() {
		return this.maior_nota;
	}
	
	
}
