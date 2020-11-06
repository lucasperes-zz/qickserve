package br.com.w2s.qickserve.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.w2s.qickserve.model.ProductModel;
import br.com.w2s.qickserve.model.VoucherModel;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class ProductsService {
	
	public List<ProductModel> list() {
		List<ProductModel> products = new ArrayList<>();
		
		ProductModel prod1 = new ProductModel();
		prod1.setId(1L);
		prod1.setName("COCA COLA 2L");
		prod1.setPrice(new BigDecimal("8.90"));
		products.add(prod1);
		
		ProductModel prod2 = new ProductModel();
		prod2.setId(2L);
		prod2.setName("BOLACHA MABEL 60G MORANGO");
		prod2.setPrice(new BigDecimal("2.30"));
		products.add(prod2);
		
		ProductModel prod3 = new ProductModel();
		prod3.setId(3L);
		prod3.setName("BOLACHA MABEL 60G CHOCOLATE");
		prod3.setPrice(new BigDecimal("2.30"));
		products.add(prod3);
		
		// Produto com voucher de desconto
		ProductModel prod4 = new ProductModel();
		prod4.setId(4L);
		prod4.setName("ARROZ CRISTAL 5KG");
		prod4.setPrice(new BigDecimal("27"));
		// Desconto
		VoucherModel vProd1 = new VoucherModel();
		vProd1.setId(1L);
		vProd1.setValue(new BigDecimal("2.25"));
		prod4.setVoucher(vProd1);
		products.add(prod4);
		
		ProductModel prod5 = new ProductModel();
		prod5.setId(5L);
		prod5.setName("OLEO DE SOJA 1L");
		prod5.setPrice(new BigDecimal("5.50"));
		products.add(prod5);
		
		ProductModel prod6 = new ProductModel();
		prod6.setId(6L);
		prod6.setName("MACARRAO BONASA 120G");
		prod6.setPrice(new BigDecimal("4.20"));
		// Desconto
		VoucherModel vProd2 = new VoucherModel();
		vProd2.setId(2L);
		vProd2.setValue(new BigDecimal("0.20"));
		prod6.setVoucher(vProd2);
		products.add(prod6);
		
		ProductModel prod7 = new ProductModel();
		prod7.setId(7L);
		prod7.setName("CREME DE LEITE PIRACANJUGA 80G");
		prod7.setPrice(new BigDecimal("2.80"));
		products.add(prod7);
		
		ProductModel prod8 = new ProductModel();
		prod8.setId(8L);
		prod8.setName("FEIJAO COMBRASIL 1KG");
		prod8.setPrice(new BigDecimal("9.75"));
		// Desconto
		VoucherModel vProd3 = new VoucherModel();
		vProd3.setId(3L);
		vProd3.setValue(new BigDecimal("2"));
		prod8.setVoucher(vProd3);
		products.add(prod8);
		
		ProductModel prod9 = new ProductModel();
		prod9.setId(9L);
		prod9.setName("FARINHA DE TRIGO SOTRIGO 1KG");
		prod9.setPrice(new BigDecimal("5"));
		products.add(prod9);
		
		ProductModel prod10 = new ProductModel();
		prod10.setId(10L);
		prod10.setName("FANTA LARANJA 2L");
		prod10.setPrice(new BigDecimal("7.50"));
		products.add(prod10);
		
		ProductModel prod11 = new ProductModel();
		prod11.setId(11L);
		prod11.setName("CAIXA CHOCOLATE GAROTO SORTIDOS");
		prod11.setPrice(new BigDecimal("10"));
		products.add(prod11);
		
		return products;
	}
	
	public List<ProductModel> list(String filter) {
		if(filter != null) {
			return list().stream()
					.filter(prod -> {
						return prod.getName().toLowerCase().contains(filter.toLowerCase())
								|| prod.getId().toString().equals(filter);
					})
					.collect(Collectors.toList());
		} else {
			return list();
		}
	}

}
