package controle;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Controle de Saldo, onde se encontra encapsulamento da classe
 * @author danielalves
 * @version 2.0
 */
public class SaldoControle {
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private double total;
	private String descricao;
	private String operacao;
	
	/**
	 * Construtor da classe SaldoControle em que se inicia o parametro total, que seria o Saldo Total. 
	 * Tambem eh feito a inicializacao de mapa recebendo-o como parametro.
	 * 
	 * @param mapa HashMap com LocalDate, SaldoDiarioControle como key e value
	 */
	public SaldoControle(HashMap<LocalDate, SaldoDiarioControle> mapa) {
		this.total = 0;
		this.mapa = mapa;
	}
	
	//Encapsulamento da classe
	public String getDescricao(){
		return descricao; 
    }
	public void setDescricao(String descricao){
		this.descricao = descricao; 
    }
	
	public String getOperacao(){
		return operacao; 
    }
	public void setOperacao(String operacao){
		this.operacao = operacao; 
    }
	
	public Double getTotal(){
		return total; 
    }
	public void setTotal(Double total){
		this.total = total; 
    }
	
	public HashMap<LocalDate, SaldoDiarioControle> getMapa(){
		return mapa; 
    }
	public void setMapa(HashMap<LocalDate, SaldoDiarioControle> mapa){
		this.mapa = mapa; 
    }
}
