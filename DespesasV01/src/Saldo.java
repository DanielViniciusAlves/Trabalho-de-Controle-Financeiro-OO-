import java.util.*;
import org.javatuples.Pair;
import java.time.LocalDate;  
public class Saldo {
	public static Stack<Double> stack = new Stack<Double>();
	private static Map<LocalDate, Pair<Double, String>> dict = new HashMap<LocalDate, Pair<Double, String>>();
	double despesa=0.00, receita=0.00, total;
	int totalSize, sizeR, sizeD;

	
	public Saldo(Stack<Double> stack) {
		Saldo.stack = stack;
	}
	
	public void SaldoMenu() {
		char option;
		Scanner read = new Scanner(System.in);
		do {
			//Print the Menu
			System.out.print("Digite a opcao desejada:\n"); 
	        System.out.print("1.Vizualizar historico de operacoes:\n"); 
	        System.out.print("2.Vizualizar saldo:\n");
	        System.out.print("Digite '0' para sair do Saldo\n");
	        option = read.next().charAt(0); 
	        switch(option) {
	        	case('1'):
	        		this.EmitirHistorico();
	        		break;
	        	case('2'):
	        		this.EmitirSaldo();
	        		break;
	        }
			
		}while(option != '0');
	}
	//Emite saldo
	public void EmitirSaldo(){
		Despesa Despesa = new Despesa(stack);
		Receita Receita = new Receita(stack);
		System.out.println(Despesa.GetDespesaStackPeek());
		despesa = Despesa.GetDespesaStackPeek();
		receita = Receita.GetReceitaStackPeek();
		total = receita - despesa;
		System.out.println(total);
		
	}
	//
	public void EmitirHistorico(){
		dict = Receita.GetReceitaDict();
		dict.forEach((key, value) -> System.out.println("Receita :Data " + key + ": " + value));
		dict = Despesa.GetDespesaDict();
		dict.forEach((key, value) -> System.out.println("Despesa: Data" + key + ": " + value));

	}
}
