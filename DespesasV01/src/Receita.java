import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.javatuples.Pair; 

public class Receita extends Operacoes {
	//Declarando variaveis
	private Stack<Double> stack = new Stack<Double>();
	private static Map<LocalDate, Pair<Double, String>> dict = new HashMap<LocalDate, Pair<Double, String>>();
	private Scanner read = new Scanner(System.in);
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private LocalDate data;
	private String desc;
	private double valor, valor2;
	
	//Construtor da classe
	public Receita(Stack<Double> stack) {
		this.stack = stack;
	}
	
	//Retorna Receita
	public static Map<LocalDate, Pair<Double, String>> GetReceitaDict(){
		return dict;
	}
	
	//Coleta dados que serao adicionados
	public void AddReceita() {
		valor = ColetarValor();
		data = ColetarData();
		desc = ColetarDescricao();
		Armazenar(data, valor, desc);
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
		desc = read.next(); 
		return desc;
	}
	
	//Sobrecarga de Armazenar
	//Armazena stack
	protected Stack<Double> Armazenar(double valor) {
		valor2 = stack.peek() + valor;
    	stack.push(valor2); 
		return stack;
	}
	
	//Armazenar Dicionario
	protected Map<LocalDate, Pair<Double, String>> Armazenar(LocalDate data, double valor, String desc) {
		Pair<Double, String> pair = new Pair<Double, String>(0.00,"");
		if(dict.containsKey(data)) {
			pair = dict.get(data);
			valor = valor + pair.getValue0();
			desc = desc + pair.getValue1();
		}
		dict.put(data, new Pair<Double, String>(valor, desc));
		return dict;
	}
	
}