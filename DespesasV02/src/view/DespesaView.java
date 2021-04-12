package view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DespesaView  extends Operacoes {
	private Scanner read = new Scanner(System.in);
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private LocalDate data;
	private String descricao;
	private double valor;
	
	public LocalDate getData() {
		return data;
	}
	public void setDate(LocalDate data) {
    	this.data = data;
    }
	
	public DateTimeFormatter getFormatoData() {
		return formatoData;
	}
	public void setFormatoData(DateTimeFormatter formatoData) {
		this.formatoData = formatoData;
	}
			
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
    	this.valor = valor;
    }
	
	public DespesaView(){
		
	}
	//Coleta input de valor
	public double ColetarValor (){
		System.out.print("Digite o valor ");
        valor = read.nextDouble(); 
        return valor;
		
	}
	
	//Coleta input de Data
	public LocalDate ColetarData() {
		System.out.print("Digite a Data(yyyy-MM-dd) ");
		data = LocalDate.parse(read.next(), formatoData);
		return data;
	}

	//Coleta input de Descricao
	public String ColetarDescricao() {
		System.out.print("Digite a descricao ");
		descricao = read.next(); 
		return descricao;
		}
}