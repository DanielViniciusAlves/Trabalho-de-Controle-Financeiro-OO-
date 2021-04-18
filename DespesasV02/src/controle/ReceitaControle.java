package controle;
import java.time.LocalDate;

import modelo.ReceitaModelo;
//import view.ReceitaView;

public class ReceitaControle {
	private SaldoControle saldo;
	//Construtor da classe
	public ReceitaControle(SaldoControle saldo) {
		this.saldo = saldo;
	}
	public void AddReceita(Double valor, LocalDate data, String descricao) {
		//ReceitaView receitaview = new ReceitaView();
		ReceitaModelo receitamodelo = new ReceitaModelo();
		receitamodelo.setValor(valor);
		receitamodelo.setData(data);
		receitamodelo.setDescricao(descricao);
		saldo.AdicionaSaldoDiario(receitamodelo.getValor(), receitamodelo.getDescricao(), receitamodelo.getData());
		saldo.SaldoTotal(receitamodelo.getValor());
		
	}
}
