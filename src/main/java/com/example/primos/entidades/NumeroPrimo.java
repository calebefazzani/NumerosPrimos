package com.example.primos.entidades;

import java.util.stream.IntStream;

public class NumeroPrimo {
	private Integer valor;
	private Boolean primo;

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
//		setPrimo(IntStream.rangeClosed(1, getValor()).filter(el -> getValor() % el == 0).count() == 2);
	}

	public Boolean getPrimo() {
		return primo;
	}

	public void setPrimo(Boolean primo) {
		this.primo = primo;
	}

	public NumeroPrimo() {
	}

}
