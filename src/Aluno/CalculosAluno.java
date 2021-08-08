package Aluno;

import java.math.BigDecimal;
import java.math.RoundingMode;
import Graduacao.BI;

public class CalculosAluno {
	
	public static void calculaCoeficientes(Aluno aluno, BI bi) {
		calculaCr(aluno);
		calculaCa(aluno);
		calculaObrigatorias(aluno);
		calculaLimitadas(aluno);
		calculaLivres(aluno);
		calculaPercentuais(aluno, bi);
	}
	
	public static void calculaPercentuais(Aluno aluno, BI bi) {
		float totalObrigatorias, obrigatoriasFeitas, percentualObrigatorias;
		float totalLimitadas, limitadasFeitas, percentualLimitadas;
		float totalLivres, livresFeitas, percentualLivres;
		
		obrigatoriasFeitas = aluno.getObrigatorias();
		totalObrigatorias = bi.getCreditos_obrigatorios();
		percentualObrigatorias = (obrigatoriasFeitas/totalObrigatorias)*100;
		BigDecimal bd1 = new BigDecimal(percentualObrigatorias).setScale(1, RoundingMode.HALF_EVEN);
		percentualObrigatorias = bd1.floatValue();
		System.out.println("Percentual obrigatorias: " + percentualObrigatorias);
		
		livresFeitas = aluno.getLivres();
		totalLivres = bi.getCreditos_livres();
		percentualLivres = (livresFeitas/totalLivres)*100;
		BigDecimal bd2 = new BigDecimal(percentualLivres).setScale(1, RoundingMode.HALF_EVEN);
		percentualLivres = bd2.floatValue();
		System.out.println("Percentual livres: " + percentualLivres);
		
		limitadasFeitas = aluno.getLimitadas();
		totalLimitadas = bi.getCreditos_limitados();
		percentualLimitadas = (limitadasFeitas/totalLimitadas)*100;
		BigDecimal bd3 = new BigDecimal(percentualLimitadas).setScale(1, RoundingMode.HALF_EVEN);
		percentualLimitadas = bd3.floatValue();
		System.out.println("Percentual limitadas: "+percentualLimitadas);

		aluno.setPercentual_obrigatoria(percentualObrigatorias);
		aluno.setPercentual_limitada(percentualLimitadas);
		aluno.setPercentual_livre(percentualLivres);
	}
	
	public static void calculaCr(Aluno aluno) {  // recebe dois vetores, um com os creditos e um com os conceitos
		double cr = 0;
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
		BigDecimal bd = new BigDecimal(cr).setScale(3, RoundingMode.HALF_EVEN);
		cr = bd.doubleValue();
		aluno.setCr(cr);
	}
	
	public static void calculaCa(Aluno aluno) {
		double ca = 0;
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
		BigDecimal bd = new BigDecimal(ca).setScale(3, RoundingMode.HALF_EVEN);
		ca = bd.doubleValue();
		aluno.setCa(ca);
	}
	
	public static void calculaObrigatorias(Aluno aluno) {
		int obrigatorias = 0;
		
		for (int i=0; i<aluno.getMaterias_cursadas().size(); i++) {
			
			if(aluno.getMaterias_cursadas().get(i).getSituacao().equals("Aprovado") && 
					aluno.getMaterias_cursadas().get(i).getCategoria().equals("Obrigatória") &&
					aluno.getMaterias_cursadas().get(i).getMaiornota()) {
				int creditos = Integer.parseInt(aluno.getMaterias_cursadas().get(i).getCreditos());
				obrigatorias += creditos;
			}
					
		}
		aluno.setObrigatorias(obrigatorias);
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
		aluno.setLimitadas(limitadas);
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
		aluno.setLivres(livres);
	}
	
}