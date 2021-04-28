package modelo;

import java.time.LocalDate;
import java.util.*;

import controle.SaldoDiarioControle;
import controle.SaldoControle;
//import modelo.SaldoDiarioModelo;

/**
 * Classe SaldoModelo responsavel por adicionar operacao, emitir o historico de operacoes e retirar uma operacao realizada
 * @author danielalves
 * @version 2.0
 */
public class SaldoModelo {
	private SaldoControle SaldoControle;
	
	/**
	 * Construtor da classe SaldoModelo, inicializando SaldoControle
	 * @param mapa HashMap com LocalDate, SaldoDiarioControle como key e value
	 */
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
	
	/**
	 * AdicionaSaldoDiario adiciona operacao ao mapa.
	 * Se no dia adicionado ja tiver uma operacao so eh adicionado nao se inicializa construtor da classe SaldoDiarioControle
	 * @param valor Valor adicionado
	 * @param data Data adicionada
	 * @param descricao Descricao Adicionada
	 */
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
	
	/**
	 * SaldoTotal vai adicionar o valor da operacao ao saldo total
	 * @param valor Valor adicionado
	 */
	public void SaldoTotal(Double valor) {
		SaldoControle.setTotal(valor + SaldoControle.getTotal());
	}
	
	//Sobrecarga de metodos
	/**
	 * EmitirHistorico recebe a data e retorna todas operacoes realizadas no dia
	 * @param data Data adicionada
	 * @return Historico de operacoes do dia em forma de string
	 */
	public String EmitirHistorico(LocalDate data) {
		SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
		return saldodiario.getHistorico().toString();
	}
	
	/**
	 * EmitirHistorico recebe a data e retorna saldoTotal do dia requisitado.
	 * Sem utilidade no momento
	 * @param data Data adicionada
	 * @param saldo Boolean para realizar operacao
	 * @return SaldoTotal do dia requisitado
	 */
	public Double EmitirHistorico(LocalDate data, Boolean saldo){
		//Obtem o Saldo para a Key correta
		SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
		return saldodiario.getSaldo();
    }
	
	/**
	 * RemoveHistorico remove uma operacao do historico, muda SaldoTotal e emite historico
	 * @param data Data adicionada
	 * @param descricao Descricao Adicionada
	 */
	public void RemoveHistorico(LocalDate data, String descricao) {
		SaldoDiarioControle saldodiario = SaldoControle.getMapa().get(data);
		SaldoDiarioModelo saldoDiarioModelo = new SaldoDiarioModelo(saldodiario);
		//Muda o saldo total
		SaldoTotal(saldodiario.getValor()*-1);
		//Remove operacao
		saldoDiarioModelo.removeHistorico(descricao);
	}
}
