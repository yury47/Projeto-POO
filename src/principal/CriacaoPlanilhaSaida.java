package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CriacaoPlanilhaSaida {

	public static void criarPlanilhaPersonalizada() throws IOException {
	
		//Criando o arquivo vazio
		//XSSFWorkbook arquivo = new XSSFWorkbook();
		HSSFWorkbook arquivo = new HSSFWorkbook();
		
		//Criando o arquivo de saída
		OutputStream arquivoSaida = new FileOutputStream("Planilha Teste.xls");
				
		//Criando uma aba (ou planilha) no arquivo
		//XSSFSheet aba = arquivo.createSheet("Informações do aluno");
		Sheet aba = arquivo.createSheet("Informações do aluno");
		
		//Criando uma linha em uma posição específica
		Row linha = aba.createRow(1);
		
		//Criando uma célula em posição específica
		Cell celula = linha.createCell(1);
		
		//Adicionando valor na célula
		celula.setCellValue("Jacaré");
		
		//Escrevendo o conteúdo do arquivo de saída no arquivo principal
		arquivo.write(arquivoSaida);
		
		System.out.println("Célula criada na posição 1, 1");

	}

}

