package com.example.primos.dominio;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class CalculaPrimosService {
    public boolean isPrimo(Integer numero) {
        if(numero == null) return false;
        return IntStream.rangeClosed(1, numero).filter(el -> numero%el == 0).count() == 2;
    }
}
