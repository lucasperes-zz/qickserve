package br.com.w2s.qickserve.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import br.com.w2s.qickserve.model.ProductModel;
import br.com.w2s.qickserve.model.VoucherModel;
import br.com.w2s.qickserve.utils.AppUtils;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class ProductsRestWireMockService implements IProducts {
	
	private Client client;

	public ProductsRestWireMockService() {
		client = ClientBuilder.newClient();
	}
	
	@Override
	public List<ProductModel> list() {
		WebTarget target = client
				.target(AppUtils.URL_API)
				.path("products");
		
		Invocation.Builder invoc = target.request(MediaType.APPLICATION_JSON);
		
		List<ProductModel> products = invoc.get(new GenericType<List<ProductModel>>(){});
		// Corrige o valor em centavos
		products.forEach(prod -> prod.setPrice(AppUtils.convertCentsOnReal(prod.getPrice())));
		
		return products;
	}

	@Override
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

	@Override
	public ProductModel find(Serializable id) {
		WebTarget target = client
				.target(AppUtils.URL_API)
				.path("products/" + id);
		
		Invocation.Builder invoc = target.request(MediaType.APPLICATION_JSON);
		
		ProductModel product = invoc.get(new GenericType<ProductModel>(){});
		// Corrige o valor em centavos
		product.setPrice(AppUtils.convertCentsOnReal(product.getPrice()));
		if(product.getVouchers() != null && !product.getVouchers().isEmpty()) {
			for(VoucherModel voucher :  product.getVouchers()) {
				if(voucher.getPrice() != null) {
					voucher.setPrice(AppUtils.convertCentsOnReal(voucher.getPrice()));
				}
			}
		}
		
		return product;
	}
	
}
