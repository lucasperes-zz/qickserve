package br.com.w2s.qickserve.model;

import java.math.BigDecimal;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class ItemOrderModel extends ModelBase {
	
	private ProductModel product;
	private Integer quantity;
	private BigDecimal priceUnity;
	private BigDecimal subtotal;
	private BigDecimal discount;
	private BigDecimal total;
	
	/**
	 * @return the product
	 */
	public ProductModel getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the priceUnity
	 */
	public BigDecimal getPriceUnity() {
		return priceUnity;
	}
	/**
	 * @param priceUnity the priceUnity to set
	 */
	public void setPriceUnity(BigDecimal priceUnity) {
		this.priceUnity = priceUnity;
	}
	/**
	 * @return the subtotal
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
