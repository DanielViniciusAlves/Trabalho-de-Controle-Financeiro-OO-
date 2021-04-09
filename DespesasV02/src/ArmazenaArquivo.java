import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;

public class ArmazenaArquivo {
	private HashMap<LocalDate, SaldoDiario> mapa;
	private String filePath;
	
	
	public ArmazenaArquivo(HashMap<LocalDate, SaldoDiario> mapa, String filePath) {
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
            for (Entry<LocalDate, SaldoDiario> entry : mapa.entrySet()) {
            	//inicializando constror de classe
            	SaldoDiario saldodiario = mapa.get(entry.getKey());
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
