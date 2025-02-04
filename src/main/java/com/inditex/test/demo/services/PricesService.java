package com.inditex.test.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.test.demo.projections.PriceProjection;
import com.inditex.test.demo.repositories.PricesRepository;

@Service
public class PricesService {

	@Autowired
	private PricesRepository pricesRepository;
	/**
	 * 
	 * @param date
	 * @param productId
	 * @param brandId
	 * @return
	 */
	public List<PriceProjection> getPriceByDateAndProductIdAndBrandId (final LocalDateTime date, final String productId, 
			final String brandId) {

		return pricesRepository.findPriceByDateAndProductIdAndBrandId(date, productId, brandId);
	}
}
