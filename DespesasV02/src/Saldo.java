import java.time.LocalDate;
import java.util.*;

public class Saldo {
	private HashMap<LocalDate, SaldoDiario> mapa;
	private double total;
	private double valor;
	private String descricao;
	private String operacao;
	private LocalDate data;
	
	//Construtor
	public Saldo(HashMap<LocalDate, SaldoDiario> mapa) {
		this.mapa = mapa;
	}
	
	//Encapsulamento da classe
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
		//Obtem o Saldo para a Key correta
		SaldoDiario saldodiario = mapa.get(data);
		return saldodiario.getSaldo();
    }
	
	public void AdicionaSaldoDiario(Double valor, String descricao, LocalDate data) {
		//Condicao para quando o HashMap estiver vazio
		if(mapa.get(data) == null) {
			//Eh criado um novo Hashmap e adicionado uma nova Key no mapa
			HashMap<String, Double> historico = new HashMap<String, Double>();
			mapa.put(data, new SaldoDiario(valor, descricao, historico));
		}
		//Quando o mapa estiver preenchido
		else {
			SaldoDiario saldodiario = mapa.get(data);
			saldodiario.setDescricao(descricao);
			saldodiario.setSaldo(valor);
			saldodiario.setValor(valor);
			saldodiario.setHistorico();
		}
			
	}
	//Adiciona e obtem o SaldoTotal
	public void SaldoTotal(Double valor) {
		total = valor + total;
	}
	//EmitiHistorico sem alteracoes
	public void EmitirHistorico(LocalDate data) {
		SaldoDiario saldodiario = mapa.get(data);
		System.out.println(saldodiario.getHistorico());	
	}
	//Remove uma operacao do historico e emite historico
	public void RemoveHistorico(LocalDate data, String descricao) {
		SaldoDiario saldodiario = mapa.get(data);
		//Muda o saldo total
		SaldoTotal(saldodiario.getValor()*-1);
		//Remove operacao
		saldodiario.removeHistorico(descricao);
		//Emite historico
		System.out.println(saldodiario.getHistorico());	
	}
}
