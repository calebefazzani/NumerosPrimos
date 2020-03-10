package com.example.primos.requests;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primos.dominio.CalculaPrimosService;

@RestController
@RequestMapping("/api")
public class CalculoRequest {
	private CalculaPrimosService calculaPrimos;
	
	public CalculoRequest(CalculaPrimosService calculaPrimos) {
		this.calculaPrimos = calculaPrimos;
	}
	
	@GetMapping("/")
	public Boolean getCalculo(@PathParam(value = "valor") Integer valor) {
		if(valor == null) return false;
		return calculaPrimos.isPrimo(valor);
	}
	
}
