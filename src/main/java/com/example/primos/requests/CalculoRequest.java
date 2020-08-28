package com.example.primos.requests;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primos.dominio.CalculaPrimosService;
import com.example.primos.entidades.NumeroPrimo;

@RestController
@RequestMapping("/api")
public class CalculoRequest {
	
	@Autowired
	private CalculaPrimosService service;
	
	@GetMapping("/")
	public ResponseEntity<NumeroPrimo> getCalculo(@PathParam(value = "valor") NumeroPrimo valor) {
		if (valor.getValor() == null)
			return new ResponseEntity<>(valor, HttpStatus.NO_CONTENT);
		
		NumeroPrimo retorno = new NumeroPrimo();
		retorno.setValor(valor.getValor());
		retorno.setPrimo(service.isPrimo(valor.getValor()));
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<NumeroPrimo> getCalculoPost(@RequestBody NumeroPrimo valor) {
		return getCalculo(valor);
	}
}
