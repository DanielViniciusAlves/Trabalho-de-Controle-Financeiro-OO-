package controle;

import java.time.LocalDate;

/**
 * Classe abstrata de DespesaControle e ReceitaControle
 * @author danielalves
 * @version 2.0
 */
abstract class OperacoesAbstratas {
	public abstract LocalDate getData();
	public abstract void setData(LocalDate data);			
	public abstract String getDescricao();
	public abstract void setDescricao(String descricao);
	public abstract Double getValor();
	public abstract void setValor(Double valor);
}
