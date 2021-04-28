package modelo;


import controle.SaldoDiarioControle;

/**
 * Classe SaldoDiarioModelo responsavel por remover operacao de historico
 * @author danielalves
 * @version 2.0
 */
public class SaldoDiarioModelo {
	private SaldoDiarioControle saldodiario;
	
	/**
	 * Construtor da classe SaldoDiarioModelo, nao possui logica
	 * @param saldodiario classe SaldoDiarioControle
	 */
	public SaldoDiarioModelo(SaldoDiarioControle saldodiario) {
		this.saldodiario = saldodiario;
	}
	
	/**
	 * Classe responsavel de retirar operacao de HashMap chamando setHistorico de SaldoDiarioControle e por mudar valor do saldoTotal
	 * @param descricao Descricao que sera excluida
	 */
	public void removeHistorico(String descricao) {
		double valorRetirado = saldodiario.getHistorico().get(descricao);
		//remove o valor
		saldodiario.setHistorico(true);
		//retirar valor do saldo diario
		saldodiario.setSaldo(valorRetirado*-1);
	}
}
