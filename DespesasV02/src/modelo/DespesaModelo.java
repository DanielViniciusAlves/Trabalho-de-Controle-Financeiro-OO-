package modelo;
import java.time.LocalDate;

import controle.DespesaControle;

/**
 * Classe DespesaModelo e responsavel por receber os dados e chamar metodo para salvar dados, herdara construtor e parametro de OperacoesHeranca
 * @author danielalves
 * @version 2.0
 */
public class DespesaModelo extends OperacoesHeranca {
	/**
	 * Contrutor de classe que recebera saldo como parametro e ira chamar contrutor de classe da classe mae
	 * @param saldo classe SaldoModelo
	 */
	public DespesaModelo(SaldoModelo saldo) {
		super(saldo);
	}
	/**
	 * AddDespesa muda os valores de Valor Data e Descricao, recebidos como parametro, em DespesaControle e chama os metodos AdicionaSaldoDiario e SaldoTotal
	 * @param valor Valor adicionado
	 * @param data Data adicionada
	 * @param descricao Descricao Adicionada
	 */
	public void AddDespesa(Double valor, LocalDate data, String descricao) {
		//DespesaView despesaview = new DespesaView();
		DespesaControle despesacontrole = new DespesaControle();
		despesacontrole.setValor(valor);
		despesacontrole.setData(data);
		despesacontrole.setDescricao(descricao);
		saldo.AdicionaSaldoDiario((despesacontrole.getValor()*-1), despesacontrole.getDescricao(), despesacontrole.getData());
		saldo.SaldoTotal(despesacontrole.getValor()*-1);
		
	}
}
