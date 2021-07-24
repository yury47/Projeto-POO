package Aluno;

public class CalculosAluno {
	
	public static float calculaCr(Aluno aluno) {  // recebe dois vetores, um com os creditos e um com os conceitos
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
		return cr;
	}
	
	public static float calculaCa(Aluno aluno) {
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
		return ca;
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
	
	public static int calculaLimitadas(Aluno aluno) {
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
	return limitadas;
	}
	
	public static int calculaLivres(Aluno aluno) {
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
	return livres;
	}
	
}