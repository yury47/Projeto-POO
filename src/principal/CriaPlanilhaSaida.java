package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.json.simple.parser.ParseException;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.hssf.usermodel.*;

import java.awt.Color;


import Aluno.Aluno;
import Graduacao.BCT;
import Graduacao.CalculosGraduacao;
import Graduacao.Disciplina;
import Graduacao.materiasObrigatorias;


public class CriaPlanilhaSaida {
			
	
	public static void criarPlanilha(Aluno aluno, BCT bct) throws IOException, ParseException {
		//Criando o arquivo vazio
		HSSFWorkbook arquivo = new HSSFWorkbook();
		
		//Criando o arquivo de saída
		OutputStream arquivoSaida = new FileOutputStream("Graduação.xls");
		criarAbaIntroducao(aluno, arquivo);
		criarPlanilhaPersonalizada(aluno,  arquivo);
		criarAbaMateriasRestantes(aluno, bct, arquivo);
		arquivo.write(arquivoSaida);
		arquivo.close();	
	}
	
	public static void criarAbaIntroducao(Aluno aluno, HSSFWorkbook arquivo) throws IOException, ParseException {
		Sheet progresso = arquivo.createSheet("Informações do Aluno(a)");
				
		String indices[] = {"NOME:", "RA:", "CURSO:", "CR:", "CA:", "CRÉDITOS OBRIGATORIAS:", "CRÉDITOS LIMITADAS:", "CRÉDITOS LIVRES:", "PERCENTUAL DE OBRIGATORIAS:", "PERCENTUAL DE LIMITADAS", "PERCENTUAL DE LIVRES"};
		String dados[] = {aluno.getNome(), 	aluno.getRa(), aluno.getGraduacao(), Double.toString(aluno.getCr()), Double.toString(aluno.getCa()), Integer.toString(aluno.getObrigatorias()), Integer.toString(aluno.getLimitadas()), Integer.toString(aluno.getLivres()), Float.toString(aluno.getPercentual_obrigatoria()), Float.toString(aluno.getPercentual_limitada()), Float.toString(aluno.getPercentual_livre())};
		
		for(int i = 0; i < indices.length; i++) {
			Row linha = progresso.createRow(i);
			Row linha2 = progresso.createRow(i);			
			Cell coluna = linha.createCell(0);
			Cell coluna2 = linha2.createCell(1);
			coluna.setCellValue(indices[i]);
			coluna2.setCellValue(dados[i]);
		}	
	}
	
	public static void criarAbaMateriasRestantes(Aluno aluno, BCT bct, HSSFWorkbook arquivo) throws IOException, ParseException {
		ArrayList<materiasObrigatorias> materiasRestantes = CalculosGraduacao.materiasRestantesBCT(aluno, bct);
		
		Sheet progresso = arquivo.createSheet("Matérias Restantes");
		
		Row indice = progresso.createRow(0);
		
		for (int j = 0; j < 6; j ++) {
			Cell celula = indice.createCell(j);
	
			switch(j) {		
			case 0:
				celula.setCellValue("NOME");
				break;
			case 1:
				celula.setCellValue("CODIGO");
				break;
			case 2:
				celula.setCellValue("QUANTIDADE DE CREDITOS");
				break;
			case 3:
				celula.setCellValue("REQUISITO 1");
				break;
			case 4:
				celula.setCellValue("REQUISITO 2");
				break;
			case 5:
				celula.setCellValue("REQUISITO 3");
				break;
			}
			
		}

		for(int i = 0; i < materiasRestantes.size(); i ++) {
			Row linha = progresso.createRow(i+1);
			
			for(int j = 1; j <= 6; j ++) {
				Cell celula = linha.createCell(j-1);
				switch(j) {
				case 1:
					celula.setCellValue(materiasRestantes.get(i).getNome());
					break;
					
				case 2:
					celula.setCellValue(materiasRestantes.get(i).getCodigo());
					break;
					
				case 3:
					celula.setCellValue(materiasRestantes.get(i).getCreditos());
					break;
				
				
				case 4:
					if(materiasRestantes.get(i).getRequisitos().size() > 0) {
						celula.setCellValue(materiasRestantes.get(i).getRequisitos().get(0));
					}
					else {
						celula.setCellValue("N/A");
					}
					break;
					
				case 5:
					if(materiasRestantes.get(i).getRequisitos().size() > 1) {
						celula.setCellValue(materiasRestantes.get(i).getRequisitos().get(1));
					}
					else {
						celula.setCellValue("N/A");
					}
					break;
				
				case 6:
					if(materiasRestantes.get(i).getRequisitos().size() > 2) {
						celula.setCellValue(materiasRestantes.get(i).getRequisitos().get(2));
					}
					else {
						celula.setCellValue("N/A");
					}
					break;
					
				}
			}
		}
	}
	
	public static void criarPlanilhaPersonalizada(Aluno aluno, HSSFWorkbook arquivo) throws IOException, ParseException {
		ArrayList<Disciplina> materias;	
		
		materias = aluno.getMaterias_cursadas();
				
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
		System.out.println("Planilha criada com sucesso!");
	}

}

