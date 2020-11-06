package br.com.w2s.qickserve.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
@XmlRootElement
public class ProductModel extends ModelBase {

	private String name;
	private BigDecimal price;
	@XmlElement(name = "promotions")
	private List<VoucherModel> vouchers;
	
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
	 * @return the vouchers
	 */
	public List<VoucherModel> getVouchers() {
		return vouchers;
	}
	/**
	 * @param vouchers the vouchers to set
	 */
	public void setVouchers(List<VoucherModel> vouchers) {
		this.vouchers = vouchers;
	}
	
}
