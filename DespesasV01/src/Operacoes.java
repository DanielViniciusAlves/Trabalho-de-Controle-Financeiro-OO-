import java.time.LocalDate;
import java.util.*;
import org.javatuples.Pair; 

//Clase Abstrata Operacoes de Despesa e Receita
public abstract class Operacoes {
	
	protected abstract double ColetarValor();
	
	protected abstract LocalDate ColetarData();
	
	protected abstract String ColetarDescricao();
	
	protected abstract Map<LocalDate, Pair<Double, String>> Armazenar(LocalDate data, double valor, String desc);
	
	protected abstract Stack<Double> Armazenar(double valor);
	
	
	
}
