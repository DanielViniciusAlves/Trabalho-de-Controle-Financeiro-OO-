package modelo;

/**
 * Classe Pai de DespesaModelo e ReceitaModelo
 * @author danielalves
 * @version 2.0
 */
public class OperacoesHeranca {
	protected SaldoModelo saldo;
	/**
	 * Construtor da classe OperacoesHeranca, nao possui logica
	 * @param saldo classe SaldoModelo
	 */
	public OperacoesHeranca(SaldoModelo saldo) {
		this.saldo = saldo;
	}
}
