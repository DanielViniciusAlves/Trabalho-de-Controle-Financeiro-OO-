package modelo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;

import controle.SaldoDiarioControle;

public class ArmazenaArquivoModelo {
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private SaldoModelo saldo;
	private String filePathMapa;
	private String filePathSaldo;
	
	
	public ArmazenaArquivoModelo(HashMap<LocalDate, SaldoDiarioControle> mapa, String filePathMapa, String filePathSaldo, SaldoModelo saldo) {
		this.mapa = mapa;
		this.saldo = saldo;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo = filePathSaldo;
	}
	
	
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
