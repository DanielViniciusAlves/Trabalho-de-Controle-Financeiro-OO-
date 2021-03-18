import java.util.Stack;

public class transfer {
	//Instance Variables
    public Stack<Double> transferencias ;
    public double value;
    
    // Constructor of Class
    public transfer(Stack<Double> transferencias, double value )
    {
        this.transferencias = transferencias;
        this.value = value;
       
    }
    //Store the transfer realized in etruturaSaldo.Pilha
    public static Stack<Double> Operations(Stack<Double> transferencias, double value) {
    	//Add the value to the transferencias stack
    	transferencias.push(value); 
    	return transferencias;
    }
    //Get all transfers realized
    public static void Operations(Stack<Double> transferencias) {
    	System.out.println(transferencias);
    	
    }

}
