import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		char option;
		Stack<Double> stack = new Stack<Double>();
		stack.push((double) 0);
		Despesa objeto = new Despesa(stack);
		Receita objeto2 = new Receita(stack);
		Saldo saldo = new Saldo(stack);
		do {
			//Print the Menu
			System.out.print("Digite a opcao desejada:\n"); 
	        System.out.print("1.Adicionar despesa:\n"); 
	        System.out.print("2.Adicionar receita:\n");
	        System.out.print("3.Vizualizar saldo:\n");
	        System.out.print("Digite '0' para sair do programa\n");
	        option = read.next().charAt(0); 
	        switch(option) {
	        	case('1'):
	        		objeto.AddDespesa();
	        		break;
	        	case('2'):
	        		objeto2.AddReceita();
	        		break;
	        	case('3'):
	        		saldo.SaldoMenu();
	        		break;
	        }
			
		}while(option != '0');
	}
}
