package br.com.w2s.qickserve.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
@XmlRootElement
public class VoucherModel extends ModelBase {

	private BigDecimal price;
	private TypeVoucher type;
	
	@XmlElement(name = "required_qty")
	private Integer requiredQuantity;
	
	@XmlElement(name = "free_qty")
	private Integer freeQuantity;
	
	private BigDecimal amount;

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
	 * @return the type
	 */
	public TypeVoucher getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeVoucher type) {
		this.type = type;
	}

	/**
	 * @return the requiredQuantity
	 */
	public Integer getRequiredQuantity() {
		return requiredQuantity;
	}

	/**
	 * @param requiredQuantity the requiredQuantity to set
	 */
	public void setRequiredQuantity(Integer requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}

	/**
	 * @return the freeQuantity
	 */
	public Integer getFreeQuantity() {
		return freeQuantity;
	}

	/**
	 * @param freeQuantity the freeQuantity to set
	 */
	public void setFreeQuantity(Integer freeQuantity) {
		this.freeQuantity = freeQuantity;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
