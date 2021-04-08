import java.util.HashMap;

public class SaldoDiario {
	private double saldo;
	private double valor;
	private String descricao;
	private HashMap<String, Double> historico;
	private Integer controlador;
	
	//Construtor da classe
	public SaldoDiario(Double valor, String descricao, HashMap<String, Double> historico) {
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
	public void setControlador(int controlador) {
    	this.controlador = controlador;
    }
	
	public HashMap<String, Double> getHistorico(){
        return historico;
    }
	public void setHistorico() {
		//Condicao se a Key ja for presente no HashMap
		if(this.historico.containsKey(this.descricao)) {
			//adiciona um numero na descricao
			setDescricao(this.descricao + " - " + addControlador().toString());
			//adiciona a key ao historico
			historico.put(getDescricao(), this.valor);
		}
		//Condicao se a Key nao for presente no HashMap
		else {
			historico.put(this.descricao, this.valor);
		}
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
	
	//Adiciona um ao numero controlador
	private Integer addControlador() {
    	return controlador = controlador + 1;
    }
	
	//Remove a operacao do historico
	public void removeHistorico(String descricao) {
		double valorRetirado = this.historico.get(descricao);
		//remove o valor
		this.historico.remove(descricao);
		//retirar valor do saldo diario
		setSaldo(valorRetirado*-1);
	}
}
