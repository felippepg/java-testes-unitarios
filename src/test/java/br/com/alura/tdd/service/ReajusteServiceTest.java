package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	@Test
	void deveriaReajustarSalarioEm3PorCentoQuandoDesempenhoForADesejar() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Felippe", LocalDate.now(), new BigDecimal("1000"));
		reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	void deveriaReajustarSalarioEm15PorCentoQuandoDesempenhoForBom() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Felippe", LocalDate.now(), new BigDecimal("1000"));
		reajusteService.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	@Test
	void deveriaReajustarSalarioEm30PorCentoQuandoDesempenhoForOtimo() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Felippe", LocalDate.now(), new BigDecimal("1000"));
		reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1300.00"), funcionario.getSalario());
		
	}
	
}
