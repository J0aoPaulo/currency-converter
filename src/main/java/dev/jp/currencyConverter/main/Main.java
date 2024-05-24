package dev.jp.currencyConverter.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jp.currencyConverter.model.DadosUSD;
import dev.jp.currencyConverter.service.CurrencyApi;

public class Main {

    private final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();
    private final CurrencyApi currencyApi = new CurrencyApi();

    public void menu() {
        String json = currencyApi.obterDadosConversor();
        DadosUSD dadosUSD = gson.fromJson(json, DadosUSD.class);
        System.out.println(dadosUSD);
    }
}
