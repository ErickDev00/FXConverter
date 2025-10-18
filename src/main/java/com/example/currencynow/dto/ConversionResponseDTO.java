package com.example.currencynow.dto;

import lombok.Data;

@Data
public class ConversionResponseDTO {
    private String fromCurrency;
    private String toCurrency;
    private double originalAmount;
    private double convertedAmount;
    private double rate;

}
