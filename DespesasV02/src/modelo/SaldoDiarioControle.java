package modelo;

import java.util.HashMap;

import controle.SaldoDiarioModelo;

public class SaldoDiarioControle {
	private double saldo;
	private double valor;
	private String descricao;
	private HashMap<String, Double> historico;
	private Integer controlador;
	private SaldoDiarioModelo saldodiario;
	
	//Construtor da classe
	public SaldoDiarioControle(SaldoDiarioModelo saldodiario) {
		this.saldodiario = saldodiario;
	}
	
	//Remove a operacao do historico
	public void removeHistorico(String descricao) {
		double valorRetirado = saldodiario.getHistorico().get(descricao);
		//remove o valor
		saldodiario.setHistorico(true);
		//retirar valor do saldo diario
		saldodiario.setSaldo(valorRetirado*-1);
	}
}
