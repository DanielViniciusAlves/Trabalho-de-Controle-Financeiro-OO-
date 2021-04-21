package modelo;

import java.time.LocalDate;
import java.util.*;

import controle.SaldoDiarioControle;
import controle.SaldoControle;
//import modelo.SaldoDiarioModelo;

public class SaldoModelo {
	private SaldoControle SaldoControle;
	
	//Construtor
	public SaldoModelo(HashMap<LocalDate, SaldoDiarioControle> mapa) {
		this.SaldoControle = new SaldoControle(mapa);
	}
	//Encapsulamento
	public SaldoControle getSaldoControle(){
		return this.SaldoControle;
    }
	public void setSaldoControle(SaldoControle SaldoControle){
		this.SaldoControle = SaldoControle;
    }
	
	//Retorna Saldo diario, sem utilidade no momento
	public Double SaldoDiario(LocalDate data){
		//Obtem o Saldo para a Key correta
		SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
		return saldodiario.getSaldo();
    }
	
	public void AdicionaSaldoDiario(Double valor, String descricao, LocalDate data) {
		//Condicao para quando o HashMap estiver vazio
		if(SaldoControle.getMapa().get(data) == null) {
			//Eh criado um novo Hashmap e adicionado uma nova Key no mapa
			HashMap<String, Double> historico = new HashMap<String, Double>();
			SaldoControle.getMapa().put(data, new SaldoDiarioControle(valor, descricao, historico));
		}
		//Quando o mapa estiver preenchido
		else {
			SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
			saldodiario.setDescricao(descricao);
			saldodiario.setSaldo(valor);
			saldodiario.setValor(valor);
			saldodiario.setHistorico();	
		}
			
	}
	
	//Adiciona ao Saldo
	public void SaldoTotal(Double valor) {
		SaldoControle.setTotal(valor + SaldoControle.getTotal());
	}
	
	//EmitiHistorico sem alteracoes
	public String EmitirHistorico(LocalDate data) {
		SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
		return saldodiario.getHistorico().toString();
	}
	//Remove uma operacao do historico e emite historico
	public void RemoveHistorico(LocalDate data, String descricao) {
		SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
		SaldoDiarioModelo saldoDiarioModelo = new SaldoDiarioModelo(saldodiario);
		//Muda o saldo total
		SaldoTotal(saldodiario.getValor()*-1);
		//Remove operacao
		saldoDiarioModelo.removeHistorico(descricao);
	}
}
