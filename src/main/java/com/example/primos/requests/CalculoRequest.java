package com.example.primos.requests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primos.dominio.CalculaPrimosService;
import com.example.primos.entidades.NumeroPrimo;

@RestController
@RequestMapping("/api")
public class CalculoRequest {
	private static final Logger LOGGER = LogManager.getLogger(CalculoRequest.class);
	@Autowired
	private CalculaPrimosService service;
	
	@GetMapping("/") // http://localhost:8080/api/
	public ResponseEntity<NumeroPrimo> getCalculo() {
		try {
			NumeroPrimo primo = service.getPrimo();
			return new ResponseEntity<>(primo, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/")
	public ResponseEntity<NumeroPrimo> getCalculoPost() {
		return getCalculo();
	}
}
