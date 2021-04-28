package controle;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import modelo.ArmazenaArquivoModelo;
import modelo.DespesaModelo;
import modelo.LeArquivoModelo;
import modelo.ReceitaModelo;
import modelo.SaldoModelo;

import java.awt.event.*;

import view.Menu;
//import view.ReceitaView;

/**
 * Inicializa interface do usuario, classes, mapa e obtem o file path onde armazena os dados
 * @author danielalves
 * @version 2.0
 */
public class ContaBancaria {	
	public static void Menu() throws FileNotFoundException {
		//Obtem path do arquivo
		String filePathMapa = System.getProperty("user.dir");
		filePathMapa = filePathMapa + "dados.txt";
		String filePathSaldo = System.getProperty("user.dir");
		filePathSaldo = filePathSaldo + "saldo.txt";
		
		//Inicia Mapa
		HashMap<LocalDate, SaldoDiarioControle> mapa = new HashMap<LocalDate, SaldoDiarioControle>();
		
		//Inicializacao do construtor da classe
		SaldoModelo saldo = new SaldoModelo(mapa);
		LeArquivoModelo LeArquivoControle  = new LeArquivoModelo(mapa, filePathMapa, filePathSaldo);
		DespesaModelo despesaControle = new DespesaModelo(saldo);
		ReceitaModelo receitaControle = new ReceitaModelo (saldo);
		
		//Capta dados do arquivo 
		LeArquivoControle.PreencheMapa(saldo);
		LeArquivoControle.PreencheSaldo(saldo);
		
		//Chama interface
		Menu frame = new Menu(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
		//Inicializacao do construtor da classe
		ArmazenaArquivoModelo armazena = new ArmazenaArquivoModelo(mapa, filePathMapa, filePathSaldo, saldo);
		//Armazena dados do Mapa
		armazena.ImprimeMapa();
		armazena.ImprimeSaldo();
	}
}
