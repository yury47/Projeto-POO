package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.json.simple.parser.ParseException;

import Aluno.Aluno;
import Graduacao.Disciplina;


public class CriacaoPlanilhaSaida {

	public static void criarPlanilhaPersonalizada(Aluno aluno) throws IOException, ParseException {
			
		ArrayList<Disciplina> materias;
		
		materias = aluno.getMaterias_cursadas();
		
		//Criando o arquivo vazio
		HSSFWorkbook arquivo = new HSSFWorkbook();
		
		//Criando o arquivo de saída
		OutputStream arquivoSaida = new FileOutputStream("Graduação.xls");
				
		//Criando uma aba (ou planilha) no arquivo
		Sheet progresso = arquivo.createSheet("Progresso da graduação");
		
		Row indice = progresso.createRow(0);
		
		for (int j = 0; j < 8; j ++) {
			
			Cell celula = indice.createCell(j);
			
			switch(j) {
			
			case 0:
				celula.setCellValue("MATÉRIA");
				break;
			case 1:
				celula.setCellValue("CÓDIGO");
				break;
			case 2:
				celula.setCellValue("CRÉDITOS");
				break;
			case 3:
				celula.setCellValue("CONCEITO");
				break;
			case 4:
				celula.setCellValue("SITUAÇÃO");
				break;
			case 5:
				celula.setCellValue("ANO");
				break;
			case 6:
				celula.setCellValue("QUADRIMESTRE");
				break;
			case 7:
				celula.setCellValue("CATEGORIA");
				break;
			}
		}
		
		//Populando a planilha com os valores tirados do arquivo JSON
		for(int i = 0; i < materias.size(); i ++) {
			
			Row linha = progresso.createRow(i+1);
			
			for(int j = 1; j <= 8; j ++) {
				
				Cell celula = linha.createCell(j-1);
				
				switch(j) {
				
				case 1:
					celula.setCellValue(materias.get(i).getNome());
					break;
				case 2:
					celula.setCellValue(materias.get(i).getCodigo());
					break;
				case 3:
					celula.setCellValue(materias.get(i).getCreditos());
					break;
				case 4:
					celula.setCellValue(materias.get(i).getConceito());
					break;
				case 5:
					celula.setCellValue(materias.get(i).getSituacao());
					break;
				case 6:
					celula.setCellValue(materias.get(i).getAno());
					break;
				case 7:
					celula.setCellValue(materias.get(i).getPeriodo()+"º");
					break;
				case 8:
					celula.setCellValue(materias.get(i).getCategoria());
					break;
				}
				//Aprender a editar as células
			}
		
		}
		
		arquivo.write(arquivoSaida);
		arquivo.close();
		
		System.out.println("Planilha criada com sucesso!");

	}

}

