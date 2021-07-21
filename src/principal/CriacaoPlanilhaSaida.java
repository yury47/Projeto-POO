package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;


public class CriacaoPlanilhaSaida {

	public static void criarPlanilhaPersonalizada() throws IOException, ParseException {
			
		ArrayList<Object> materias;
		
		materias = Leitura_JSON.lerJSON();
		JSONObject descricaoMaterias = new JSONObject (materias.toString());
		
		/*
		for(int i = 0; i < materias.size(); i ++) {
		System.out.println(materias.get(i));
		}*/
		
		//Criando o arquivo vazio
		HSSFWorkbook arquivo = new HSSFWorkbook();
		
		//Criando o arquivo de saída
		OutputStream arquivoSaida = new FileOutputStream("Planilha Teste.xls");
				
		//Criando uma aba (ou planilha) no arquivo
		Sheet progresso = arquivo.createSheet("Progresso da graduação");
		
		for(int i = 0; i < materias.size(); i ++) {
			
			for(int j = 0; j < 8; j ++) {
				Row linha = progresso.createRow(i);
				Cell celula = linha.createCell(j);
				celula.setCellValue(false);
				//tenho de arrumar esse setCellValue aqui pra conseguir pegar o conteúdo certinho de cada parte do arquivo como um todo
			}
		
		}
		
		/*
		//Criando uma linha em uma posição específica
		Row linha = progresso.createRow(0);
		
		//Criando uma célula em posição específica
		Cell celula = linha.createCell(0);
		
		//Adicionando valor na célula
		celula.setCellValue("Jacaré");*/
		
		//Escrevendo o conteúdo do arquivo de saída no arquivo principal
		arquivo.write(arquivoSaida);
		arquivo.close();
		
		System.out.println("Célula criada na posição 1, 1");

	}

}

