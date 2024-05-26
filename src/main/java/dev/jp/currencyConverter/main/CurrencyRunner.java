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
            String codesAvalible = """
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

            System.out.println(codesAvalible);
            System.out.print("Digite o codigo da moeda que deseja converter: ");
            String currencyOriginal = input.next();
            System.out.print("Digite o codigo da moeda para qual deverá ser convertida: ");
            String currencyToConverted = input.next();

            if (currencyIsValid(currencyOriginal, currencyToConverted)) {
                System.out.print("Digite o valor a ser convertido: ");
                Double valueToConvert = input.nextDouble();

                CurrencyData currencyData = currencyApi.obterDadosConversor(currencyOriginal);
                Double convertedValue =  Converter.conversion(valueToConvert, currencyToConverted, currencyData);

                System.out.println("******************************************************");
                sb01.append("Atualmente a convesão de ")
                        .append(valueToConvert)
                        .append("[").append(currencyOriginal).append("]")
                        .append(" ->> ")
                        .append(currencyToConverted)
                        .append(" é: ")
                        .append(String.format("%.2f", convertedValue));
                System.out.println(sb01);
                System.out.println("******************************************************");
                break;
            } else
                System.out.println("\nERRO!\nSomente serão aceitos os códigos das moedas disponíveis");
                System.out.println("\n! Por favor, digite o codigo novamente !\n");
        }
    }
}