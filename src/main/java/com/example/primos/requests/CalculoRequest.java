package com.example.primos.requests;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primos.entidades.NumeroPrimo;

@RestController
@RequestMapping("/api")
public class CalculoRequest {
	@GetMapping("/")
	public ResponseEntity<NumeroPrimo> getCalculo(@PathParam(value = "valor") NumeroPrimo valor) {
		if (valor.getValor() == null)
			return new ResponseEntity<>(valor, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(valor, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<NumeroPrimo> getCalculoPost(@RequestBody NumeroPrimo valor) {
		return getCalculo(valor);
	}
}
