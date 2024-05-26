package dev.jp.currencyConverter.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jp.currencyConverter.model.CurrencyData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CurrencyApi {

    @Value("${api.key}")
    private String API_KEY;
    @Value("${base.url}")
    private String BASE_URL;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public CurrencyData obterDadosConversor(String currencyCode) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + API_KEY + currencyCode))
                .build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return gson.fromJson(json, CurrencyData.class);
    }
}