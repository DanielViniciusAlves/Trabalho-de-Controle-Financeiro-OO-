package modelo;
import java.time.LocalDate;

import controle.DespesaControle;

public class DespesaModelo extends OperacoesHeranca {
	//Construtor da classe
	public DespesaModelo(SaldoModelo saldo) {
		super(saldo);
	}
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
