package controle;
import java.time.LocalDate;

import modelo.DespesaModelo;
import view.DespesaView;

public class DespesaControle {
	private SaldoControle saldo;
	//Construtor da classe
	public DespesaControle(SaldoControle saldo) {
		this.saldo = saldo;
	}
	public void AddDespesa(Double valor, LocalDate data, String descricao) {
		//DespesaView despesaview = new DespesaView();
		DespesaModelo despesamodelo = new DespesaModelo();
		despesamodelo.setValor(valor);
		despesamodelo.setData(data);
		despesamodelo.setDescricao(descricao);
		saldo.AdicionaSaldoDiario((despesamodelo.getValor()*-1), despesamodelo.getDescricao(), despesamodelo.getData());
		saldo.SaldoTotal(despesamodelo.getValor()*-1);
		
	}
}
