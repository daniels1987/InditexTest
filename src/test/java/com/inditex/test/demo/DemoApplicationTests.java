package com.inditex.test.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	private final String url = "/prices/findByDateAndProductIdAndBrandId";
	@Autowired
	private MockMvc mockMvc;

    @Test
    void shouldReturnResult() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(url)
        		.param("date", "2020-06-14T10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        		.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
        
        mockMvc.perform(MockMvcRequestBuilders.get(url)
        		.param("date", "2020-06-14T16:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        		.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
        
        mockMvc.perform(MockMvcRequestBuilders.get(url)
        		.param("date", "2020-06-14T21:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        		.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
        
        mockMvc.perform(MockMvcRequestBuilders.get(url)
        		.param("date", "2020-06-15T10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        		.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
        
        mockMvc.perform(MockMvcRequestBuilders.get(url)
        		.param("date", "2020-06-16T21:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        		.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }
}
