package Graduacao;

import java.util.ArrayList;

public class BCT extends Graduacao{
	
	private ArrayList<Disciplina> disciplinas;
	
	public BCT (String nome, int obrigatorias, int livres, int limitadas, int reserva){
		super(nome, obrigatorias, livres, limitadas, reserva);
	}

	@Override
	public void setMaterias() {
		// TODO Auto-generated method stub
		
	}
}
