package com.example.primos.dominio;

import java.io.IOException;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class CalculaPrimosService {
	private static final Logger LOGGER = LogManager.getLogger(CalculaPrimosService.class);
    public boolean isPrimo(Integer numero) {
    	getUrl("https://jsonplaceholder.typicode.com/todos/1");
        if(numero == null) return false;
        return IntStream.rangeClosed(1, numero).filter(el -> numero%el == 0).count() == 2;
    }
    
    private void getUrl(String url) {
    	OkHttpClient client = new OkHttpClient();
    	Request request = new Request.Builder()
    						  .url(url)
    						  .build();
    	try(Response response = client.newCall(request).execute()) {
    		//System.out.println(response.body().string());
    		LOGGER.info(response.body().string());
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
