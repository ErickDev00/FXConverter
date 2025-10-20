package com.example.currencynow.controller;


import com.example.currencynow.dto.ConversionResponseDTO;
import com.example.currencynow.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping
    public ResponseEntity<ConversionResponseDTO> getConversion(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        ConversionResponseDTO responseDTO = conversionService.convertCurrency(from, to, amount);

        return ResponseEntity.ok(responseDTO);
    }

}
