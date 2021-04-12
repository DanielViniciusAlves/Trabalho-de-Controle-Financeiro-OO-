package controle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;

import modelo.SaldoDiarioModelo;

public class LeArquivoControle {
	private HashMap<LocalDate, SaldoDiarioModelo> mapa;
	private String filePath;
	
	//Construtor
	public LeArquivoControle(HashMap<LocalDate, SaldoDiarioModelo> mapa, String filePath) {
		this.mapa = mapa;
		this.filePath = filePath;
	}
	
	//Deleta dados do arquivo para armazenar novos dados
	private void DeletaArquivo() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(this.filePath);
		writer.print("");
		writer.close();
	}
	
	public HashMap<LocalDate, SaldoDiarioModelo> PreencheMapa(SaldoControle saldo) throws FileNotFoundException{
        BufferedReader br = null;
  
        try {
  
            // cria object de arquivo
            File file = new File(filePath);
  
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
        DeletaArquivo();
        return mapa;
    }
}
