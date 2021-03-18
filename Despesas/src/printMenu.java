import java.util.*;
public class printMenu {
	public static String Date(String date) {
		Scanner read = new Scanner(System.in);
		String dateTemp;
        String[] arrOfStr = date.split("/"); 
        int day = Integer.parseInt(arrOfStr[0]);
        int mounth = Integer.parseInt(arrOfStr[0]);
        int year = Integer.parseInt(arrOfStr[0]);
        System.out.print("Digite a data desejada, no formato 00/00/0000:\n"); 
        dateTemp = read.next();
        arrOfStr = dateTemp.split("/"); 
        int dayTemp = Integer.parseInt(arrOfStr[0]);
        int mounthTemp = Integer.parseInt(arrOfStr[0]);
        int yearTemp = Integer.parseInt(arrOfStr[0]);
		while(year > yearTemp || mounth > mounthTemp && year == yearTemp || day > dayTemp && mounth == mounthTemp && year == yearTemp ) {
			System.out.print("Nao Eh uma date valida, digite a data desejada:\n"); 
			dateTemp = read.next();
	        arrOfStr = dateTemp.split("/"); 
	        dayTemp = Integer.parseInt(arrOfStr[0]);
	        mounthTemp = Integer.parseInt(arrOfStr[0]);
	        yearTemp = Integer.parseInt(arrOfStr[0]);
	        
		}
		return dateTemp;
	}
	
	public static Double Value() {
		Scanner read = new Scanner(System.in);
		double value;
        System.out.print("Digite o valor desejado:\n"); 
        while (!read.hasNextDouble()) {
          System.out.println("Nao Eh um numero valido");
          read.next(); // this is important!
        }  
        value = read.nextDouble();
	    
		return value;
		
	}
}