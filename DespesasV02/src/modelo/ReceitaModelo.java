package modelo;
import java.time.LocalDate;

import controle.ReceitaControle;

/**
 * Classe ReceitaModelo e responsavel por receber os dados e chamar metodo para salvar dados, herdara construtor e parametro de OperacoesHeranca
 * @author danielalves
 * @version 2.0
 */
public class ReceitaModelo extends OperacoesHeranca{
	/**
	 * Contrutor de classe que recebera saldo como parametro e ira chamar contrutor de classe da classe mae
	 * @param saldo classe SaldoModelo
	 */
	public ReceitaModelo(SaldoModelo saldo) {
		super(saldo);
	}
	/**
	 * AddReceita muda os valores de Valor Data e Descricao, recebidos como parametro, em ReceitaControle e chama os metodos AdicionaSaldoDiario e SaldoTotal
	 * @param valor Valor adicionado
	 * @param data Data adicionada
	 * @param descricao Descricao Adicionada
	 */
	public void AddReceita(Double valor, LocalDate data, String descricao) {
		//ReceitaView receitaview = new ReceitaView();
		ReceitaControle receitacontrole = new ReceitaControle();
		receitacontrole.setValor(valor);
		receitacontrole.setData(data);
		receitacontrole.setDescricao(descricao);
		saldo.AdicionaSaldoDiario(receitacontrole.getValor(), receitacontrole.getDescricao(), receitacontrole.getData());
		saldo.SaldoTotal(receitacontrole.getValor());
		System.out.print(receitacontrole.getValor());
		
	}
}
