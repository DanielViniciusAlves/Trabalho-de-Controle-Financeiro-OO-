import java.time.LocalDate;
import java.util.*;

public class Saldo {
	HashMap<LocalDate, SaldoDiario> mapa;
	double total;
	double valor;
	String descricao;
	String operacao;
	LocalDate data;
	
	//Construtor
	public Saldo(HashMap<LocalDate, SaldoDiario> mapa) {
		this.mapa = mapa;
	}
	
	public String getDescricao(){
		return descricao; 
    }
	public void setDescricao(String descricao){
		this.descricao = descricao; 
    }
	
	public String getOperacao(){
		return operacao; 
    }
	public void setOperacao(String operacao){
		this.operacao = operacao; 
    }
	
	public Double getTotal(){
		return total; 
    }
	public void setTotal(Double total){
		this.total = total; 
    }
	
	public HashMap<LocalDate, SaldoDiario> getMapa(){
		return mapa; 
    }
	public void setMapa(HashMap<LocalDate, SaldoDiario> mapa){
		this.mapa = mapa; 
    }
	
	public Double getValor(){
		return total; 
    }
	public void setValor(Double valor){
		this.valor = valor; 
    }
	
	Double getSaldo(LocalDate data){
		SaldoDiario saldodiario = mapa.get(data);
		return saldodiario.getSaldo();
    }
	
	public void AdicionaSaldoDiario(Double valor, String descricao, LocalDate data) {
		if(mapa.get(data) == null) {
			mapa.put(data, new SaldoDiario(valor, descricao));
		}
		else {
			SaldoDiario saldodiario = mapa.get(data);
			saldodiario.setDescricao(descricao);
			saldodiario.setValorImpresso(valor);
			saldodiario.setSaldo(valor);
		}
			
	}
	public void SaldoTotal(Double valor) {
		total = valor + total;
	}
	public void Historico(LocalDate data) {
		SaldoDiario saldodiario = mapa.get(data);
		saldodiario.getValorImpresso();
		System.out.println(saldodiario.getDescricao());
		System.out.println(saldodiario.getValorImpresso());
		
	}
}
