import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Despesa extends Operacoes {
	//Declarando variaveis
	private Scanner read = new Scanner(System.in);
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private LocalDate data;
	private String descricao;
	private double valor;
	Saldo saldo;
	
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
	
	//Construtor da classe
	public Despesa(Saldo saldo) {
		this.saldo = saldo;
	}
	
	//Coleta dados que serao adicionados
	public void AddDespesa() {
		valor = ColetarValor() * -1;
		data = ColetarData();
		descricao = ColetarDescricao();
		saldo.AdicionaSaldoDiario(valor, descricao, data);
		saldo.SaldoTotal(valor);
		
	}
	
	//Coleta input de valor
	protected double ColetarValor (){
		System.out.print("Digite o valor ");
        valor = read.nextDouble(); 
        return valor;
		
	}
	
	//Coleta input de Data
	protected LocalDate ColetarData() {
		System.out.print("Digite a Data(yyyy-MM-dd) ");
		data = LocalDate.parse(read.next(), formatoData);
		return data;
	}

	//Coleta input de Descricao
	protected String ColetarDescricao() {
		System.out.print("Digite a descricao ");
		descricao = read.next(); 
		return descricao;
	}
	
		
}