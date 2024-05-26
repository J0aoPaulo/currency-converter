// Arquivo: src/main/java/dev/jp/currencyConverter/controller/Main.java
package dev.jp.currencyConverter.main;

import dev.jp.currencyConverter.model.DadosUSD;
import dev.jp.currencyConverter.service.CurrencyApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private CurrencyApi currencyApi = new CurrencyApi();

    private final Scanner input = new Scanner(System.in);
    private final StringBuilder sb01 = new StringBuilder();
    private final StringBuilder sb02 = new StringBuilder();

    @Override
    public void run(String... args) {
        menu();
    }

    public void menu() {
        System.out.print("Digite a sigla da moeda que será convertida: ");
        String currencyCodeOriginal = input.next();
        System.out.print("Digite a sigla da moeda para qual será convertida: ");
        String currencyCodeToConvert = input.next();
        DadosUSD dadosConversao = currencyApi.obterDadosConversor(currencyCodeOriginal);

        System.out.print("****************************************");
        sb02.append("Atualmente a convesão de ")
                .append(currencyCodeOriginal)
                .append(" ->> ")
                .append(currencyCodeToConvert)
                .append(" é: ")
                .append(dadosConversao.conversionRates().get(currencyCodeToConvert));
        System.out.println(sb01);
        System.out.println(sb02);
        System.out.print("****************************************");
    }
}