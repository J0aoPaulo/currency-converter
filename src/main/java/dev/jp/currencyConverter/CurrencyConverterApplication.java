package dev.jp.currencyConverter;

import dev.jp.currencyConverter.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		Main main = new Main();
		main.menu();
	}
}