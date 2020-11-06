package br.com.w2s.qickserve.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class OrderModel extends ModelBase {
	
	private UserModel client;
	private LocalDateTime dateOrder;
	private List<ItemOrderModel> items;
	
	/**
	 * @return the client
	 */
	public UserModel getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(UserModel client) {
		this.client = client;
	}
	/**
	 * @return the dateOrder
	 */
	public LocalDateTime getDateOrder() {
		return dateOrder;
	}
	/**
	 * @param dateOrder the dateOrder to set
	 */
	public void setDateOrder(LocalDateTime dateOrder) {
		this.dateOrder = dateOrder;
	}
	/**
	 * @return the items
	 */
	public List<ItemOrderModel> getItems() {
		if(items == null) {
			items = new ArrayList<>();
		}
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<ItemOrderModel> items) {
		this.items = items;
	}
	
	// Metodos Auxiliares
	
	public void addItem(ItemOrderModel item) {
		if(items == null) {
			items = new ArrayList<>();
		}
		if(item.getTotal() == null || BigDecimal.ZERO.compareTo(item.getTotal()) >= 0) {
			throw new IllegalArgumentException("Não é possível adicionar itens com valor total zerado!");
		}
		
		items.add(item);
	}
	
	public void addItem(ProductModel product, Integer quantity) {
		ItemOrderModel item = new ItemOrderModel();
		item.setId(getItems().size() + 1L);
		item.setProduct(product);
		item.setQuantity(quantity);
		item.setPriceUnity(product.getPrice());
		item.setSubtotal(new BigDecimal(quantity).multiply(product.getPrice()));
		// Verifica o voucher
		BigDecimal vDesc = BigDecimal.ZERO;
		BigDecimal vLiq = item.getSubtotal();
		if(product.getVoucher() != null) {
			vDesc = new BigDecimal(quantity).multiply(product.getVoucher().getValue());
			vLiq = item.getSubtotal().subtract(vDesc);
		}
		item.setDiscount(vDesc);
		item.setTotal(vLiq);
		
		addItem(item);
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal value = BigDecimal.ZERO;
		if(items != null && !items.isEmpty()) {
			for(ItemOrderModel item : items) {
				value = value.add(item.getSubtotal());
			}
		}
		return value;
	}
	
	public BigDecimal getValorLiquido() {
		BigDecimal value = BigDecimal.ZERO;
		if(items != null && !items.isEmpty()) {
			for(ItemOrderModel item : items) {
				value = value.add(item.getTotal());
			}
		}
		return value;
	}
	
	public BigDecimal getValorVoucher() {
		return getValorTotal().subtract(getValorLiquido());
	}

}
