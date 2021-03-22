import java.time.LocalDate;

public class ContaBancaria  extends Conta{
	private double saldo;
	private double despesa;
	private double receita;
	
	// Get
	public Double getSaldo() {
		return saldo;
	}
	public Double getReceita() {
		return receita;
	}
	public Double getDespesa() {
		return despesa;
	}
	
	// Set
	public void setSaldo(Double saldo) {
	    this.saldo = saldo;
	}
	public void setReceita(Double receita) {
    	this.receita = receita;
    }
	public void setDespesa(Double despesa) {
    	this.despesa = despesa;
    }
	
	//Métodos
	public void EmitirSaldo() {
		;
	}
	public void EmitirHistorico() {
		;
	}
	
}