package view;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import controle.ArmazenaArquivoControle;
import controle.DespesaControle;
import controle.LeArquivoControle;
import controle.ReceitaControle;
import controle.SaldoControle;
import modelo.SaldoDiarioModelo;

public class ContaBancaria {	
	public static void Menu() throws FileNotFoundException {
		//Obtem path do arquivo
		String filePath = System.getProperty("user.dir");
		filePath = filePath + "\\dados.txt";
		//Formata string de data
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data;
		HashMap<LocalDate, SaldoDiarioModelo> mapa = new HashMap<LocalDate, SaldoDiarioModelo>();
		//Inicializacao do construtor da classe
		SaldoControle saldo = new SaldoControle(mapa);
		LeArquivoControle leArquivo = new LeArquivoControle(mapa, filePath);
		DespesaControle despesaControle = new DespesaControle(saldo);
		ReceitaControle receitaControle = new ReceitaControle (saldo);
		ReceitaView receitaView = new ReceitaView();
		//Capta dados do arquivo 
		leArquivo.PreencheMapa(saldo);
		//Objeto para ler input
		Scanner read = new Scanner(System.in);
		char option;
		String descricao;
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
	        		despesaControle.AddDespesa();
	        		break;
	        	case('2'):
	        		receitaControle.AddReceita();
	        		break;
	        	case('3'):
	        		System.out.print("Digite a Data(yyyy-MM-dd) ");
		    		data = LocalDate.parse(read.next(), formatoData);
		    		
		    		System.out.print("Digite a opcao desejada:\n"); 
			        System.out.print("1.Vizualizar operacoes:\n"); 
			        System.out.print("2.Remover operacao:\n");
			        option = read.next().charAt(0); 
			        switch(option) {
			        
				        case('1'):
				        	saldo.EmitirHistorico(data);
				        	break;
				        
				        
				        case('2'):
				        	System.out.print("Digite a descricao que sera deletada:\n"); 
				        	descricao = read.next();
				        	saldo.RemoveHistorico(data, descricao);
				        	break;
			        }
	        		break;
	        	case('4'):
	        		data = receitaView.ColetarData();
	        		System.out.println(saldo.getSaldo(data));
	        		break;
	        	case('5'):
	        		System.out.println(saldo.getTotal());
	        		break;
	        }
		
	    //Condicao para sair do Menu
		}while(option != '0');
		//Inicializacao do construtor da classe
		ArmazenaArquivoControle armazena = new ArmazenaArquivoControle(mapa, filePath);
		//Armazena dados do Mapa
		armazena.Imprime();
		System.out.println("saindo");
	}
}
