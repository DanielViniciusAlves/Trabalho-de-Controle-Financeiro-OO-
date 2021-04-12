package controle;
import modelo.ReceitaModelo;
import view.ReceitaView;

public class ReceitaControle {
	private SaldoControle saldo;
	//Construtor da classe
	public ReceitaControle(SaldoControle saldo) {
		this.saldo = saldo;
	}
	public void AddReceita() {
		ReceitaView receitaview = new ReceitaView();
		ReceitaModelo receitamodelo = new ReceitaModelo();
		receitamodelo.setValor(receitaview.ColetarValor());
		receitamodelo.setData(receitaview.ColetarData());
		receitamodelo.setDescricao(receitaview.ColetarDescricao());
		saldo.AdicionaSaldoDiario(receitamodelo.getValor(), receitamodelo.getDescricao(), receitamodelo.getData());
		saldo.SaldoTotal(receitamodelo.getValor());
		
	}
}
