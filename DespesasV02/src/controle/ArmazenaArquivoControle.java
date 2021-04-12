package controle;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;

import modelo.SaldoDiarioModelo;

public class ArmazenaArquivoControle {
	private HashMap<LocalDate, SaldoDiarioModelo> mapa;
	private String filePath;
	
	
	public ArmazenaArquivoControle(HashMap<LocalDate, SaldoDiarioModelo> mapa, String filePath) {
		this.mapa = mapa;
		this.filePath = filePath;
	}
	
	
	public void Imprime()
    { 
		HashMap<String, Double> historico = new HashMap<String, Double>();
		// cria object de arquivo
        File file = new File(filePath);

        BufferedWriter bf = null;
  
        try {
  
            // cria BufferedReader object do arquivo de saida
            bf = new BufferedWriter(new FileWriter(file));
  
            // loop para obter a key
            for (Entry<LocalDate, SaldoDiarioModelo> entry : mapa.entrySet()) {
            	//inicializando constror de classe
            	SaldoDiarioModelo saldodiario = mapa.get(entry.getKey());
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
}
