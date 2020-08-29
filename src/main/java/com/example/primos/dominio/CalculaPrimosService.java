package com.example.primos.dominio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.primos.entidades.NumeroPrimo;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CalculaPrimosService {
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/todos/";
	private static final Logger LOGGER = LogManager.getLogger(CalculaPrimosService.class);
	private static final String FIELD = "id";

	@SuppressWarnings("unchecked")
	public NumeroPrimo getPrimo() throws Exception {
		NumeroPrimo numeroPrimo = new NumeroPrimo();
		String response = getRequestBody();
		Map<String, Object> body = new ObjectMapper().readValue(response, HashMap.class);
		numeroPrimo.setValor((Integer) body.get(FIELD));
		return numeroPrimo;
	}

	private String getRequestBody() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(getUrl()).build();
		try (Response response = client.newCall(request).execute()) {
			String stringBody = response.body().string();
			LOGGER.info(stringBody);
			return stringBody;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getUrl() {
		Integer id = new Random().nextInt(10) + 1;
		return BASE_URL + id;

	}
}
