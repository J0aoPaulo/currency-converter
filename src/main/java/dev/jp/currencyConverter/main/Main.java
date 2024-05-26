// Arquivo: src/main/java/dev/jp/currencyConverter/controller/Main.java
package dev.jp.currencyConverter.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jp.currencyConverter.model.DadosUSD;
import dev.jp.currencyConverter.service.CurrencyApi;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class Main {

    private final Scanner input = new Scanner(System.in);
    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private final CurrencyApi currencyApi = new CurrencyApi();
    private final StringBuilder sb01 = new StringBuilder();
    private final StringBuilder sb02 = new StringBuilder();

    public void menu() {
        System.out.print("Digite a sigla da moeda que será convertida: ");
        String currencyCodeOriginal = input.next();
        System.out.print("Digite a sigla da moeda para qual será convertida: ");
        String currencyCodeToConvert = input.next();

        String json = currencyApi.obterDadosConversor(currencyCodeOriginal);
        DadosUSD dadosUSD = gson.fromJson(json, DadosUSD.class);
        System.out.print("****************************************");
        sb02.append("Atualmente a convesão de ")
                .append(currencyCodeOriginal)
                .append(" ->> ")
                .append(currencyCodeToConvert)
                .append(" é: ")
                .append(dadosUSD.conversionRates().get(currencyCodeToConvert));
        System.out.println(sb01);
        System.out.println(sb02);
        System.out.print("****************************************");
    }
}