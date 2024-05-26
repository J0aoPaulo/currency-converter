package dev.jp.currencyConverter.main;

import dev.jp.currencyConverter.model.CurrencyData;
import dev.jp.currencyConverter.service.CurrencyApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

@Component
public class CurrencyRunner implements CommandLineRunner {

    @Autowired
    private CurrencyApi currencyApi = new CurrencyApi();

    private final Scanner input = new Scanner(System.in);
    private final StringBuilder sb01 = new StringBuilder();
    private final StringBuilder sb02 = new StringBuilder();
    Set<String> codes = new HashSet<>(Set.of("USD", "BRL", "JPY", "CNY", "ARS", "RUB"));

    @Override
    public void run(String... args) {
        menu();
    }

    private boolean currencyIsValid(String codeOriginal, String codeToConvert) {
        return codes.contains(codeOriginal) && codes.contains(codeToConvert);
    }

    public void menu() {
        while (true) {
            System.out.print("Digite a sigla da moeda que será convertida: ");
            String currencyOriginal = input.next();
            System.out.print("Digite a sigla da moeda para qual será convertida: ");
            String currencyConverted = input.next();

            if (currencyIsValid(currencyOriginal, currencyConverted)) {
                CurrencyData convertedData = currencyApi.obterDadosConversor(currencyOriginal);

                System.out.print("****************************************");
                sb02.append("Atualmente a convesão de ")
                        .append(currencyOriginal)
                        .append(" ->> ")
                        .append(currencyConverted)
                        .append(" é: ")
                        .append(convertedData.conversionRates().get(currencyConverted));
                System.out.println(sb01);
                System.out.println(sb02);
                System.out.print("****************************************");
                break;
            } else
                System.out.println("Por favor, digite os dados corretamente");
        }
    }
}