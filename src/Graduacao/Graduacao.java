package Graduacao;


public abstract class Graduacao {
	private String nome;
	private int creditos_obrigatorios;
	private int creditos_livres;
	private int creditos_limitados;
	private int creditos_reserva_vaga;
	
	
	public Graduacao(String nome, int obrigatorias, int livres, int limitadas, int reserva) {
		this.nome = nome;
		this.creditos_obrigatorios = obrigatorias;
		this.creditos_livres = livres;
		this.creditos_limitados = limitadas;
		this.creditos_reserva_vaga = reserva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos_obrigatorios() {
		return creditos_obrigatorios;
	}

	public void setCreditos_obrigatorios(int creditos_obrigatorios) {
		this.creditos_obrigatorios = creditos_obrigatorios;
	}

	public int getCreditos_livres() {
		return creditos_livres;
	}

	public void setCreditos_livres(int creditos_livres) {
		this.creditos_livres = creditos_livres;
	}

	public int getCreditos_limitados() {
		return creditos_limitados;
	}

	public void setCreditos_limitados(int creditos_limitados) {
		this.creditos_limitados = creditos_limitados;
	}

	public int getCreditos_reserva_vaga() {
		return creditos_reserva_vaga;
	}

	public void setCreditos_reserva_vaga(int creditos_reserva_vaga) {
		this.creditos_reserva_vaga = creditos_reserva_vaga;
	}
	
	public abstract void setMaterias(); //definir se vai ser isso mesmo ainda

}
