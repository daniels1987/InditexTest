package com.inditex.test.demo.projections;

import java.time.LocalDateTime;

public interface PriceProjection {

	public String getbrandId();
	
	public LocalDateTime getstartDate();
	
	public LocalDateTime getendDate();
	
	public String getPriceList();
	
	public String getProductId();
	
	public String getprice();
	
}
