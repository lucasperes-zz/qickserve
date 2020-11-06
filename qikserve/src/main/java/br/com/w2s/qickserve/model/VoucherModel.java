package br.com.w2s.qickserve.model;

import java.math.BigDecimal;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class VoucherModel extends ModelBase {

	private BigDecimal value;

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
