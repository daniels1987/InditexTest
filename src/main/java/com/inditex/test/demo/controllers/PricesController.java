package com.inditex.test.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.test.demo.projections.PriceProjection;
import com.inditex.test.demo.services.PricesService;

@RestController
@RequestMapping(value = "prices", produces = "application/hal+json")
public class PricesController {

    @Autowired
    private PricesService pricesService;
    
	@GetMapping(value = "/findByDateAndProductIdAndBrandId")
	public ResponseEntity<List<PriceProjection>> findByDateAndProductIdAndBrandId(
			@RequestParam(value = "date", required = false) final LocalDateTime date, 
    		@RequestParam(value = "productId", required = false) final String productId, 
    		@RequestParam(value = "brandId", required = false) final String brandId) {
		
		if(date == null && productId == null && brandId == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok().body(pricesService.getPriceByDateAndProductIdAndBrandId(date, productId, brandId));
	}
}
