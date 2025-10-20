package com.example.currencynow.service;

import com.example.currencynow.dto.ConversionResponseDTO;
import com.example.currencynow.dto.ExternalApiResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ConversionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.api.url}")
    private String apiUrl;

    @Value("${external.api.key}")
    private String apiKey;

    public ConversionResponseDTO convertCurrency(String from, String to, double amount){

        String url = UriComponentsBuilder.fromUriString(apiUrl)
                .pathSegment(apiKey, "pair", from, to)
                .toUriString();

        System.out.println("log: chamando api externa " + url);


        try{

            ExternalApiResponseDTO externalResponse = restTemplate.getForObject(url, ExternalApiResponseDTO.class);

            if (externalResponse == null){
                throw new RuntimeException("A resposta da api é nula ou inválida");
            }

            double rate = externalResponse.getConversionRate();
            double convertedAmount = amount * rate;

            ConversionResponseDTO responseDTO = new ConversionResponseDTO();

            responseDTO.setFromCurrency(externalResponse.getBaseCode());
            responseDTO.setToCurrency(externalResponse.getTargetCode());
            responseDTO.setOriginalAmount(amount);
            responseDTO.setConvertedAmount(convertedAmount);
            responseDTO.setRate(rate);

            return responseDTO;

        } catch (Exception e){

            e.printStackTrace();;

            System.err.println("Erro ao chamar API externa: " + e.getMessage());
            throw new RuntimeException("Falhou na hora de obter a conversão");
        }

    }

}
