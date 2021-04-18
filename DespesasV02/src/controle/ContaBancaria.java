package controle;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import modelo.ArmazenaArquivoControle;
import modelo.DespesaControle;
import modelo.LeArquivoControle;
import modelo.ReceitaControle;
import modelo.SaldoControle;

import java.awt.event.*;

import view.Menu;
//import view.ReceitaView;

public class ContaBancaria {	
	public static void Menu() throws FileNotFoundException {
		//Obtem path do arquivo
		String filePathMapa = System.getProperty("user.dir");
		filePathMapa = filePathMapa + "dados.txt";
		String filePathSaldo = System.getProperty("user.dir");
		filePathSaldo = filePathSaldo + "saldo.txt";
		//Formata string de data
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data;
		HashMap<LocalDate, SaldoDiarioModelo> mapa = new HashMap<LocalDate, SaldoDiarioModelo>();
		//Inicializacao do construtor da classe
		SaldoControle saldo = new SaldoControle(mapa);
		LeArquivoControle LeArquivoControle  = new LeArquivoControle(mapa, filePathMapa, filePathSaldo);
		DespesaControle despesaControle = new DespesaControle(saldo);
		ReceitaControle receitaControle = new ReceitaControle (saldo);
		//ReceitaView receitaView = new ReceitaView();
		//Capta dados do arquivo 
		LeArquivoControle.PreencheMapa(saldo);
		LeArquivoControle.PreencheSaldo(saldo);
		
		Menu frame = new Menu(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
		//Inicializacao do construtor da classe
		ArmazenaArquivoControle armazena = new ArmazenaArquivoControle(mapa, filePathMapa, filePathSaldo, saldo);
		//Armazena dados do Mapa
		armazena.ImprimeMapa();
		armazena.ImprimeSaldo();
		System.out.println("saindo");
	}
}
