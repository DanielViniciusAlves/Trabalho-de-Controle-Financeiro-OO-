import java.util.*;
public class estruturaSaldo {
	//Instance Variables
    int DesRec;
    public static Stack<Integer> stack = new Stack<Integer>();
    // Constructor of Class
    public estruturaSaldo( int DesRec, Stack<Integer> stack)
    {
    	estruturaSaldo.stack = stack;
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
    public static void Pilha(int value )
	{
    	stack.push(value); 
    	System.out.println(stack);
	}
    
    
}
