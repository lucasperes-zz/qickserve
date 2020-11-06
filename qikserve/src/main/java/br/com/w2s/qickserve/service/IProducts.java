package br.com.w2s.qickserve.service;

import java.io.Serializable;
import java.util.List;

import br.com.w2s.qickserve.model.ProductModel;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public interface IProducts {
	
	List<ProductModel> list();
	
	List<ProductModel> list(String filter);
	
	ProductModel find(Serializable id);

}
