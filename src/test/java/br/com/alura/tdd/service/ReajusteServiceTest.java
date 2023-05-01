package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	private ReajusteService reajusteService;
	private Funcionario funcionario;
	
	@BeforeEach
	private void inicializar() {
		this.reajusteService = new ReajusteService();
		this.funcionario = new Funcionario("Felippe", LocalDate.now(), new BigDecimal("1000"));
		
	}
	
	@Test
	void deveriaReajustarSalarioEm3PorCentoQuandoDesempenhoForADesejar() {
		reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	void deveriaReajustarSalarioEm15PorCentoQuandoDesempenhoForBom() {
		reajusteService.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	@Test
	void deveriaReajustarSalarioEm30PorCentoQuandoDesempenhoForOtimo() {
		reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1300.00"), funcionario.getSalario());
		
	}
	
}
