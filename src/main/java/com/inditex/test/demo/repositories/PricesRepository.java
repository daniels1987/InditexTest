package com.inditex.test.demo.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inditex.test.demo.entities.Prices;
import com.inditex.test.demo.projections.PriceProjection;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

	@Query(value = "SELECT p FROM Prices p WHERE p.productId = :productId AND p.brandId = :brandId "
			+ "AND :date BETWEEN p.startDate AND p.endDate")
	List<PriceProjection> findPriceByDateAndProductIdAndBrandId(
			@Param("date") LocalDateTime date, 
	        @Param("productId") String productId, 
	        @Param("brandId") String brandId);
}
