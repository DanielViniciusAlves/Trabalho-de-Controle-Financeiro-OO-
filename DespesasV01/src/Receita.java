import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.javatuples.Pair; 

public class Receita extends Operacoes {
	//Declarando variaveis
	private Stack<Double> stack = new Stack<Double>();
	private static Map<LocalDate, Pair<Double, String>> dictionary = new HashMap<LocalDate, Pair<Double, String>>();
	private Scanner read = new Scanner(System.in);
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private LocalDate data;
	private String descricao;
	private double valor, valorTemp;
	
	// Get
	public LocalDate getData() {
		return data;
	}
	public String getDesc() {
		return descricao;
	}
	public Double getValor() {
		return valor;
	}
	public Double getValor2() {
		return valorTemp;
	}
	
	// Set
	public void setDate(LocalDate data) {
    	this.data = data;
    }
	public void setDesc(String desc) {
    	this.descricao = desc;
    }
	public void setValor(Double valor) {
    	this.valor = valor;
    }
	public void setValor2(Double valor2) {
    	this.valorTemp = valor2;
    }
	
	// Get
	public Stack<Double> getStack() {
		return stack;
	}
	public DateTimeFormatter getFormatoData() {
		return formatoData;
	}
	// Set
	public void setStack(Stack<Double> stack) {
    	this.stack = stack;
    }
	public void setFormatoData(DateTimeFormatter formatoData) {
		this.formatoData = formatoData;
	}
			
	//Construtor da classe
	public Receita(Stack<Double> stack) {
		this.stack = stack;
	}
	
	//Retorna Receita
	public static Map<LocalDate, Pair<Double, String>> GetReceitaDict(){
		return dictionary;
	}
	
	//Coleta dados que serao adicionados
	public void AddReceita() {
		valor = ColetarValor();
		data = ColetarData();
		descricao = ColetarDescricao();
		Armazenar(data, valor, descricao);
		Armazenar(valor);
	}
	
	//Coleta input de valor
	protected double ColetarValor (){
		System.out.print("Digite o valor ");
        valor = read.nextDouble(); 
        return valor;
		
	}
	
	//Coleta input de Data
	protected LocalDate ColetarData() {
		System.out.print("Digite a Data(yyyy-MM-dd) ");
		data = LocalDate.parse(read.next(), formatoData);
		return data;
	}

	//Coleta input de Descricao
	protected String ColetarDescricao() {
		System.out.print("Digite a descricao ");
		descricao = read.next(); 
		return descricao;
	}
	
	//Sobrecarga de Armazenar
	//Armazena stack
	protected Stack<Double> Armazenar(double valor) {
		valorTemp = stack.peek() + valor;
    	stack.push(valorTemp); 
		return stack;
	}
	
	//Armazenar Dicionario
	protected Map<LocalDate, Pair<Double, String>> Armazenar(LocalDate data, double valor, String desc) {
		Pair<Double, String> pair = new Pair<Double, String>(0.00,"");
		if(dictionary.containsKey(data)) {
			pair = dictionary.get(data);
			valor = valor + pair.getValue0();
			desc = desc + pair.getValue1();
		}
		dictionary.put(data, new Pair<Double, String>(valor, desc));
		return dictionary;
	}
	
}