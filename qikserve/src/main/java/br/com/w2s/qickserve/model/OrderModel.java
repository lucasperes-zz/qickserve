package br.com.w2s.qickserve.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.w2s.qickserve.utils.AppUtils;

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
		if(product.getVouchers() != null && !product.getVouchers().isEmpty()) {
			VoucherModel voucher = product.getVouchers().get(0); // Avaliado a API WireMock e verificado que sempre retorna 1 no Array
			// Basic Percent
			if(TypeVoucher.FLAT_PERCENT.equals(voucher.getType())) {				
				vDesc = AppUtils.calculatePercent(item.getSubtotal(), voucher.getAmount());
				vLiq = item.getSubtotal().subtract(vDesc);
			}
			// Price Override
			else if(TypeVoucher.QTY_BASED_PRICE_OVERRIDE.equals(voucher.getType())) {
				// Verifica a quantidade minima
				if(quantity >= voucher.getRequiredQuantity()) {
					// Percorre as quantidades para dividir em pares de RequiredQuantity
					for(int i = 0; i <= (quantity - voucher.getRequiredQuantity());) {
						// Pega o valor original
						BigDecimal vOrig = new BigDecimal(voucher.getRequiredQuantity()).multiply(product.getPrice());
						vDesc = vDesc.add(vOrig.subtract(voucher.getPrice()));
						i += voucher.getRequiredQuantity();
					}
					vLiq = item.getSubtotal().subtract(vDesc);
				}
			}
			// Buy X Get Y
			else if(TypeVoucher.BUY_X_GET_Y_FREE.equals(voucher.getType())) {
				// Verifica a quantidade minima
				if(quantity >= voucher.getRequiredQuantity()) {
					// Percorre as quantidades para dividir em pares de RequiredQuantity
					for(int i = 0; i <= (quantity - voucher.getRequiredQuantity());) {
						vDesc = vDesc.add(new BigDecimal(voucher.getFreeQuantity()).multiply(product.getPrice()));
						i += voucher.getRequiredQuantity();
					}
					vLiq = item.getSubtotal().subtract(vDesc);
				}
			}
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
