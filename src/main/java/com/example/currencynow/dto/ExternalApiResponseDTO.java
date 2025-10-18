package com.example.currencynow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExternalApiResponseDTO {

    @JsonProperty("base_code")
    private String baseCode;

    @JsonProperty("target_code")
    private String targetCode;

    @JsonProperty("conversion_rate")
    private double conversionRate;

}
