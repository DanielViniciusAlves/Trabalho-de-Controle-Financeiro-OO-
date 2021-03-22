import java.util.*;
public class Saldo {
	//Declarando variaveis
	private  Stack<Double> stack = new Stack<Double>();
	
	// Get
	public Stack<Double> getStack() {
		return stack;
	}
	// Set
	public void setStack(Stack<Double> stack) {
    	this.stack = stack;
    }
	
	//Construtor da classe Saldo
	public Saldo(Stack<Double> stack) {
		this.stack = stack;
	}
	
	//Imprime Menu de Saldo e chama metodos
	public void SaldoMenu() {
		char option;
		Scanner read = new Scanner(System.in);
		do {
			//Imprime Menu de Saldo
			System.out.print("Digite a opcao desejada:\n"); 
	        System.out.print("1.Vizualizar historico de operacoes:\n"); 
	        System.out.print("2.Vizualizar saldo:\n");
	        System.out.print("Digite '0' para sair do Saldo\n");
	        option = read.next().charAt(0); 
	        //Switch de Opcoes de saldo
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
	//Emite topo do stack
	private void EmitirSaldo(){
		System.out.println(stack.peek());
		
	}
	//Emite todo o Dicionario de receita e Despesa
	private void EmitirHistorico(){
		Receita.GetReceitaDict().forEach((key, value) -> System.out.println("Receita :Data " + key + ": " + value));
		Despesa.GetDespesaDict().forEach((key, value) -> System.out.println("Despesa: Data" + key + ": " + value));

	}
}
