package modelo;
import java.io.FileNotFoundException;

import controle.ContaBancaria;
 /**
  * Classe main que incia progrma
  * @author danielalves
  * @version 2.0
  */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		//Classe responsasavel pelo Menu
		ContaBancaria.Menu();
	}
}
