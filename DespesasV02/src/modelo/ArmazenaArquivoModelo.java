package modelo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;

import controle.SaldoDiarioControle;

/**
 * Classe ArmazenaArquivoModelo que pega o mapa com todos os dados e imprime em um arquivo .txt para serem salvos.
 * @author danielalves
 * @version 2.0
 */
public class ArmazenaArquivoModelo {
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private SaldoModelo saldo;
	private String filePathMapa;
	private String filePathSaldo;
	
	/**
	 * Construtor da classe ArmazenaArquivoModelo, nao possui logica
	 * @param mapa HashMap com LocalDate, SaldoDiarioControle como key e value
	 * @param filePathMapa endereco de arquivo com mapa
	 * @param filePathSaldo endereco de arquivo com Saldo
	 * @param saldo classe SaldoModelo
	 */
	public ArmazenaArquivoModelo(HashMap<LocalDate, SaldoDiarioControle> mapa, String filePathMapa, String filePathSaldo, SaldoModelo saldo) {
		this.mapa = mapa;
		this.saldo = saldo;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo = filePathSaldo;
	}
	
	/**
	 * ImprimeMapa vai obter os dados do HashMap mapa e imprimir em um arquivo .txt realizando um loop de duas etapas:
	 * (1)Loop vai passar por todas as keys que sao iguais a data
	 * (2)Loop vai passar por todas as keys que sao iguais a descricao e vai e vai imprimir no arquivo .txt
	 */
	public void ImprimeMapa()
    { 
		HashMap<String, Double> historico = new HashMap<String, Double>();
		// cria object de arquivo
        File file = new File(filePathMapa);

        BufferedWriter bf = null;
  
        try {
  
            // cria BufferedReader object do arquivo de saida
            bf = new BufferedWriter(new FileWriter(file));
  
            // loop para obter a key
            for (Entry<LocalDate, SaldoDiarioControle> entry : mapa.entrySet()) {
            	//inicializando constror de classe
            	SaldoDiarioControle saldodiario = mapa.get(entry.getKey());
            	historico = saldodiario.getHistorico();	
            	LocalDate data = entry.getKey();
            	//loop para escrever data, descricao e valor
            	for (Entry<String, Double> entry2 : historico.entrySet()) {
            		bf.write(data + ":" + entry2.getKey() + ":" + entry2.getValue());
            		// pula para nova linha
                    bf.newLine();
            	}
            }
  
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
  
                // fecha o writter
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }
	
	/**
	 * ImprimeSaldo vai obter o SaldoTotal do programa e ira imprimir em uma unica linha em um arquivo .txt
	 * 
	 */
	public void ImprimeSaldo()
    { 
		
		// cria object de arquivo
        File file = new File(filePathSaldo);

        BufferedWriter bf = null;
		try {
			  
            // cria BufferedReader object do arquivo de saida
            bf = new BufferedWriter(new FileWriter(file));         
    		bf.write(saldo.getSaldoControle().getTotal().toString());
    		// pula para nova linha
            bf.newLine();            	           
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
  
                // fecha o writter
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }
}
