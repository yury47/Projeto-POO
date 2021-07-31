package Aluno;

import Graduacao.BCT;

public class CalculosAluno {
	
	public static void calculaCoeficientes(Aluno aluno, BCT bct) {
		calculaCr(aluno);
		calculaCa(aluno);
		calculaLimitadas(aluno);
		calculaLivres(aluno);
		calculaPercentuais(aluno, bct);
	}
	
	public static void calculaPercentuais(Aluno aluno, BCT bct) {
		aluno.setPercentual_obrigatoria(aluno.getObrigatorias()/bct.getCreditos_obrigatorios());// colocar na materias a fazer
		aluno.setLimitadass(aluno.getLimitadas()/bct.getCreditos_limitados());
		aluno.setPercentual_livre(aluno.getLivres()/bct.getCreditos_livres());
	}
	
	public static void calculaCr(Aluno aluno) {  // recebe dois vetores, um com os creditos e um com os conceitos
		float cr = 0;
		float soma_creditos = 0, soma_produtos = 0;
		
		
		for (int i=0; i<aluno.getMaterias_cursadas().size(); i++) {
			if(!(aluno.getMaterias_cursadas().get(i).getNome().equals("TRANCAMENTO TOTAL"))) { // considerando trancamento de disciplinas
				float creditos = Float.parseFloat(aluno.getMaterias_cursadas().get(i).getCreditos());
				
				switch(aluno.getMaterias_cursadas().get(i).getConceito()) {
					case "A":
						soma_produtos += 4*creditos;
						soma_creditos += creditos;
						break;
					case "B":
						soma_produtos += 3*creditos;
						soma_creditos += creditos;
						break;
					case "C":
						soma_produtos += 2*creditos;
						soma_creditos += creditos;
						break;
					case "D":
						soma_produtos += 1*creditos;
						soma_creditos += creditos;
						break;
					case "E":
						break;
					case "F":
						soma_creditos += creditos;
						break;
					case "O":
						soma_creditos += creditos;
						break;
				}
			}
		}
		
		cr = soma_produtos/soma_creditos;
		aluno.setCr(cr);
	}
	
	public static void calculaCa(Aluno aluno) {
		float ca = 0;
		float soma_creditos = 0, soma_produtos = 0;
		
		
		for (int i=0; i<aluno.getMaterias_cursadas().size(); i++) {
			
			if(aluno.getMaterias_cursadas().get(i).getMaiornota()) {
				float creditos = Float.parseFloat(aluno.getMaterias_cursadas().get(i).getCreditos());
				
				
				switch(aluno.getMaterias_cursadas().get(i).getConceito()) {
					case "A":
						soma_produtos += 4*creditos;
						soma_creditos += creditos;
						break;
					case "B":
						soma_produtos += 3*creditos;
						soma_creditos += creditos;
						break;
					case "C":
						soma_produtos += 2*creditos;
						soma_creditos += creditos;
						break;
					case "D":
						soma_produtos += 1*creditos;
						soma_creditos += creditos;
						break;
					case "E":
						break;
					case "F":
						soma_creditos += creditos;
						break;
					case "O":
						soma_creditos += creditos;
						break;
				}
			}
					
		}
		
		ca = soma_produtos/soma_creditos;
		aluno.setCa(ca);
	}
	
	public static int calculaObrigatorias(Aluno aluno) {
		int obrigatorias = 0;
		
		for (int i=0; i<aluno.getMaterias_cursadas().size(); i++) {
			
			if(aluno.getMaterias_cursadas().get(i).getSituacao().equals("Aprovado") && 
					aluno.getMaterias_cursadas().get(i).getCategoria().equals("Obrigatória") &&
					aluno.getMaterias_cursadas().get(i).getMaiornota()) {
				int creditos = Integer.parseInt(aluno.getMaterias_cursadas().get(i).getCreditos());
				obrigatorias += creditos;
			}
					
		}
	System.out.println("Obrigatorias: "+ obrigatorias);
	return obrigatorias;
	}
	
	public static void calculaLimitadas(Aluno aluno) {
		int limitadas = 0;
		
		for (int i=0; i<aluno.getMaterias_cursadas().size(); i++) {
			
			if(aluno.getMaterias_cursadas().get(i).getSituacao().equals("Aprovado") && 
					aluno.getMaterias_cursadas().get(i).getCategoria().equals("Opção Limitada") &&
					aluno.getMaterias_cursadas().get(i).getMaiornota()) {
				int creditos = Integer.parseInt(aluno.getMaterias_cursadas().get(i).getCreditos());
				limitadas += creditos;
			}
					
		}
	System.out.println("Limitadas: "+ limitadas);
	aluno.setLimitadass(limitadas);
	}
	
	public static void calculaLivres(Aluno aluno) {
		int livres = 0;
		
		for (int i=0; i<aluno.getMaterias_cursadas().size(); i++) {
			
			if(aluno.getMaterias_cursadas().get(i).getSituacao().equals("Aprovado") && 
					aluno.getMaterias_cursadas().get(i).getCategoria().equals("Livre Escolha") &&
					aluno.getMaterias_cursadas().get(i).getMaiornota()) {
				int creditos = Integer.parseInt(aluno.getMaterias_cursadas().get(i).getCreditos());
				livres += creditos;
			}
					
		}
	System.out.println("Livres: "+ livres);
	aluno.setLivres(livres);
	}
	
}