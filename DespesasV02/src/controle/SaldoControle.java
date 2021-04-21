package controle;

import java.time.LocalDate;
import java.util.HashMap;

public class SaldoControle {
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private double total;
	private String descricao;
	private String operacao;
	
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
