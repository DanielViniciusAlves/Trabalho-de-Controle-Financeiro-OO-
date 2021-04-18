package modelo;

import java.time.LocalDate;
import java.util.*;

import controle.SaldoDiarioControle;
import modelo.SaldoDiarioModelo;

public class SaldoModelo {
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private double total;
	private double valor;
	private String descricao;
	private String operacao;
	
	//Construtor
	public SaldoModelo(HashMap<LocalDate, SaldoDiarioControle> mapa) {
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
	
	public Double getValor(){
		return valor; 
    }
	public void setValor(Double valor){
		this.valor = valor; 
    }
	
	public Double getSaldo(LocalDate data){
		//Obtem o Saldo para a Key correta
		SaldoDiarioControle saldodiario = mapa.get(data);
		return saldodiario.getSaldo();
    }
	
	public void AdicionaSaldoDiario(Double valor, String descricao, LocalDate data) {
		//Condicao para quando o HashMap estiver vazio
		if(mapa.get(data) == null) {
			//Eh criado um novo Hashmap e adicionado uma nova Key no mapa
			HashMap<String, Double> historico = new HashMap<String, Double>();
			mapa.put(data, new SaldoDiarioControle(valor, descricao, historico));
		}
		//Quando o mapa estiver preenchido
		else {
			SaldoDiarioControle saldodiario = mapa.get(data);
			saldodiario.setDescricao(descricao);
			saldodiario.setSaldo(valor);
			saldodiario.setValor(valor);
			saldodiario.setHistorico();	
		}
			
	}
	
	//Adiciona e obtem o SaldoTotal
	public void SaldoTotal(Double valor) {
		this.total = valor + total;
	}
	
	//EmitiHistorico sem alteracoes
	public String EmitirHistorico(LocalDate data) {
		SaldoDiarioControle saldodiario = mapa.get(data);
		return saldodiario.getHistorico().toString();
	}
	//Remove uma operacao do historico e emite historico
	public void RemoveHistorico(LocalDate data, String descricao) {
		SaldoDiarioControle saldodiario = mapa.get(data);
		SaldoDiarioModelo saldoDiarioModelo = new SaldoDiarioModelo(saldodiario);
		//Muda o saldo total
		SaldoTotal(saldodiario.getValor()*-1);
		//Remove operacao
		saldoDiarioModelo.removeHistorico(descricao);
	}
}
