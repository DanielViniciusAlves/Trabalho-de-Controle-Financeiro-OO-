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
	private String filePathMapa;
	private String filePathSaldo;
	
	//Construtor
	public LeArquivoControle(HashMap<LocalDate, SaldoDiarioModelo> mapa, String filePathMapa, String filePathSaldo) {
		this.mapa = mapa;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo = filePathSaldo;
	}
	
	//Deleta dados do arquivo para armazenar novos dados
	private void DeletaArquivoMapa() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(this.filePathMapa);
		writer.print("");
		writer.close();
	}
	
	//Deleta dados do arquivo para armazenar novos dados
	private void DeletaArquivoSaldo() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(this.filePathSaldo);
		writer.print("");
		writer.close();
	}
	
	public HashMap<LocalDate, SaldoDiarioModelo> PreencheMapa(SaldoControle saldo) throws FileNotFoundException{
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
	
	public void PreencheSaldo(SaldoControle saldo) throws FileNotFoundException{
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
