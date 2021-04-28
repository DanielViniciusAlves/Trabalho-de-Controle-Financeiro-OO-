package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;

import controle.SaldoDiarioControle;

/**
 * Classe ArmazenaArquivoModelo que pega o arquivo .txt colhe todos os dados e salva em um mapa, em seguida apaga arquivo .txt
 * @author danielalves
 * @version 2.0
 */
public class LeArquivoModelo {
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private String filePathMapa;
	private String filePathSaldo;
	
	/**
	 * Construtor da classe LeArquivoModelo, nao possui logica
	 * @param mapa HashMap com LocalDate, SaldoDiarioControle como key e value
	 * @param filePathMapa endereco de arquivo com mapa
	 * @param filePathSaldo endereco de arquivo com Saldo
	 */
	public LeArquivoModelo(HashMap<LocalDate, SaldoDiarioControle> mapa, String filePathMapa, String filePathSaldo) {
		this.mapa = mapa;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo = filePathSaldo;
	}
	/**
	 * Deleta dados do arquivo para armazenar novos dados
	 * @throws FileNotFoundException
	 */
	private void DeletaArquivoMapa() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(this.filePathMapa);
		writer.print("");
		writer.close();
	}
	
	/**
	 * Deleta dados do arquivo para armazenar novos dados
	 * @throws FileNotFoundException
	 */
	private void DeletaArquivoSaldo() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(this.filePathSaldo);
		writer.print("");
		writer.close();
	}
	
	/**
	 * PreencheMapa vai obter os dados Data, Descricao e Valor em um formato padrao e ira salvar em uma Mapa para a utilizacao no programa
	 * Isso sera feito em um while que tem como condicao a linha lida ser diferente de null
	 * 
	 */
	public HashMap<LocalDate, SaldoDiarioControle> PreencheMapa(SaldoModelo saldo) throws FileNotFoundException{
        BufferedReader br = null;
  
        try {
  
            // cria object de arquivo
            File file = new File(filePathMapa);
  
            // cria BufferedReader object do arquivo
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // le linha por linha
            while ((line = br.readLine()) != null) {
  
                // separa informocoes pelo :
                String[] parts = line.split(":");
  
                // primeira parte sera a data
                String dataArquivo = parts[0].trim();
                LocalDate data = LocalDate.parse(dataArquivo);
                // segunda parte sera a descricao
                String descricao = parts[1].trim();
                // terceira parte sera o valor
                String valorArquivo = parts[2].trim();
                Double valor = Double.parseDouble(valorArquivo); 
  
                // put data, descricao e valor no mapa se nao estiverem vazias
                if (!dataArquivo.equals("") && !descricao.equals("") && !valorArquivo.equals("")) {
                	saldo.AdicionaSaldoDiario(valor, descricao, data);
                }
             
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // Fechando o BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        DeletaArquivoMapa();
        return mapa;
    }
	/**
	 * PreencheSaldo vai obter o SaldoTotal do arquivo .tx e ira salvar em saldo total do programa
	 * 
	 */
	public void PreencheSaldo(SaldoModelo saldo) throws FileNotFoundException{
        BufferedReader br = null;
  
        try {
  
            // cria object de arquivo
            File file = new File(filePathSaldo);
  
            // cria BufferedReader object do arquivo
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // le linha por linha
            while ((line = br.readLine()) != null) {
  
                // separa informocoes pelo :
                String valorArquivo = line;
                Double valor = Double.parseDouble(valorArquivo); 
  
                // put data, descricao e valor no mapa se nao estiverem vazias
                if (!valorArquivo.equals("")) {
                	saldo.SaldoTotal(valor);
                }
             
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // Fechando o BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        DeletaArquivoSaldo();
    }
}
