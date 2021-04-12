package modelo;
import java.util.HashMap;

public class SaldoDiarioModelo {
	private double saldo;
	private double valor;
	private String descricao;
	private HashMap<String, Double> historico;
	private Integer controlador;
	
	//Construtor da classe
	public SaldoDiarioModelo(Double valor, String descricao, HashMap<String, Double> historico) {
		this.controlador = 0;
		this.valor = valor;
		this.descricao = descricao;
		this.saldo = valor;
		this.historico = historico;
		historico.put(descricao, valor);
	}
	
	public Integer getControlador() {
    	return controlador;
    }
	public void setControlador() {
    	this.controlador = controlador + 1;
    }
	
	public HashMap<String, Double> getHistorico(){
        return historico;
    }
	public void setHistorico() {
		//Condicao se a Key ja for presente no HashMap
		if(this.historico.containsKey(this.descricao)) {
			//adiciona um numero na descricao
			this.setControlador();
			setDescricao(this.descricao + "-" + getControlador().toString());
			//adiciona a key ao historico
			this.historico.put(getDescricao(), this.valor);
		}
		//Condicao se a Key nao for presente no HashMap
		else {
			historico.put(this.descricao, this.valor);
		}
	}
	public void setHistorico(boolean apagar) {
		this.historico.remove(descricao);
	}
	
	public String getDescricao(){
        return descricao;
    }
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValor() {
    	return valor;
    }
	public void setValor(double valor) {
    	this.valor = valor;
    }
     
	public void setSaldo(Double valor) {
    	saldo = saldo + valor; 
    }
	public Double getSaldo(){
        return saldo;
    }
	
}
