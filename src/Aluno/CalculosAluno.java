package Aluno;

import java.util.ArrayList;

public class CalculosAluno {
	
	public double calculaCr(ArrayList<Integer> creditos, ArrayList<String> conceitos) {  // recebe dois vetores, um com os creditos e um com os conceitos
		double cr = 0;
		int soma_creditos = 0, soma_produtos = 0;;
		
		for (int i=0; i<creditos.size(); i++) {
			soma_creditos += creditos.get(i);
			
			switch(conceitos.get(i)) {
				case "A":
					soma_produtos += 4*creditos.get(i);
					break;
				case "B":
					soma_produtos += 3*creditos.get(i);
					break;
				case "C":
					soma_produtos += 2*creditos.get(i);
					break;
				case "D":
					soma_produtos += 1*creditos.get(i);
					break;
				case "F":
					break;
				case "O":
					break;
			}		
		}
		
		cr = soma_produtos/soma_creditos;
		return cr;
	}
}
