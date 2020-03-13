package com.example.primos.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NumeroPrimoTest {
	@Test
	public void shouldReturnTrue() {
		NumeroPrimo numeroPrimo = new NumeroPrimo();
		numeroPrimo.setValor(3);
		assertTrue(numeroPrimo.getPrimo());
	}

	@Test
	public void shouldReturnFalse() {
		NumeroPrimo numeroPrimo = new NumeroPrimo();
		numeroPrimo.setValor(4);
		assertFalse(numeroPrimo.getPrimo());
	}
}
