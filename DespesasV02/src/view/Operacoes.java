package view;
import java.time.LocalDate;

//Clase Abstrata Operacoes de Despesa e Receita
public abstract class Operacoes {
	
	protected abstract double ColetarValor();
	
	protected abstract LocalDate ColetarData();
	
	protected abstract String ColetarDescricao();
	
	
	
	
}
