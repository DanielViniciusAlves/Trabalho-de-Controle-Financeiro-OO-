package modelo;
import java.time.LocalDate;

import controle.ReceitaControle;

public class ReceitaModelo {
	private SaldoModelo saldo;
	//Construtor da classe
	public ReceitaModelo(SaldoModelo saldo) {
		this.saldo = saldo;
	}
	public void AddReceita(Double valor, LocalDate data, String descricao) {
		//ReceitaView receitaview = new ReceitaView();
		ReceitaControle receitacontrole = new ReceitaControle();
		receitacontrole.setValor(valor);
		receitacontrole.setData(data);
		receitacontrole.setDescricao(descricao);
		saldo.AdicionaSaldoDiario(receitacontrole.getValor(), receitacontrole.getDescricao(), receitacontrole.getData());
		saldo.SaldoTotal(receitacontrole.getValor());
		
	}
}
