package dev.jp.currencyConverter.main;

import dev.jp.currencyConverter.model.CurrencyData;
import dev.jp.currencyConverter.service.Converter;
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
            String moedas = """
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            Moedas disponiveis para conversao:
            USD - Dólar dos Estados Unidos
            EUR - Euro
            GBP - Libra Esterlina
            JPY - Iene Japonês
            CNY - Renminbi Chinês
            CHF - Franco Suíço
            CAD - Dólar Canadense
            AUD - Dólar Australiano
            NZD - Dólar da Nova Zelândia
            BRL - Real Brasileiro
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
           """;

            System.out.println(moedas);
            System.out.print("Digite o codigo da moeda que deseja converter: ");
            String currencyOriginal = input.next();
            System.out.print("Digite o codigo da moeda para qual deverá ser convertida: ");
            String currencyToConverted = input.next();

            if (currencyIsValid(currencyOriginal, currencyToConverted)) {
                System.out.println("Digite o valor a ser convertido: ");
                Double valueToConvert = input.nextDouble();

                CurrencyData currencyData = currencyApi.obterDadosConversor(currencyOriginal);
                double convertedValue =  Converter.conversion(valueToConvert, currencyToConverted, currencyData);

                System.out.print("****************************************");
                sb02.append("Atualmente a convesão de ")
                        .append(valueToConvert)
                        .append(" ->> ")
                        .append(currencyToConverted)
                        .append(" é: ")
                        .append(convertedValue);
                System.out.println(sb01);
                System.out.println(sb02);
                System.out.print("****************************************");
                break;
            } else
                System.out.println("Por favor, digite os dados corretamente");
        }
    }
}