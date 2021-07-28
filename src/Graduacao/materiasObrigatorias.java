package Graduacao;

import java.util.ArrayList;

public class materiasObrigatorias {
	
	private String nome;
	private String codigo;
	private String creditos;
	private ArrayList<String> requisitos;
	
	public materiasObrigatorias(String nome, String codigo, String creditos, ArrayList<String> requisitos) {
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.requisitos = requisitos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public ArrayList<String> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(ArrayList<String> requisitos) {
		this.requisitos = requisitos;
	}
	
	
	
}
