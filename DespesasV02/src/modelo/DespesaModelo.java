package modelo;
import java.time.LocalDate;

import controle.DespesaControle;

public class DespesaModelo {
	private SaldoModelo saldo;
	//Construtor da classe
	public DespesaModelo(SaldoModelo saldo) {
		this.saldo = saldo;
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
