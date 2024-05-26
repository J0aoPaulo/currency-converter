package dev.jp.currencyConverter.service;

import dev.jp.currencyConverter.model.CurrencyData;

public class Converter {

    public static double conversion(Double currencyValue, String currencyToConvert, CurrencyData currencyData) {
            return currencyValue * currencyData.conversionRates().get(currencyToConvert);
    }
}
