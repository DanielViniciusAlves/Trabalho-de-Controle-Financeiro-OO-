public class SaldoDiario {
	private double saldo;
	private double valor;
	private String descricao;
	private String valorImpresso;
	
	public SaldoDiario(Double valor, String descricao) {
		this.valorImpresso = valor.toString();
		this.valor = valor;
		this.descricao = descricao;
		this.saldo = valor;
	}
	
	public String getDescricao(){
        return descricao;
    }
	public void setDescricao(String descricao) {
		this.descricao = this.descricao + " --- " + descricao;
	}
	
	public String getValorImpresso(){
        return valorImpresso;
    }
	public void setValorImpresso(Double valorImpresso) {
		valorImpresso.toString();
		this.valorImpresso = this.valorImpresso + " --- " + valorImpresso;
	}
	
	public Double getValor() {
    	return valor;
    }
	public void setValor(double valor) {
    	this.valor = valor;
    }
     
	public void setSaldo(Double valor) {
    	saldo = saldo + valor; 
    }
	public Double getSaldo(){
        return saldo;
    }
}
