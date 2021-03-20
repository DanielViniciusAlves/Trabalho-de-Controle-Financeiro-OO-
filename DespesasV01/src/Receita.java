import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.javatuples.Pair; 

public class Receita extends Operacoes {
	public static Stack<Double> stack = new Stack<Double>();
	private static Map<LocalDate, Pair<Double, String>> dict = new HashMap<LocalDate, Pair<Double, String>>();
	Scanner read = new Scanner(System.in);
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private LocalDate data;
	private String desc;
	private double valor, valor2;
	
	public Receita(Stack<Double> stack) {
		Receita.stack = stack;
	}
	
	public static Map<LocalDate, Pair<Double, String>> GetReceitaDict(){
		return dict;
	}
	
	public Double GetReceitaStackPeek(){
		return stack.peek();
	}
	
	public void AddReceita() {
		valor = ColetarValor();
		data = ColetarData();
		desc = ColetarDescricao();
		Armazenar(data, valor, desc);
		Armazenar(valor);
	}

	protected double ColetarValor (){
		System.out.print("Digite o valor ");
        valor = read.nextDouble(); 
        return valor;
		
	}

	protected LocalDate ColetarData() {
		System.out.print("Digite a Data(yyyy-MM-dd) ");
		data = LocalDate.parse(read.next(), formatoData);
		return data;
	}

	
	protected String ColetarDescricao() {
		System.out.print("Digite a descricao ");
		desc = read.next(); 
		return desc;
	}
	
	protected Stack<Double> Armazenar(double valor) {
		valor2 = stack.peek() + valor;
    	stack.push(valor2); 
		return stack;
	}
	
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