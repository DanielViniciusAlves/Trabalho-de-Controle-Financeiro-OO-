package controle;
import modelo.DespesaModelo;
import view.DespesaView;

public class DespesaControle {
	private SaldoControle saldo;
	//Construtor da classe
	public DespesaControle(SaldoControle saldo) {
		this.saldo = saldo;
	}
	public void AddDespesa() {
		DespesaView despesaview = new DespesaView();
		DespesaModelo despesamodelo = new DespesaModelo();
		despesamodelo.setValor(despesaview.ColetarValor());
		despesamodelo.setData(despesaview.ColetarData());
		despesamodelo.setDescricao(despesaview.ColetarDescricao());
		saldo.AdicionaSaldoDiario(despesamodelo.getValor(), despesamodelo.getDescricao(), despesamodelo.getData());
		saldo.SaldoTotal(despesamodelo.getValor());
		
	}
}
