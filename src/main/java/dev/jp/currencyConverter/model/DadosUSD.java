package dev.jp.currencyConverter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record DadosUSD(@Expose @SerializedName("conversion_rates") Map<String, Double> conversionRates) {
}
