import java.util.*;
public class estruturaSaldo {
	//Instance Variables
    Double DesRec;
    Stack<Double> stack ;
    
    // Constructor of Class
    public estruturaSaldo(Stack<Double> stack, Double DesRec)
    {
        this.stack = stack;
        this.DesRec = DesRec;
    }
    //Class overload
    //Add to the Saldo value
    public static Stack<Double>  Pilha(Stack<Double> stack , Double DesRec)
	{
    	//Do the operation between the stack and value
    	double value = stack.peek() + DesRec;
    	//Store the value in the stack
    	stack.push(value); 
    	return stack;
	}
    //Get the Saldo value
    public static void Pilha(Stack<Double> stack  )
	{
    	System.out.println(stack.peek());
	}
    
    
}
