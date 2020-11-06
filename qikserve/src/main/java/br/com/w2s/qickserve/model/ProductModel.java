package br.com.w2s.qickserve.model;

import java.math.BigDecimal;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class ProductModel extends ModelBase {

	private String name;
	private BigDecimal price;
	private VoucherModel voucher;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the voucher
	 */
	public VoucherModel getVoucher() {
		return voucher;
	}
	/**
	 * @param voucher the voucher to set
	 */
	public void setVoucher(VoucherModel voucher) {
		this.voucher = voucher;
	}
	
}
