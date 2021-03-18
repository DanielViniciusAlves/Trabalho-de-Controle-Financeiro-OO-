import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		// creating a Stack for Saldo
		Stack<Double> stack = new Stack<Double>();
		// creating a Stack for Transferencias
		Stack<Double> transferencias = new Stack<Double>();
		//Initializing Stacks
		transferencias.push(0.00);
		stack.push(0.00);
		//Initializing Date
		String date = "01/01/2021";
		Scanner read = new Scanner(System.in);
		char option;
		do {
			//Print the Menu
			System.out.print("Digite a opcao desejada:\n"); 
	        System.out.print("1.Adicionar despesa ou receita:\n"); 
	        System.out.print("2.Vizualizar saldo:\n");
	        System.out.print("3.Vizualizar despesa ou receita anteriores:\n");
	        System.out.print("Digite '0' para sair do programa\n");
	        option = read.next().charAt(0); 
	        switch(option) {
	        	case('1'):
	        		//Print the Date input and store the date value 
	        		date = printMenu.Date(date);
	        		//Print the Value input and store the value 
	        		double value = printMenu.Value();
	        		//Store the transfers
	        		transferencias = transfer.Operations(transferencias, value);
	        		//Calculate the operation
	        		stack = estruturaSaldo.Pilha(stack, value);
	        		break;
	        	case('2'): 
	        		//Print the Saldo from the last date
	        		estruturaSaldo.Pilha(stack);
	        		break;
	        	case('3'): 
	        		//Print the Operations realized 
	        		transfer.Operations(transferencias);
	        		break;
	        }
			
		}while(option != '0');
	}
}
