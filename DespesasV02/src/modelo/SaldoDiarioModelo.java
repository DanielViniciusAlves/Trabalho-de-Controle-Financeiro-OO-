package modelo;


import controle.SaldoDiarioControle;

public class SaldoDiarioModelo {
	private SaldoDiarioControle saldodiario;
	
	//Construtor da classe
	public SaldoDiarioModelo(SaldoDiarioControle saldodiario) {
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
