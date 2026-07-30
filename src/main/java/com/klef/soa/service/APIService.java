package com.klef.soa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.soa.dto.ProductDTO;
@Service
public interface APIService
{
	
	List<ProductDTO> displayALLProducts();
	ProductDTO displayProductById(int id);
	
}
