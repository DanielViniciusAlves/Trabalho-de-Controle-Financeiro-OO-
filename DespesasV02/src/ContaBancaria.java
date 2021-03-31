import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class ContaBancaria {	
	public static void Menu() {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data;
		HashMap<LocalDate, SaldoDiario> mapa = new HashMap<LocalDate, SaldoDiario>();
		Saldo saldo = new Saldo(mapa);
		Despesa despesa = new Despesa(saldo);
		Receita receita = new Receita(saldo);
		//Objeto para ler input
		Scanner read = new Scanner(System.in);
		char option;
		do {
			//Imprimindo Menu
			System.out.print("Digite a opcao desejada:\n"); 
	        System.out.print("1.Adicionar despesa:\n"); 
	        System.out.print("2.Adicionar receita:\n");
	        System.out.print("3.Historico de operacoes:\n");
	        System.out.print("4.Saldo diario:\n");
	        System.out.print("5.Saldo total:\n");
	        System.out.print("Digite '0' para sair do programa\n");
	        option = read.next().charAt(0); 
	        //Switch para opcoes
	        switch(option) {
	        	case('1'):
	        		despesa.AddDespesa();
	        		break;
	        	case('2'):
	        		receita.AddReceita();
	        		break;
	        	case('3'):
	        		System.out.print("Digite a Data(yyyy-MM-dd) ");
		    		data = LocalDate.parse(read.next(), formatoData);
	        		saldo.Historico(data);
	        		break;
	        	case('4'):
	        		data = receita.ColetarData();
	        		System.out.println(saldo.getSaldo(data));
	        		break;
	        	case('5'):
	        		System.out.println(saldo.getTotal());
	        		break;
	        }
		
	    //Condicao para sair do Menu
		}while(option != '0');
	}
}
