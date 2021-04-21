package controle;
import java.time.LocalDate;

public class ReceitaControle extends OperacoesAbstratas{
	//Declarando variaveis
	private LocalDate data;
	private String descricao;
	private double valor;
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
    	this.data = data;
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
	public ReceitaControle() {
		
	}
	
		
}