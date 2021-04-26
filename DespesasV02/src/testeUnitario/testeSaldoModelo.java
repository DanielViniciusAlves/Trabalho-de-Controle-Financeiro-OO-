package testeUnitario;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import controle.SaldoControle;
import controle.SaldoDiarioControle;
import modelo.SaldoModelo;

class testeSaldoModelo {

	@Test
	void testAdicionaSaldoDiario() {
		HashMap<LocalDate, SaldoDiarioControle> mapa = new HashMap<LocalDate, SaldoDiarioControle>();
		SaldoModelo saldoModelo = new SaldoModelo(mapa);
		String data = "2021-01-01";
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		saldoModelo.AdicionaSaldoDiario(100.00, "conta de agua", LocalDate.parse(data, formatoData));
		assertEquals(saldoModelo.EmitirHistorico(LocalDate.parse(data, formatoData)), "{conta de agua=100.0}");
	}
	
	@Test
	void testRemoveHistorico() {
		HashMap<LocalDate, SaldoDiarioControle> mapa = new HashMap<LocalDate, SaldoDiarioControle>();
		SaldoModelo saldoModelo = new SaldoModelo(mapa);
		String data = "2021-01-01";
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		saldoModelo.AdicionaSaldoDiario(100.00, "conta de agua", LocalDate.parse(data, formatoData));
		saldoModelo.RemoveHistorico(LocalDate.parse(data, formatoData), "conta de agua");
		assertEquals(saldoModelo.EmitirHistorico(LocalDate.parse(data, formatoData)), "{}");
	}
	
	@Test
	void testSaldoTotal() {
		HashMap<LocalDate, SaldoDiarioControle> mapa = new HashMap<LocalDate, SaldoDiarioControle>();
		SaldoModelo saldoModelo = new SaldoModelo(mapa);
		saldoModelo.SaldoTotal(100.0);
		assertEquals(saldoModelo.getSaldoControle().getTotal().toString(), "100.0");
	}
}
